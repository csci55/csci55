package cscie55.hw3;

/**
* The Passenger implements functionality of a Passenger on a Floor.
*
* @author  Sanjay Tiwari
* @version 1.0
* @since   2016-02-27
*/

/**
* The Passenger class implements functionality of Passenger on a Floor.
*/
public class Passenger
{

    /**
    * Passenger Constructor
    * @param building is the Building Object to which this Floor belongs
    * @param floorNumber is floor number this Object represents
    */
    public Passenger()
    {

    }

    /**
    * This method returns Passenger's current floor
    */
    public int currentFloor()
    {
        return current_floor;
    }

    /**
    * This method returns the number of passengers Waiting on that Floor
    * @return int This returns number of passengers Waiting on that Floor.
    */
    public int destinationFloor()
    {
        return destined_floor;
    }

    /**
    * This method takes passengers boarded and adjusts the total passengers
    * still waiting
    * @param int newDestinationFloor is new destined floor
    */
    public void waitForElevator(int newDestinationFloor)
    {
    }

    /**
    * This method takes passengers boarded and adjusts the total passengers
    * still waiting
    */
    public void boardElevator()
    {
    }

    /**
    * This method takes passengers boarded and adjusts the total passengers
    * still waiting
    */
    public void arrive()
    {
    }

    /**
    * This method prints state of the object at any instant of time
    * @return String This returns Floor State
    */
    public String toString() {

        return "Destination floor " + (destined_floor) + ": " + current_floor + " Current Floor";
    }

    private int destined_floor;
    private int current_floor;
}
