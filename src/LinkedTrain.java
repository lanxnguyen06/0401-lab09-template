/*
 * Created on 2025-10-22
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

// TODO - TASK 2
public class LinkedTrain {

    // TODO: define useful attributes

    // Default constructor
    public LinkedTrain() {
        // Can be left empty!
    }

    // TODO: implement isEmpty()

    // TODO: implement size()

    // TODO: implement addFirst
    public void addFirst(String data) {

    }

    // TODO: implement add
    public void add(String data) {

    }

    // TODO: implement removeFirst()
    // Removes the node at the specified position
    public boolean removeFirst() {
        return false;
    }

    // TODO: implement removeLast())
    public boolean removeLast() {
        return false;
    }

    /*
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * ! NO NEED TO TOUCH THE LINES BELOW !
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     */

    // Return the element at a specified position
    public TrainCar get(int index) {
        // index must be 0 or higher
        if (index < 0) {
            return null;
        }
        Node current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return null;
                current = current.getNext();
            }
            return current.getData();
        }
        return null;
    }

    @Override
    public String toString() {
        String output = "";
        if (head != null) {
            Node current = head;
            while (current != null) {
                output += "[" + current.getData().toString() + "]";
                current = current.getNext();
            }
        }
        return output;
    }

    public void print() {
        System.out.println(this.toString());
    }
}
