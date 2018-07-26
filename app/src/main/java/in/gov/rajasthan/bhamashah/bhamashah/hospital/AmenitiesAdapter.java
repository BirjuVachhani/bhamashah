package in.gov.rajasthan.bhamashah.bhamashah.hospital;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.gov.rajasthan.bhamashah.bhamashah.R;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class AmenitiesAdapter extends RecyclerView.Adapter<AmenitiesViewHolder> {

    private String[] amenities;

    public AmenitiesAdapter(String[] amenities) {
        this.amenities = amenities;
    }

    @NonNull
    @Override
    public AmenitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_amenity, parent, false);
        return new AmenitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AmenitiesViewHolder holder, int position) {
        holder.bind(amenities[position]);
    }

    @Override
    public int getItemCount() {
        return amenities.length;
    }
}
