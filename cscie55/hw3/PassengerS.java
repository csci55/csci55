package cscie55.hw3;

import java.util.ArrayList;

/**
* The PassengerS implements functionality of a Collection to hold list of
* Passengers on a Floor.
*
* @author  Sanjay Tiwari
* @version 1.0
* @since   2016-02-27
*/

/**
* The PassengerS class extends ArrayList.
*/
public class PassengerS<Passenger> extends ArrayList<Passenger>
{
    /**
    * This method prints state of the object at any instant of time
    * @return String This returns Floor State
    */
    public String toString() {

        return "Passenger count " + (this.size()) ;
    }

}
