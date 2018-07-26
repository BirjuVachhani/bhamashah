package in.gov.rajasthan.bhamashah.bhamashah.hospital;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.gov.rajasthan.bhamashah.bhamashah.R;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class AmenitiesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvAmenityName)
    TextView tvAmenityName;

    public AmenitiesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(String amenityName) {
        tvAmenityName.setText(amenityName);
    }
}
