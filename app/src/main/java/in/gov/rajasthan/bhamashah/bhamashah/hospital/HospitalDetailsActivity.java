package in.gov.rajasthan.bhamashah.bhamashah.hospital;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.gov.rajasthan.bhamashah.bhamashah.Constants;
import in.gov.rajasthan.bhamashah.bhamashah.R;

public class HospitalDetailsActivity extends AppCompatActivity {

    @BindView(R.id.collapsingToolBar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @BindView(R.id.tvHospitalName)
    TextView tvHospitalName;

    @BindView(R.id.tvAddress)
    TextView tvAddress;

    @BindView(R.id.tvDesc)
    TextView tvDesc;

    @BindView(R.id.clBookAppointment)
    ConstraintLayout clBookAppointment;

    @BindView(R.id.clCall)
    ConstraintLayout clCall;

    @BindView(R.id.tvAmenitiesLabel)
    TextView tvAmenitiesLabel;

    @BindView(R.id.rvAmenitiesList)
    RecyclerView rvAmenitiesList;

    @BindView(R.id.ivHospitalImage)
    ImageView ivHospitalImage;

    private Hospital hospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_details);
        ButterKnife.bind(this);

        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout.setTitle("");
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));

        if (getIntent() != null) {
            hospital = getIntent().getParcelableExtra(Constants.HOSPITAL);
            setHospitalData(hospital);
        }
    }

    private void setHospitalData(Hospital hospital) {
        getSupportActionBar().setTitle(hospital.getName());
        tvHospitalName.setText(hospital.getName());
        tvAddress.setText(String.format("%s, %s", hospital.getAddress(), hospital.getCity()));
        tvDesc.setText(hospital.getDescription());
        if (hospital.getSpecifications() == null || hospital.getSpecifications().length == 0) {
            tvAmenitiesLabel.setVisibility(View.GONE);
            rvAmenitiesList.setVisibility(View.GONE);
            return;
        }
        rvAmenitiesList.setAdapter(new AmenitiesAdapter(hospital.getSpecifications()));
        rvAmenitiesList.setLayoutManager(new LinearLayoutManager(this));
        Picasso.get()
                .load(R.drawable.fortis_hospital)
                .placeholder(R.drawable.placeholder_dark)
                .fit()
                .into(ivHospitalImage);
    }

    public void callHospital(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+919726337873"));
        startActivity(intent);
    }

    public void bookAppointment(View view) {
        startActivity(new Intent(this, BookAppointmentActivity.class));
    }
}
