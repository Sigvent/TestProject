package dagger.sigvent.ch.testdagger;

import android.app.Application;

import dagger.sigvent.ch.testdagger.component.DaggerVehicleFactoryComponent;
import dagger.sigvent.ch.testdagger.component.VehicleFactoryComponent;
import dagger.sigvent.ch.testdagger.module.VehicleModule;

/**
 * Created by Jacky on 27.07.2016.
 */
public class VehicleFactoryApplication extends Application{

    private VehicleFactoryComponent component;

    @Override public void onCreate() {
        super.onCreate();
        component = DaggerVehicleFactoryComponent.builder()
                .vehicleModule(new VehicleModule())
                .build();
    }

    public VehicleFactoryComponent getVehicleComponent() {
        return component;
    }
}
