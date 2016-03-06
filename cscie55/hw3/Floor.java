package cscie55.hw3;

import java.util.ArrayList;
import java.util.List;

/**
* The Floor implements functionality of Floor in a Building.
*
* @author  Sanjay Tiwari
* @version 1.0
* @since   2016-02-21
*/

/**
* The Floor class implements functionality of Floor in a Building.
*/
public class Floor
{

    /**
    * Floor Constructor
    * @param building is the Building Object to which this Floor belongs
    * @param floorNumber is floor number this Object represents
    */
    public Floor(Building building, int floorNumber)
    {
        floor               = floorNumber;
        passengers_waiting  = 0;
    }

    /**
    * This method returns the number of passengers Waiting on that Floor
    * @return int This returns number of passengers Waiting on that Floor.
    */
    public int passengersWaiting()
    {
        return passengers_waiting;
    }

    /**
    * This method takes passengers boarded and adjusts the total passengers
    * still waiting
    * @param passengers_boarded is number of passengers no longer waiting
    * @param src is caller Object instance, this is currently limited to be
    * only called from Elevator Object
    */
    protected void passengersBoarded(int passengers_boarded, Object src)
    {
        if(src instanceof Elevator)
        {
            if(passengers_waiting >= passengers_boarded)
            {
                passengers_waiting -= passengers_boarded;
            }
        }
    }

    /**
    * This method adds a passengers request for boarding the Elevator and adds
    * itself to the wait list
    */
    public void waitForElevator()
    {
        passengers_waiting++;
    }

    /**
    * This method prints state of the object at any instant of time
    * @return String This returns Floor State
    */
    public String toString()
    {
        resident = new PassengerS();
        Passenger p1 = new Passenger();
        resident.add(p1);
        return "Floor number " + (floor) + ": " + passengers_waiting + " passengers waiting";
    }

    private int passengers_waiting;
    private int floor;
    private PassengerS resident;
    private PassengerS up_waiting;
    private PassengerS down_waiting;
    ArrayList<Passenger> consider_this_instead = new ArrayList<Passenger> ();
}
