package cscie55.hw1;

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

    //move the Elevator
    public void move()
    {
        //First check for any Bondary conditions and adjust teh direction
        if(current_floor == GROUND_FLOOR)
        {
            current_direction = Direction.MOVE_UP;
        }
        if(current_floor == TOP_FLOOR)
        {
            current_direction = Direction.MOVE_DOWN;
        }
        // Unboard the passeengers destined to the current floor
        //Now move the Elevator
        if(current_direction == Direction.MOVE_UP)
        {
            current_floor++;
        }
        if(current_direction == Direction.MOVE_DOWN)
        {
            current_floor--;
        }
        destined_passengers[current_floor] = 0;
    }

    // floor starts from 1 = TOTAL_FLOORS and not from 0 to TOTAL_FLOORS
    public int boardPassenger(int floor)
    {
        int ret = 0;
        if(floor > GROUND_FLOOR || floor <= TOTAL_FLOORS)
        {
            destined_passengers[floor-1]++;
        }else
        {
            ret = -1;
        }
        return ret;
    }

    public String toString() {
        int all_passengers = 0;
        for (int i = 0; i < TOP_FLOOR; i++)
        {
            all_passengers += destined_passengers[i];
        }
        return "Elevator " + (current_floor+1) + ": " + all_passengers + " passengers";
    }

    // Private members for internal use only
    private static final int    TOP_FLOOR           = TOTAL_FLOORS -1;
    private static final int    GROUND_FLOOR        = 0;
    private int                 current_floor       = 0; // [0 - MAX_FLOOR]
    private Direction           current_direction   = Direction.MOVE_UP;
    private int                 destined_passengers[];
}
