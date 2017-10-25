/*
 * ***************************************************
 * Class Name: State 
 * Author: Chris Tisdale
 * **************************************************** 
 * Purpose of the class:
 * This class defines the State object through private field variables
 *      and corresponding getter and setter methods.
 * **************************************************** 
 * September 11, 2017
 * *****************************************************
 */
public final class Location {

    private String code;
    private String name;
    private String locatedIn;
    private double latitude;
    private double longitude;

    /*
     * ***************************************************
     * Constructor: State 
     * Author: Chris Tisdale
     * ***************************************************** 
     * Purpose: instantiate State object with passed arguments.
     * Constructor parameters: String name, double x_degreeAndIncome, double y_crimeRate
     * ***************************************************** 
     * Date: September 11, 2017
     * ****************************************************
     */
    Location(String code, String name, String locatedIn, double latitude, double longitude) {
        setCode(code);
        setName(name);
        setLocatedIn(locatedIn);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    /*
     * ***************************************************
     * Method Name: setName 
     * Author: Chris Tisdale
     * ***************************************************** 
     * Purpose of the Method: sets name of State
     * Method parameters: String name
     * Return value: void
     * ***************************************************** 
     * Date: September 11, 2017
     * ****************************************************
     */
    public void setCode(String code) {
        this.code = code;
    }

    /*
     * ***************************************************
     * Method Name: getName 
     * Author: Chris Tisdale
     * ***************************************************** 
     * Purpose of the Method: return name of State
     * Method parameters: none
     * Return value: String
     * ***************************************************** 
     * Date: September 11, 2017
     * ****************************************************
     */
    public String getCode() {
        return code;
    }

    /*
     * ***************************************************
     * Method Name: setName 
     * Author: Chris Tisdale
     * ***************************************************** 
     * Purpose of the Method: sets name of State
     * Method parameters: String name
     * Return value: void
     * ***************************************************** 
     * Date: September 11, 2017
     * ****************************************************
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * ***************************************************
     * Method Name: getName 
     * Author: Chris Tisdale
     * ***************************************************** 
     * Purpose of the Method: return name of State
     * Method parameters: none
     * Return value: String
     * ***************************************************** 
     * Date: September 11, 2017
     * ****************************************************
     */
    public String getName() {
        return name;
    }

    /*
     * ***************************************************
     * Method Name: setName 
     * Author: Chris Tisdale
     * ***************************************************** 
     * Purpose of the Method: sets name of State
     * Method parameters: String name
     * Return value: void
     * ***************************************************** 
     * Date: September 11, 2017
     * ****************************************************
     */
    public void setLocatedIn(String locatedIn) {
        this.locatedIn = locatedIn;
    }

    /*
     * ***************************************************
     * Method Name: getName 
     * Author: Chris Tisdale
     * ***************************************************** 
     * Purpose of the Method: return name of State
     * Method parameters: none
     * Return value: String
     * ***************************************************** 
     * Date: September 11, 2017
     * ****************************************************
     */
    public String getLocatedIn() {
        return locatedIn;
    }

    /*
     * ***************************************************
     * Method Name: setX 
     * Author: Chris Tisdale
     * ***************************************************** 
     * Purpose of the Method: sets x coord (degree and income) of State
     * Method parameters: double x_degreeAndIncome
     * Return value: void
     * ***************************************************** 
     * Date: September 11, 2017
     * ****************************************************
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /*
     * ***************************************************
     * Method Name: getX 
     * Author: Chris Tisdale
     * ***************************************************** 
     * Purpose of the Method: gets x coord of State
     * Method parameters: none
     * Return value: double
     * ***************************************************** 
     * Date: September 11, 2017
     * ****************************************************
     */
    public Double getLatitude() {
        return latitude;
    }

    /*
     * ***************************************************
     * Method Name: setX 
     * Author: Chris Tisdale
     * ***************************************************** 
     * Purpose of the Method: sets x coord (degree and income) of State
     * Method parameters: double x_degreeAndIncome
     * Return value: void
     * ***************************************************** 
     * Date: September 11, 2017
     * ****************************************************
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /*
     * ***************************************************
     * Method Name: getX 
     * Author: Chris Tisdale
     * ***************************************************** 
     * Purpose of the Method: gets x coord of State
     * Method parameters: none
     * Return value: double
     * ***************************************************** 
     * Date: September 11, 2017
     * ****************************************************
     */
    public Double getLongitude() {
        return longitude;
    }

}
