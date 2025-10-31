/*
 * Created on 2025-10-22
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

// NO NEED TO TOUCH THIS FILE
public class TrainStation {
    public static void main(String[] args) {
        
        Train train = new Train();

        train.addTrainCar("people");
        train.addTrainCar("potatoes");
        train.addTrainCar("potatoes");
        train.addTrainCar("kazoos"); // added another type of cargo
        train.addTrainCar("people");
        train.addTrainCar("kazoos");
        train.addTrainCar("people");
        train.addTrainCar("potatoes");
        train.addTrainCar("people");
        train.addTrainCar("potatoes");
        train.getTrainCars().removeFirst();
        train.getTrainCars().removeLast();
        train.removeFirstTrainCar();
        train.getTrainCars().removeAt(2);
        train.getTrainCars().removeByCargo("people");
        train.printTrain();
        train.getTrainCars().contains("instruments");
        train.getTrainCars().contains("potatoes");
        System.out.println("The size of the train is " + train.getTrainCars().size + ", including the head of the train.");
    }
}
