package dagger.sigvent.ch.testdagger.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.sigvent.ch.testdagger.module.VehicleFactoryModule;
import dagger.sigvent.ch.testdagger.view.MainActivity;

/**
 * Created by Jacky on 27.07.2016.
 */
@Singleton
@Component(modules = {VehicleFactoryModule.class})
public interface VehicleFactoryComponent {
    void inject(MainActivity mainActivity);
}