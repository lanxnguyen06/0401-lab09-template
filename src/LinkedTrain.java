/*
 * Created on 2025-10-22
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */
import java.util.Arrays;

public class LinkedTrain {
    public Node head;
    public int size = 0;

    // Default constructor
    public LinkedTrain() {
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return this.size;
    }

    public void addFirst(String data) {
        TrainCar car = new TrainCar(data);
        Node newNode = new Node(car);
        newNode.setNext(head); // set the next node to head
        head = newNode; // head is the new node
        size++;
    }

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

    public boolean contains(String data){ // extra credit
        TrainCar containsCargo = new TrainCar(data); // creates a TrainCar object that stores the targeted cargo that needs to be checked
        String containsTarget = Arrays.toString(containsCargo.getTrainCarString()); // stores the ascii art associated with the target cargo

        if (head == null)
            return false;
        
        Node current = head;
        while (current != null){
            String cargoContents = Arrays.toString(current.getData().getTrainCarString()); // check each car's string content
            if (containsTarget.equals(cargoContents)){ // if the cars equal each others' content
                System.out.println(data + " are found in the linked list.");
                return true;
            }
            current = current.getNext();
        }
        System.out.println(data + " are not found in the linked list.");
        return false;
    }
    
    public boolean removeByCargo(String data){ // extra credit
        if (head == null){
            return false;
        }
        
        TrainCar targetCargo = new TrainCar(data); // creates a TrainCar object that stores the targeted cargo that needs to be removed
        String target = Arrays.toString(targetCargo.getTrainCarString()); // stores the ascii art associated with the target cargo

        if (Arrays.toString(head.getData().getTrainCarString()).equals(target)){ // check if head is the target
            head = head.getNext();
            size--;
            return true;
        }

        Node current = head;
        while (current != null && current.getNext() != null){
            String insideCargo = Arrays.toString(current.getNext().getData().getTrainCarString()); // get the next node and check its ascii art
            if (insideCargo.equals(target)){ // if same ascii art (same cargo contents)
                current.setNext(current.getNext().getNext()); // set the next node to the node after the target (skips over the target to "remove" it)
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
        for (int i = 0; i < index - 1; i++){ // do index - 1 so it stops before the targeted index
            if (current.getNext() == null){
                return null;  
            }
            current = current.getNext(); // current = node before the desired node we actually want to remove
        }

        Node nodeToRemove = current.getNext(); // nodeToRemove = desired node we want to remove
        TrainCar data = nodeToRemove.getData(); // get string information about desired node
        current.setNext(nodeToRemove.getNext()); // sets the current to the node after the desired node (skipping over the desired node is like removing it)
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
