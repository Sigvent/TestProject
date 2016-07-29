package dagger.sigvent.ch.testdagger.models;

import dagger.sigvent.ch.testdagger.models.view.IVehicle;

/**
 * Created by Jacky on 27.07.2016.
 */
public class Vehicle implements IVehicle{
    private Motor motor;
    private String name;
    private String url;

    public Vehicle(String name, Motor motor, String url) {
        this.name = name;
        this.motor = motor;
        this.url = url;

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
    public String getPictureUrl() {
        return url;
    }

    @Override
    public String getName() {
        return name;
    }
}
