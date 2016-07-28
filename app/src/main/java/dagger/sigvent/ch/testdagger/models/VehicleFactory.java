package dagger.sigvent.ch.testdagger.models;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.sigvent.ch.testdagger.models.view.IVehicle;
import dagger.sigvent.ch.testdagger.models.view.IVehicleFactory;

/**
 * Created by Jacky on 27.07.2016.
 */
@Singleton
public class VehicleFactory implements IVehicleFactory {
    private int nameValue = 0;

    @Inject
    public VehicleFactory(){}

    enum VehicleName {
        Audi, BMW, Renault, Peugeot, Mercedes;
    }

    @Override
    public IVehicle getVehicle() {
        nameValue = (nameValue + 1) % (VehicleName.values().length - 1);
        return new Vehicle(VehicleName.values()[nameValue].name(), new Motor());
    }
}
