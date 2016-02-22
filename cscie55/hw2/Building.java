package cscie55.hw2;

/**
* The Building implements functionality of Building with floors and an Elevator.
* It simulates movements of Elevator between the Floors.
*
* @author  Sanjay Tiwari
* @version 1.0
* @since   2016-02-21
*/

/**
* The Building class implements functionality of Building with Elevator and
* Floors.
*/
public class Building
{
    // User fed condition
    public static final int FLOORS = 7;

    /**
    * Building Constructor
    */
    public Building()
    {
        elevator = new Elevator(this);
        floors = new Floor[FLOORS];
        for(int i = 0; i < FLOORS; i++)
        {
            floors[i] = new Floor(this, i);
        }
    }

    /**
    * This method returns the building's elevator Object
    * @return Elevator This returns the elevator Object.
    */
    public Elevator elevator()
    {
        return elevator;
    }

    /**
    * This method return the Floor object identified by the floorNumber
    * @param floorNumber int This is passed as arugment to identify the Floor
    * @return Floor This returns the Floor object identified by the floorNumber
    */
    public Floor floor(int floorNumber)
    {
        if(floorNumber <= FLOORS)
        {
            return floors[floorNumber -1];
        }else
        {
            return null;
        }
    }

    /**
    * This method prints state of the object at any instant of time
    * @return String This returns Building State
    */
    public String toString() {

        return "TOTAL FLOORS " + (FLOORS) ;
    }

    private Elevator elevator;
    private Floor floors[];
}
