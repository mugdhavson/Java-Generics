/*
 * AUTHOR:      Mugdha Sonawane
 * FILE:        ArrayStack.java
 * ASSIGNMENT:  Programming Assignment 6 - Stacks and Queues
 * COURSE:      CSC 210; Section 001; Fall 2020 
 * PURPOSE:     This class represents an Array Stack and has 
 *              all the methods that go along with the function 
 *              of that particular data structure. 
 *              
 *              (The notes are for myself)
 * NOTES:       It uses an array as a support to perform all 
 *              of it's other functions.
 *              It only uses the indexing function and the length 
 *              from the java Array.
 *              It implements the StackInterface detailed in another 
 *              file called StackInterface.java.
 *              All of the methods here are abstract methods from the 
 *              interface that have been implemented.
 *              It has some methods that are excess of the ones outlined 
 *              in StackInterface:
 *                   public ArrayStack(ArrayQueue copy), the copy constructor
 *                   public String toString(), this overrides the usual 
 *                   toString() method
 *                   public boolean equals(Object obj), this overrides the 
 *                   usual equals() method.
 *                         
 */
public class ArrayStack implements StackInterface {

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
    public ArrayStack() {
        array = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    /*
     * PURPOSE: This is the copy constructor.
     * It makes a copy of the ArrayStack object
     * passed in as an argument.
     * 
     * ARGUMENT: "copy", an ArrayStack object that
     * is to be copied.
     * 
     * RETURN VALUE: N/A
     */
    public ArrayStack(ArrayStack copy) {
        array = new int[copy.array.length];
        size = copy.size;
        for (int i = 0; i < size; i++) {
            array[i] = copy.array[i];
        }
    }

    /*
     * PURPOSE: This is a private method that helps
     * when the array that is backing the stack goes
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
     * to the top of the stack.
     * 
     * ARGUMENT: "value", the integer element to be added.
     * 
     * RETURN VALUE: N/A
     */
    @Override
    public void push(int value) {
        // size >= array.length
        // this means that the capacity is smaller than the size.
        // the array is equal to the size but we're definitely adding something
        // to it. So we'll have to grow the array
        if (size >= array.length) {
            growArray();
        }
        array[size] = value;
        size++;
    }

    /*
     * PURPOSE: This method removes the element on top of the
     * stack and returns it.
     * 
     * ARGUMENT: N/A
     * 
     * RETURN VALUE: the integer value to be returned; isn't
     * assigned to a particular variable.
     */
    @Override
    public int pop() {
        if (size == 0) {
            return -1;
        }
        size--;
        return array[size];
    }

    /*
     * PURPOSE: This method return the element on top of the stack
     * without removing it from the stack.
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
        return array[size - 1];
    }

    /*
     * PURPOSE: This method checks if the stack is empty or not.
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
     * PURPOSE: This method returns of the size of the stack.
     * 
     * ARGUMENT: N/A
     * 
     * RETURN VALUE: an int value, equalling the size of the
     * stack.
     */
    @Override
    public int size() {
        return size;
    }

    /*
     * PURPOSE: This method removes all of the elements from
     * the stack.
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
     * PURPOSE: This gives the String representation of the stack.
     * 
     * ARGUMENT: N/A
     * 
     * RETURN VALUE: "retval", a String that represents the stack.
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
     * of the ArrayStack class.
     * 
     * ARGUMENT: "obj", an object of unknown class.
     * 
     * RETURN VALUE: boolean value; true if the object and the instance
     * are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArrayStack) {
            ArrayStack stack = (ArrayStack) obj;
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
