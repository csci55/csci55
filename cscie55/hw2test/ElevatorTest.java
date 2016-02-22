package cscie55.hw2test;

import cscie55.hw2.*;

/**
* ElevatorTest class tests the Elevator class and it's public methods
* @see Elevator
*/

public class ElevatorTest
{
    public static void checkElevator(Elevator elevator, int floorNumber, int passengers)
    {
        System.out.println("Equal Test Floor " + floorNumber + "==" + elevator.currentFloor());
        System.out.println("Equal Test Passenger " + passengers + "==" + elevator.passengers());
    }

    public static void boarding_test()
    {
        Building building = new Building();
        Elevator elevator = building.elevator();
        // Have enough people waiting on the 4th floor to exceed elevator capacity by 50%
        int waiting = (int) (Elevator.CAPACITY * 1.5);
        for (int i = 0; i < waiting; i++) {
            building.floor(4).waitForElevator();
        }
        // Move to 4, checking state
        elevator.move();
        checkElevator(elevator, 2, 0);
        elevator.move();
        checkElevator(elevator, 3, 0);
        elevator.move();
        // Should have filled the elevator, leaving people on 4
        checkElevator(elevator, 4, Elevator.CAPACITY);
    }

    public static void floor_test()
    {
        Building building = new Building();
        try{
           building.elevator().boardPassenger(3);
           building.elevator().boardPassenger(3);
           building.elevator().boardPassenger(5);
        }catch(Exception ex){}
        System.out.println(building.elevator());
        for (int i= 0; i < (Building.FLOORS-1)*2; i++)
        {
           building.elevator().move();
           System.out.println(building.elevator());
        }

    }
    public static void floor_call()
    {
        Building building = new Building();
        Elevator elevator = building.elevator();
        building.floor(3).waitForElevator();
        building.floor(3).waitForElevator();
        building.floor(6).waitForElevator();
        building.floor(6).waitForElevator();
        building.floor(6).waitForElevator();
        checkElevator(elevator, 1, 0);
        elevator.move();
        checkElevator(elevator, 2, 0);
        elevator.move();
        checkElevator(elevator, 3, 2);
        elevator.move();
        checkElevator(elevator, 3, 2);
    }

    public static void main(String argv[])
    {
        //boarding_test();
        //floor_test();
        floor_call();
    }
}
