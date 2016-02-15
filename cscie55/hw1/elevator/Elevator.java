package cscie55.hw1.elevator;

// enum to define up or down direction of Elevator movement
enum Direction {MOVE_UP, MOVE_DOWN};

// File Elevator.java

public class Elevator
{
    public static final int     TOTAL_FLOORS          = 7; // User fed condition

    //C'tor
    public Elevator()
    {
        current_direction       = Direction.MOVE_UP;
        current_floor           = 0;
        destined_passengers     = new int[TOTAL_FLOORS];
        destined_passengers[0]  = 0;
    }

    //move the Elevator and Unboard
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

    // argument floor starts from 1 - TOTAL_FLOORS and NOT from 0 to TOTAL_FLOORS
    public int boardPassenger(int floor)
    {
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

    // Print state of the object at any instant of time
    public String toString() {
        int all_passengers = 0;
        for (int i = 0; i < TOP_FLOOR; i++)
        {
            all_passengers += destined_passengers[i];
        }
        return "Elevator " + (current_floor+1) + ": " + all_passengers + " passengers";
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
