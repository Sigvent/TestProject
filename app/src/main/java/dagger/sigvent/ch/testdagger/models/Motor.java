package dagger.sigvent.ch.testdagger.models;

/**
 * Created by Jacky on 27.07.2016.
 */
public class Motor {
    private int rpm;

    public Motor() {
        this.rpm = 0;
    }

    public int getRpm() {
        return rpm;
    }

    public void accelerate(int value) {
        rpm = rpm + value;
    }

    public void decelerate(int value) {
        rpm = rpm - value;
    }

    public void brake() {
        rpm = 0;
    }
}
