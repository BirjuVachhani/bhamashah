package in.gov.rajasthan.bhamashah.bhamashah.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.gov.rajasthan.bhamashah.bhamashah.job.JobsActivity;
import in.gov.rajasthan.bhamashah.bhamashah.R;
import in.gov.rajasthan.bhamashah.bhamashah.hospital.HospitalsActivity;

public class HomeActivity extends AppCompatActivity implements HomeAdapter.ServiceSelectionListener {

    @BindView(R.id.rvServiceList)
    RecyclerView rvServiceList;

    private int serviceImageResIds[] = {R.drawable.ic_healthcare_vector,
            R.drawable.ic_suitcase_vector,
            R.drawable.ic_cart_vector,
            R.drawable.ic_account_vector};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        HomeAdapter adapter = new HomeAdapter(createServiceList(), this);
        rvServiceList.setLayoutManager(new GridLayoutManager(this, 2));
        rvServiceList.setAdapter(adapter);
    }

    private List<ServiceHolder> createServiceList() {
        List<ServiceHolder> mList = new ArrayList<>();
        String serviceTitles[] = getResources().getStringArray(R.array.services);
        for (int i = 0; i < serviceImageResIds.length; i++) {
            mList.add(new ServiceHolder(serviceTitles[i], serviceImageResIds[i]));
        }
        return mList;
    }

    @Override
    public void onServiceSelected(int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, HospitalsActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, JobsActivity.class));
                break;
            case 2:
                break;
        }
    }
}
