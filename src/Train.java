/*
 * Created on 2025-10-22
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

// NO NEED TO TOUCH THIS FILE 
public class Train {
    private final String[] trainHead = { "  .o O___ ", " ][___|O|_", "|        |", "<________|", "//O-O-O-O " };
    private LinkedTrain trainCars = new LinkedTrain();

    public LinkedTrain getTrainCars() {
        return trainCars;
    }

    public void addTrainCar(String cargo) {
        trainCars.add(cargo);
    }

    public void removeFirstTrainCar() {
        trainCars.removeFirst();
    }

    public void printTrain() {
        System.out.println();
        for (int i = 0; i < trainHead.length; i++) {
            // Print the current part of the train's head
            System.out.print(trainHead[i]); 
            // Print each train car's row
            for (int j = 0; j < trainCars.size(); j++) {
                TrainCar car = trainCars.get(j);
                if (car != null) {
                    System.out.print(" " + car.getTrainCarString()[i]); 
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
