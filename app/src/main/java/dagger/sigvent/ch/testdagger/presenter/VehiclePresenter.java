package dagger.sigvent.ch.testdagger.presenter;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.sigvent.ch.testdagger.models.VehicleFactory;
import dagger.sigvent.ch.testdagger.models.view.IVehicle;
import dagger.sigvent.ch.testdagger.view.VehicleView;

/**
 * Created by Jacky on 28.07.2016.
 */

@Singleton
public class VehiclePresenter {
    public static final String TAG = "VehiclePresenter";

    protected VehicleFactory vehicleFactory;
    private IVehicle vehicle;
    private VehicleView vehicleView;

    @Inject
    public VehiclePresenter(VehicleFactory vehicleFactory) {
        this.vehicleFactory = vehicleFactory;
    }

    public void setView(VehicleView vehicleView) {
        this.vehicleView = vehicleView;
    }

    public void getVehicle() {
        this.vehicle = vehicleFactory.getVehicle();
        vehicleView.setName(vehicle.getName());
        vehicleView.setSpeed(vehicle.getSpeed());
        vehicleView.setVehicleView(vehicle.getPictureUrl());
    }


    public void accelerate() {
        if (vehicle != null) {
            vehicle.increaseSpeed(10);
            vehicleView.setSpeed(vehicle.getSpeed());
        } else {
            vehicleView.showError("Not vehicle, cannot accelerate");
        }
    }

    public void decelerate() {
        if (vehicle != null) {
            vehicle.decreaseSpeed(10);
            vehicleView.setSpeed(vehicle.getSpeed());
        } else {
            vehicleView.showError("Not vehicle, cannot decelerate");
        }
    }


}
