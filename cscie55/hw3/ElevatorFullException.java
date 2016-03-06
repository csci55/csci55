package cscie55.hw3;

/**
* The Elevator implements functionality of Elevator.
* ElevatorFullException is thrown when boarded passengers are at capacity.
*
* @author  Sanjay Tiwari
* @version 1.0
* @since   2016-02-16
*/

/**
* ElevatorFullException is thrown when boarded passengers are at capacity
* @see Exception
*/
public class ElevatorFullException extends Exception {
  public ElevatorFullException() { super(); }
}
