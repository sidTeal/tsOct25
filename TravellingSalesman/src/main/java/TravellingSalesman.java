
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class TravellingSalesman {

    public static final int NUM_OF_LOCATIONS = 46;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ExcelReader excelReader = new ExcelReader();

        ArrayList<Location> locations = new ArrayList<>();
        Random rand = new Random();

        double distances[][] = new double[NUM_OF_LOCATIONS][NUM_OF_LOCATIONS]; // 2d array holding distances between locations

        // read input file into arrayLists
        ArrayList<String> codes = excelReader.columnToArrayListAsString("input.xlsx", 0);
        ArrayList<Double> latitudes = excelReader.columnToArrayListAsDouble("input.xlsx", 1);
        ArrayList<Double> longitudes = excelReader.columnToArrayListAsDouble("input.xlsx", 2);
        ArrayList<String> names = excelReader.columnToArrayListAsString("input.xlsx", 3);
        ArrayList<String> locatedIns = excelReader.columnToArrayListAsString("input.xlsx", 4);

        // build list of locations
        for (int i = 0; i < NUM_OF_LOCATIONS; i++) {
            Location tempLocation = new Location(codes.get(i), names.get(i), locatedIns.get(i), latitudes.get(i), longitudes.get(i));
            locations.add(tempLocation);
        }

        // build distances array
        for (int i = 0; i < NUM_OF_LOCATIONS; i++) {
            for (int j = 0; j < NUM_OF_LOCATIONS; j++) {
                distances[i][j] = Haversine.calc(locations.get(i).getLatitude(), locations.get(i).getLongitude(),
                        locations.get(j).getLatitude(), locations.get(j).getLongitude());
            }
        }
//            
//            // test locations list
//            for(Location location : locations) {
//                System.out.println(location.getCode() + "\t" + location.getLatitude() + "\t" + location.getLongitude() + "\t" + 
//                        location.getName() + "\t" + location.getLocatedIn());
//            }
//            
//            // test distances
//            for (int i = 0; i < NUM_OF_LOCATIONS; i++) {
//                for (int j = 0; j < NUM_OF_LOCATIONS; j++) {
//                    System.out.println(locations.get(i).getCode() + " to " + locations.get(j).getCode() + 
//                            ": " + distances[i][j] + " km");
//                }
//            }

        //create initial 10 routes
        ArrayList<Route> parentRoutes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> initialSolution = InitialSolution.initialSolution();
            double dist = 0;

            for (int j = 0; j < initialSolution.size() - 1; j++) {
                dist += distances[initialSolution.get(j)][initialSolution.get(j + 1)];
            }
            parentRoutes.add(new Route(initialSolution, dist));
        }

        // sort routes by distance
        for (int i = 1; i < parentRoutes.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (parentRoutes.get(j).distance < parentRoutes.get(j - 1).distance) {
                    Collections.swap(parentRoutes, j, j - 1);
                }
            }
        }

        System.out.println("*******************************************************************");
        System.out.println("Initial Routes");
        System.out.println("*******************************************************************");
        //print routes
        for (int i = 0; i < 10; i++) {
            System.out.println(parentRoutes.get(i).route);
            System.out.println(parentRoutes.get(i).distance);
            System.out.println("");
        }
        for (int iterations = 0; iterations < 1000000; iterations++) {
            for (int i = 0; i < 50; i++) {
                int index = Roulette.roulette();

                //= parentRoutes.get(index);
                ArrayList<Integer> tempRoute = new ArrayList<>();
                for (int j = 0; j < parentRoutes.get(index).route.size() - 1; j++) {
                    tempRoute.add(parentRoutes.get(index).route.get(j));
                }
                tempRoute.remove(Integer.valueOf(0));
                //tempRoute.route.remove(tempRoute.route.size()-1);
                int randomRoll = rand.nextInt(((tempRoute.size() - 1)) + 1) + 1;
                int randomRoll2 = rand.nextInt(((tempRoute.size() - 1)) + 1) + 1;
                while (randomRoll2 == randomRoll) {
                    randomRoll2 = rand.nextInt(((tempRoute.size() - 1)) + 1) + 1;
                }
                int index1, index2;
                if (randomRoll <= randomRoll2) {
                    index1 = randomRoll;
                    index2 = randomRoll2;
                } else {
                    index1 = randomRoll2;
                    index2 = randomRoll;
                }
                Collections.shuffle(tempRoute.subList(index1, index2));
                tempRoute.add(0, 0);
                tempRoute.add(0);

                double dist = 0;

                for (int j = 0; j < tempRoute.size() - 1; j++) {
                    dist += distances[tempRoute.get(j)][tempRoute.get(j + 1)];
                }
                Route tempChildRoute = new Route(tempRoute, dist);

                boolean isUnique = true;
                if (tempChildRoute.distance < parentRoutes.get(9).distance) {
                    for (int j = 0; j < parentRoutes.size(); j++) {
                        if (parentRoutes.get(j).distance == tempChildRoute.distance) {
                            isUnique = false;
                            break;
                        }
                    }
                    if (isUnique) {
                        parentRoutes.remove(9);
                        parentRoutes.add(tempChildRoute);

                        // sort routes by distance
                        for (int k = 1; k < parentRoutes.size(); k++) {
                            for (int j = k; j > 0; j--) {
                                if (parentRoutes.get(j).distance < parentRoutes.get(j - 1).distance) {
                                    Collections.swap(parentRoutes, j, j - 1);
                                }
                            }
                        }
                    }
                }
                //System.out.println(tempChildRoute.route + " \n" + tempChildRoute.distance);
                //System.out.println(parentRoutes.get(9).route);

            }
        }

        System.out.println("*******************************************************************");
        System.out.println("FINAL ROUTES");
        System.out.println("*******************************************************************");
        //print routes
        for (int i = 0; i < parentRoutes.size(); i++) {
            System.out.println(parentRoutes.get(i).route);
            for (int j = 0; j < parentRoutes.get(i).route.size(); j++) {
                System.out.print(locations.get(parentRoutes.get(i).route.get(j)).getLocatedIn() + ", ");
            }
            System.out.println("");
            System.out.println("DISTANCE: " + parentRoutes.get(i).distance + " km");
            System.out.println("");
        }
    }

}
