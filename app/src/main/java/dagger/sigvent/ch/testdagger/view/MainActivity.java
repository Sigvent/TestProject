package dagger.sigvent.ch.testdagger.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.sigvent.ch.testdagger.IVehicle;
import dagger.sigvent.ch.testdagger.IVehicleFactory;
import dagger.sigvent.ch.testdagger.R;
import dagger.sigvent.ch.testdagger.VehicleFactoryApplication;
import dagger.sigvent.ch.testdagger.VehicleView;

public class MainActivity extends AppCompatActivity implements VehicleView {
    @Inject
    protected IVehicleFactory vehicleFactory;

    private IVehicle vehicle;
    private TextView tvVehicleName;
    private TextView tvVehicleSpeed;
    private Button btnGetVehicle;
    private Button btnIncreaseSpeed;
    private Button btnDecreaseSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvVehicleName = (TextView) findViewById(R.id.tv_vehicle_name);
        this.tvVehicleSpeed = (TextView) findViewById(R.id.tv_vehicle_speed);
        this.btnGetVehicle = (Button) findViewById(R.id.btn_get_vehicle);
        this.btnIncreaseSpeed = (Button) findViewById(R.id.btn_increase_speed);
        this.btnDecreaseSpeed = (Button) findViewById(R.id.btn_decrease_speed);

        this.btnGetVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicle = vehicleFactory.getVehicle();
                tvVehicleName.setText(vehicle.getName());
                tvVehicleSpeed.setText(getString(R.string.vehicle_speed,vehicle.getSpeed()));
            }
        });
        this.btnIncreaseSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicle.increaseSpeed(10);
                tvVehicleSpeed.setText(getString(R.string.vehicle_speed,vehicle.getSpeed()));
            }
        });
        this.btnDecreaseSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicle.decreaseSpeed(10);
                tvVehicleSpeed.setText(getString(R.string.vehicle_speed,vehicle.getSpeed()));
            }
        });

        initializeInjection();
    }

    private void initializeInjection() {
        ((VehicleFactoryApplication) getApplication()).getVehicleComponent().inject(this);
    }

    @Override
    public void setName(String name) {
        tvVehicleName.setText(name);
    }

    @Override
    public void setSpeed(int value) {
        tvVehicleSpeed.setText(getString(R.string.vehicle_speed,value));
    }
}
