package dagger.sigvent.ch.testdagger;

import android.app.Application;

import dagger.sigvent.ch.testdagger.component.DaggerVehicleFactoryComponent;
import dagger.sigvent.ch.testdagger.component.VehicleFactoryComponent;
import dagger.sigvent.ch.testdagger.module.VehicleFactoryModule;

/**
 * Created by Jacky on 27.07.2016.
 */
public class VehicleFactoryApplication extends Application{

    private VehicleFactoryComponent component;

    @Override public void onCreate() {
        super.onCreate();
        component = DaggerVehicleFactoryComponent.builder()
                .vehicleFactoryModule(new VehicleFactoryModule())
                .build();
    }

    public VehicleFactoryComponent getVehicleComponent() {
        return component;
    }
}
