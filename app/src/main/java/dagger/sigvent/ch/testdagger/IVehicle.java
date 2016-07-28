package dagger.sigvent.ch.testdagger;

/**
 * Created by Jacky on 28.07.2016.
 */
public interface IVehicle {
    String getName();

    int getSpeed();

    void increaseSpeed(int value);

    void decreaseSpeed(int value);
}
