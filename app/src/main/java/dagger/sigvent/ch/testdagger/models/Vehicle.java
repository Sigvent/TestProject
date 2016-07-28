package dagger.sigvent.ch.testdagger.models;

import dagger.sigvent.ch.testdagger.models.view.IVehicle;

/**
 * Created by Jacky on 27.07.2016.
 */
public class Vehicle implements IVehicle{
    private Motor motor;
    private String name;

    public Vehicle(String name, Motor motor) {
        this.name = name;
        this.motor = motor;
    }

    @Override
    public void increaseSpeed(int value) {
        motor.accelerate(value);
    }

    @Override
    public void decreaseSpeed(int value) {
        motor.decelerate(value);
    }

    public void stop() {
        motor.brake();
    }

    @Override
    public int getSpeed() {
        return motor.getRpm();
    }

    @Override
    public String getName() {
        return name;
    }
}
