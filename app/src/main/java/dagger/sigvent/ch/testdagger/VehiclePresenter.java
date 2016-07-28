package dagger.sigvent.ch.testdagger;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.sigvent.ch.testdagger.models.VehicleFactory;

/**
 * Created by Jacky on 28.07.2016.
 */

@PerActivity
public class VehiclePresenter {
    protected VehicleFactory vehicleFactory;
    private VehicleView vehicleView;

    @Inject
    public VehiclePresenter(@Named("vehicleFactory") VehicleFactory vehicleFactory){
        this.vehicleFactory = vehicleFactory;
    }

    public void setView(VehicleView vehicleView){
        this.vehicleView = vehicleView;
    }

    public void getVehicle(){
        IVehicle vehicle = vehicleFactory.getVehicle();
        vehicleView.setName(vehicle.getName());
        vehicleView.setSpeed(vehicle.getSpeed());
    }
}
