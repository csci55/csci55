package cscie55.hw1;

import cscie55.hw1.Elevator;

// File ElevetorTest.java
public class ElevatorTest
{
   public static void main(String argv[])
   {
       Elevator elevator = new Elevator();
       elevator.boardPassenger(3);
       elevator.boardPassenger(5);
       System.out.println(elevator);
       for (int i= 0; i < (Elevator.TOTAL_FLOORS-1)*2; i++)
       {
           elevator.move();
           System.out.println(elevator);
       }

   }
}
