/*
 * Created on 2025-10-22
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

 // TODO - TASK 1
 public class Node {
    private TrainCar data;
    private Node next;
    // TODO: Implement Node.
    public Node(TrainCar data){
        this.data = data;
        this.next = null;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public TrainCar getData(){
        return data;
    }
        
}
