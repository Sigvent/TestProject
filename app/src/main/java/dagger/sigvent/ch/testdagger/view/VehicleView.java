package dagger.sigvent.ch.testdagger.view;

/**
 * Created by Jacky on 28.07.2016.
 */
public interface VehicleView {
    void setName(String name);
    void setSpeed(int value);
    void showError(String error);
    void setVehicleView(String url);
}