/*
 * Created on 2025-10-22
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

// TODO - TASK 2

import java.util.Arrays;

public class LinkedTrain {
    public Node head;
    public int size;

    // TODO: define useful attributes

    // Default constructor
    public LinkedTrain() {
        // Can be left empty!
    }

    // TODO: implement isEmpty()
    public boolean isEmpty(){
        return head == null;
    }

    // TODO: implement size()
    public int size(){
        return this.size;
    }

    // TODO: implement addFirst
    public void addFirst(String data) {
        TrainCar car = new TrainCar(data);
        Node newNode = new Node(car);
        newNode.setNext(head); // set the next node to head
        head = newNode; // head is the new node
        size++;
    }

    // TODO: implement add
    public void add(String data) {
        TrainCar car = new TrainCar(data);
        Node newNode = new Node(car);

        if (head == null){
            head = newNode;
        }
        else{
            Node current = head; // current node is the head
            while (current.getNext() != null){ // while the next node is not null
                current = current.getNext(); // get the next node
            }
            current.setNext(newNode); // adds a train car at the end
        }
        size++;
    }

    // TODO: implement removeFirst()
    // Removes the node at the specified position
    public boolean removeFirst() {
        if (head == null){
            return false; // can't remove if nothing is there
        }
        else{
            head = head.getNext(); // set head to next element
            size--;
            return true;
        }
    }

    // TODO: implement removeLast())
    public boolean removeLast() {
        if (head == null){
        return false;
        }

        if (head.getNext() == null){ // if head is the only element remove it
            head = null;
            size--;
            return true;
        }

        else{
            Node current = head;
            while (current.getNext().getNext() != null){ // checks the element after the next node, if element after next node is null iteration has reached the end
                current = current.getNext(); // current gets the next node
            }
            current.setNext(null); 
        }
        size--;
        return true;
    }
    
    public boolean removeByCargo(String data){
        if (head == null){
            return false;
        }
        
        TrainCar targetCargo = new TrainCar(data);
        String target = Arrays.toString(targetCargo.getTrainCarString());

        if (Arrays.toString(head.getData().getTrainCarString()).equals(target)){
            head = head.getNext();
            size--;
            return true;
        }

        Node current = head;
        while (current != null && current.getNext() != null){
            String insideCargo = Arrays.toString(current.getNext().getData().getTrainCarString());
            if (insideCargo.equals(target)){
                current.setNext(current.getNext().getNext());
                size--;
                return true;
            }
            else
            current = current.getNext();
        }
        return false;
    }

    public TrainCar removeAt(int index){ // extra credit
        if (head == null){
            return null;
        }

        if (index == 0){ // if removing head
            TrainCar data = head.getData();
            head = head.getNext();
            size--;
            return data;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++){
            if (current.getNext() == null){
                return null;  
            }
            current = current.getNext(); // current = node before the desired node we actually want to remove
        }

        Node nodeToRemove = current.getNext(); // nodeToRemove = desired node we want to remove
        TrainCar data = nodeToRemove.getData(); // get string information about desired node
        current.setNext(nodeToRemove.getNext()); // sets the current to the node after the desired node (basically skipping over the desired node is like removing it)
        return data;
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
