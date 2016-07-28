package dagger.sigvent.ch.testdagger;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.sigvent.ch.testdagger.models.VehicleFactory;

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
    public VehiclePresenter(VehicleFactory vehicleFactory){
        this.vehicleFactory = vehicleFactory;
    }

    public void setView(VehicleView vehicleView){
        this.vehicleView = vehicleView;
    }

    public void getVehicle(){
        Log.d(TAG, "vehicleFactory null ? "+(vehicleFactory==null));
        Log.d(TAG, "vehicleView null ? "+(vehicleView==null));
        this.vehicle = vehicleFactory.getVehicle();
        Log.d(TAG, "vehicle null ? "+(vehicle==null));
        vehicleView.setName(vehicle.getName());
        vehicleView.setSpeed(vehicle.getSpeed());
    }

    public void accelerate(){
        vehicle.increaseSpeed(10);
        vehicleView.setSpeed(vehicle.getSpeed());
    }

    public void decelerate(){
        vehicle.decreaseSpeed(10);
        vehicleView.setSpeed(vehicle.getSpeed());
    }


}
