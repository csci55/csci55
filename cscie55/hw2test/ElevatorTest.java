package cscie55.hw2test;

import cscie55.hw2.*;

/**
* ElevatorTest class tests the Elevator class and it's public methods
* @see Elevator
*/

public class ElevatorTest
{
   public static void main(String argv[])
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
}
