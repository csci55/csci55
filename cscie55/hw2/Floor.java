package cscie55.hw2;

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
    */
    public void passengersBoarded(int passengers_boarded)
    {
        if(passengers_waiting >= passengers_boarded)
        {
            passengers_waiting -= passengers_boarded;
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
    public String toString() {

        return "Floor number " + (floor) + ": " + passengers_waiting + " passengers waiting";
    }

    private int passengers_waiting;
    private int floor;
}
