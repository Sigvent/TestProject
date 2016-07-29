package dagger.sigvent.ch.testdagger.models.view;

/**
 * Created by Jacky on 28.07.2016.
 */
public interface IVehicle {
    String getName();

    int getSpeed();

    String getPictureUrl();

    void increaseSpeed(int value);

    void decreaseSpeed(int value);
}
