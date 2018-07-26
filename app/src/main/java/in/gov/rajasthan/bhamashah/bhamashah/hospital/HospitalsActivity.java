package in.gov.rajasthan.bhamashah.bhamashah.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.gov.rajasthan.bhamashah.bhamashah.AppData;
import in.gov.rajasthan.bhamashah.bhamashah.Constants;
import in.gov.rajasthan.bhamashah.bhamashah.R;

public class HospitalsActivity extends AppCompatActivity implements HospitalAdapter.HospitalSelectionListener {

    @BindView(R.id.rvHospitalsList)
    RecyclerView rvHospitalsList;

    @BindView(R.id.ivBack)
    ImageView ivBack;

    @BindView(R.id.etHospitalSearch)
    EditText etHospitalSearch;

    @BindView(R.id.ivSearch)
    ImageView ivSearch;

    private TextWatcher searchWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            filterList(s.toString());
        }
    };

    private void filterList(String search) {
        ArrayList<Hospital> allHospitals = AppData.getHospitals();
        ArrayList<Hospital> filteredList = new ArrayList<>();
        for (Hospital hospital : allHospitals) {
            if (hospital.getName().toLowerCase().contains(search.toLowerCase())
                    || hospital.getCity().toLowerCase().contains(search.toLowerCase())) {
                filteredList.add(hospital);
            }
        }
        adapter.setList(filteredList);
    }

    private HospitalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        ButterKnife.bind(this);

        adapter = new HospitalAdapter(this, AppData.getHospitals());
        rvHospitalsList.setAdapter(adapter);
        rvHospitalsList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvHospitalsList.setLayoutManager(new LinearLayoutManager(this));
        etHospitalSearch.addTextChangedListener(searchWatcher);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void searchHospitals(View view) {
        //TODO search hospital here
        filterList(etHospitalSearch.getText().toString());
    }

    public void navigateBack(View view) {
        finish();
    }

    @Override
    public void onHospitalSelected(Hospital hospital) {
        //TODO show hospital details
        Intent intent = new Intent(this, HospitalDetailsActivity.class);
        intent.putExtra(Constants.HOSPITAL, hospital);
        startActivity(intent);
    }

    public void showMyAppointments(View view) {
        startActivity(new Intent(this, MyAppointmentsActivity.class));
    }

    public void showMyApplications(View view) {
    }
}
