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
    public VehicleFactory() {
    }

    enum VehicleInformation {
        Audi("http://www.topgear.com/sites/default/files/styles/fit_1960x1102/public/images/news-article/carousel/2016/04/cc256885757fb7b284506e9a4bf3f39e/778104690282913061.jpg?itok=kj6MCeFI)"),
        BMW("http://4.bp.blogspot.com/-bFVzpRQrCo8/Vh2E4TdFelI/AAAAAAABL_o/MfEIrFBaY38/s1600/2017-BMW-M2-Coupe-16.jpg"),
        Renault("https://group.renault.com/wp-content/uploads/2014/08/clio.jpg"),
        Peugeot("http://www.peugeot.ch/media/showrooms/fr/showroom-peugeot-rcz-coupe-kppv3/medias/HEADING/EXTERIOR/Peugeot_RCZ_PERSO-2-960x460.jpg"),
        Mercedes("http://1.bp.blogspot.com/-fyxwjRl2epg/VqMU1PmVb7I/AAAAAAAAIiE/FRGZer46nNg/s1600/Mercedes%2BELK6.jpg");
        private String url;

        private VehicleInformation(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    @Override
    public IVehicle getVehicle() {
        nameValue = (nameValue + 1) % (VehicleInformation.values().length - 1);
        VehicleInformation vi = VehicleInformation.values()[nameValue];
        return new Vehicle(vi.name(), new Motor(), vi.getUrl());
    }
}
