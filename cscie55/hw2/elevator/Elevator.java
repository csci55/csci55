package cscie55.hw2.elevator;

/**
* The Elevator implements functionality of Elevator.
* It simulates movements within a building with multiples floors.
* It allows boading one passenger at a time and move one floor
* at a time.
*
* @author  Sanjay Tiwari
* @version 1.0
* @since   2016-02-16
*/


/**
* enum to define up or down direction of Elevator movement
*
*/
enum Direction {MOVE_UP, MOVE_DOWN};

/**
* The Elevator class implements functionality of Elevator.
*/
public class Elevator
{
    // User fed condition
    public static final int TOTAL_FLOORS = 7;
    public static final int CAPACITY     = 10;

    /**
    * Elevator Constructor
    */
    public Elevator()
    {
        current_direction       = Direction.MOVE_UP;
        current_floor           = 0;
        destined_passengers     = new int[TOTAL_FLOORS];
        destined_passengers[0]  = 0;
    }

    /**
    * This method returns the elevator's current floor number
    * @return int This returns the elevator's current floor number.
    */
    public int currentFloor()
    {
        return current_floor + (TOTAL_FLOORS - TOP_FLOOR);
    }

    /**
    * This method return the number of passengers currently on the elevator
    * @return int This returns the number of passengers currently on the elevator
    */
    public int passengers()
    {
        return all_passengers_onboard();
    }

    /**
    * This method moves the Elevator and Unboard
    */
    public void move()
    {
        // We will have to figure out if a passenger wants to board same floor
        destined_passengers[current_floor] = 0;

        //First check for any Bondary conditions and adjust the direction
        if(current_floor == GROUND_FLOOR)
        {
            current_direction = Direction.MOVE_UP;
        }
        if(current_floor == TOP_FLOOR)
        {
            current_direction = Direction.MOVE_DOWN;
        }
        //Now move the Elevator
        if(current_direction == Direction.MOVE_UP)
        {
            current_floor++;
        }
        if(current_direction == Direction.MOVE_DOWN)
        {
            current_floor--;
        }
        // Unboard the passeengers destined to the current floor
        destined_passengers[current_floor] = 0;
    }

    /**
    * This method boards a passenger to a destination floor.
    * @param floor Starts from 1 - TOTAL_FLOORS and NOT from 0 to TOTAL_FLOORS
    * @return int This returns 0 on successful boarding else non positive number
    * @throws ElevatorFullException This is full elevator condition
    * @see ElevatorFullException
    */
    public int boardPassenger(int floor) throws ElevatorFullException
    {
        if(passengers() >= CAPACITY)
        {
            throw new ElevatorFullException();
        }
        int ret = 0;
        // We will have to figure out if a passenger wants to board same floor
        if(floor >= GROUND_FLOOR && floor <= TOP_FLOOR)
        {
            destined_passengers[floor-1]++;
        }else
        {
            ret = -1;
        }
        return ret;
    }

    /**
    * This method prints state of the object at any instant of time
    * @return String This returns Elevator State and total number of passeengers
    */
    public String toString() {

        int all_passengers = all_passengers_onboard();
        return "Elevator " + (current_floor+1) + ": " + all_passengers + " passengers";
    }

    /**
    * This method computes all passeengers on board the elevator
    * @return int This returns total number of passeengers
    */
    private int all_passengers_onboard()
    {
        int all_passengers = 0;
        for (int i = 0; i < TOP_FLOOR; i++)
        {
            all_passengers += destined_passengers[i];
        }
        return all_passengers;
    }

    // Private members for internal use only

    // Define Top and Ground floor values
    private static final int    TOP_FLOOR           = TOTAL_FLOORS -1;
    private static final int    GROUND_FLOOR        = 0;

    // current_floor ranges from [GROUND_FLOOR - TOP_FLOOR] and starts from GROUND_FLOOR
    private int                 current_floor       = GROUND_FLOOR;

    // Direction of Elevator movement
    private Direction           current_direction   = Direction.MOVE_UP;

    // Array for passengers count for each floor
    private int                 destined_passengers[];
}
