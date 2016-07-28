package dagger.sigvent.ch.testdagger.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.sigvent.ch.testdagger.R;
import dagger.sigvent.ch.testdagger.VehicleFactoryApplication;
import dagger.sigvent.ch.testdagger.VehiclePresenter;
import dagger.sigvent.ch.testdagger.VehicleView;

public class MainActivity extends AppCompatActivity implements VehicleView {
    public static final String TAG = "MainActivity";

    @Inject
    protected VehiclePresenter vehiclePresenter;
    private TextView tvVehicleName;
    private TextView tvVehicleSpeed;
    private Button btnGetVehicle;
    private Button btnIncreaseSpeed;
    private Button btnDecreaseSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeInjection();

        vehiclePresenter.setView(this);

        this.tvVehicleName = (TextView) findViewById(R.id.tv_vehicle_name);
        this.tvVehicleSpeed = (TextView) findViewById(R.id.tv_vehicle_speed);
        this.btnGetVehicle = (Button) findViewById(R.id.btn_get_vehicle);
        this.btnIncreaseSpeed = (Button) findViewById(R.id.btn_increase_speed);
        this.btnDecreaseSpeed = (Button) findViewById(R.id.btn_decrease_speed);

        this.btnGetVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "vehiclePresenter null ? "+(vehiclePresenter==null));
                vehiclePresenter.getVehicle();
            }
        });
        this.btnIncreaseSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehiclePresenter.accelerate();
            }
        });
        this.btnDecreaseSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehiclePresenter.decelerate();
            }
        });

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
