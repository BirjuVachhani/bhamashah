package in.gov.rajasthan.bhamashah.bhamashah.hospital;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.gov.rajasthan.bhamashah.bhamashah.R;
import in.gov.rajasthan.bhamashah.bhamashah.hospital.Appointment;
import in.gov.rajasthan.bhamashah.bhamashah.hospital.AppointmentAdapter;

public class MyAppointmentsActivity extends AppCompatActivity {

    @BindView(R.id.rvAppointmentList)
    RecyclerView rvAppointmentList;

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointments);
        ButterKnife.bind(this);

        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("My Appointments");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvAppointmentList.setAdapter(new AppointmentAdapter(this, new ArrayList<Appointment>()));
        rvAppointmentList.setLayoutManager(new LinearLayoutManager(this));
    }
}
