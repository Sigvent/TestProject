package dagger.sigvent.ch.testdagger.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.sigvent.ch.testdagger.R;
import dagger.sigvent.ch.testdagger.VehicleFactoryApplication;
import dagger.sigvent.ch.testdagger.presenter.VehiclePresenter;

public class MainActivity extends AppCompatActivity implements VehicleView {
    public static final String TAG = "MainActivity";

    @Inject
    protected VehiclePresenter vehiclePresenter;

    @BindView(R.id.tv_vehicle_name)
    protected TextView tvVehicleName;

    @BindView(R.id.tv_vehicle_speed)
    protected TextView tvVehicleSpeed;

    @BindView(R.id.btn_get_vehicle)
    protected Button btnGetVehicle;

    @BindView(R.id.btn_increase_speed)
    protected Button btnIncreaseSpeed;

    @BindView(R.id.btn_decrease_speed)
    protected Button btnDecreaseSpeed;


    @BindString(R.string.vehicle_speed)
    String speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeInjection();
        ButterKnife.bind(this);

        vehiclePresenter.setView(this);
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
        tvVehicleSpeed.setText(String.format(speed,value));
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btn_get_vehicle)
    public void getNewVehicle() {
        vehiclePresenter.getVehicle();
    }

    @OnClick(R.id.btn_increase_speed)
    public void increaseSpeed() {
        vehiclePresenter.accelerate();
    }

    @OnClick(R.id.btn_decrease_speed)
    public void decreaseSpeed() {
        vehiclePresenter.decelerate();
    }

    @OnClick({R.id.hello_1, R.id.hello_2})
    public void hello(Button btn) {
        if (btn.getId() == R.id.hello_1)
            Toast.makeText(this, "hello 1 ! ", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "hello 2 ! ", Toast.LENGTH_SHORT).show();

    }
}
