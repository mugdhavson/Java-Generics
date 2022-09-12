/*
 * AUTHOR:      Mugdha Sonawane
 * FILE:        ArrayQueue.java
 * ASSIGNMENT:  Programming Assignment 6 - Stacks and Queues
 * COURSE:      CSC 210; Section 001; Fall 2020 
 * PURPOSE:     This class represents an Array Queue and has 
 *              all the methods that go along with the function 
 *              of that particular data structure. 
 *              
 *              (The notes are for myself)
 * NOTES:       It uses an array as a support to perform all 
 *              of it's other functions.
 *              It only uses the indexing function and the length 
 *              from the java Array.
 *              It implements the QueueInterface detailed in another 
 *              file called QueueInterface.java.
 *              All of the methods here are abstract methods from the 
 *              interface that have been implemented.
 *              It has some methods that are excess of the ones outlined 
 *              in QueueInterface:
 *                   public ArrayQueue(ArrayQueue copy), the copy constructor
 *                   public String toString(), this overrides the usual 
 *                   toString() method
 *                   public boolean equals(Object obj), this overrides the 
 *                   usual equals() method.
 *                   
 */
public class ArrayQueue implements QueueInterface {

    private static final int DEFAULT_CAPACITY = 10;
    private int[] array;
    private int size;

    /*
     * PURPOSE: This is the no argument constructor.
     * It initiates the array and sets the size variable
     * to 0.
     * 
     * ARGUMENT: N/A
     * 
     * RETURN VALUE: N/A
     */
    public ArrayQueue() {
        array = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    /*
     * PURPOSE: This is the copy constructor.
     * It makes a copy of the ArrayQueue object
     * passed in as an argument.
     * 
     * ARGUMENT: "copy", an ArrayQueue object that
     * is to be copied.
     * 
     * RETURN VALUE: N/A
     */
    public ArrayQueue(ArrayQueue copy) {
        array = new int[copy.array.length];
        size = copy.size;
        for (int i = 0; i < size; i++) {
            array[i] = copy.array[i];
        }
    }

    /*
     * PURPOSE: This is a private method that helps
     * when the array that is backing the queue goes
     * past its capacity. It increases that capacity
     * of the array.
     * 
     * ARGUMENT: N/A
     * 
     * RETURN VALUE: N/A
     */
    private void growArray() {
        int[] newArray = new int[2 * array.length];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    /*
     * PURPOSE: This method adds a new integer element
     * to the back of the queue.
     * 
     * ARGUMENT: "value", the integer element to be added.
     * 
     * RETURN VALUE: N/A
     */
    @Override
    public void enqueue(int value) {
        if (size >= array.length) {
            growArray();
        }
        array[size] = value;
        size++;
    }

    /*
     * PURPOSE: This method removes the element at the
     * front of the queue and returns it.
     * 
     * ARGUMENT: N/A
     * 
     * RETURN VALUE: "retval" the integer value to be returned.
     */
    @Override
    public int dequeue() {
        if (size == 0) {
            return -1;
        }
        int retval = array[0];
        for (int i = 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
        return retval;
    }

    /*
     * PURPOSE: This method return the element at the
     * front of the queue without removing it from the
     * queue.
     * 
     * ARGUMENT: N/A
     * 
     * RETURN VALUE: the integer value to be returned;
     * doesn't have a specific name.
     */
    @Override
    public int peek() {
        if (size == 0) {
            return -1;
        }
        return array[0];
    }

    /*
     * PURPOSE: This method checks if the queue is empty or not.
     * 
     * ARGUMENT: N/A
     * 
     * RETURN VALUE: a boolean value. false if not empty, true
     * if empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * PURPOSE: This method returns of the size of the queue.
     * 
     * ARGUMENT: N/A
     * 
     * RETURN VALUE: an int value, equalling the size of the
     * queue.
     */
    @Override
    public int size() {
        return size;
    }

    /*
     * PURPOSE: This method removes all of the elements from
     * the queue.
     * 
     * ARGUMENT: N/A
     * 
     * RETURN VALUE: N/A
     */
    @Override
    public void clear() {

        size = 0;
    }

    /*
     * PURPOSE: This gives the String representation of the queue.
     * 
     * ARGUMENT: N/A
     * 
     * RETURN VALUE: "retval", a String that represents the queue.
     */
    @Override
    public String toString() {
        String retval = "";
        for (int i = 0; i < size; i++) {
            retval += array[i] + ",";
        }
        if (!retval.isEmpty()) {
            return "{" + retval.substring(0, retval.length() - 1) + "}";
        }
        return "{}";
    }

    /*
     * PURPOSE: This is the equals method of the class. It checks
     * whether the object passed in is equal to the current instance
     * of the ArrayQueue class.
     * 
     * ARGUMENT: "obj", an object of unknown origins.
     * 
     * RETURN VALUE: boolean value; true if the object and the instance
     * are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArrayQueue) {
            ArrayQueue stack = (ArrayQueue) obj;
            if (size == stack.size) {
                for (int i = 0; i < size; i++) {
                    if (array[i] != stack.array[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

}
