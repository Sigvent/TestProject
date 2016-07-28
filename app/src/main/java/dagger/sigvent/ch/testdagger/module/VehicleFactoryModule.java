package dagger.sigvent.ch.testdagger.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.sigvent.ch.testdagger.IVehicleFactory;
import dagger.sigvent.ch.testdagger.models.VehicleFactory;

/**
 * Created by Jacky on 27.07.2016.
 */
@Module
public class VehicleFactoryModule {

    @Provides
    @Singleton
    IVehicleFactory provideVehicleFactory(VehicleFactory vf) {
        return vf;
    }
}
