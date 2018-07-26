package in.gov.rajasthan.bhamashah.bhamashah.hospital;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.gov.rajasthan.bhamashah.bhamashah.R;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class AppointmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Appointment> mList;

    public AppointmentAdapter(Context context, ArrayList<Appointment> mList) {
        this.mList = mList;
        mList.add(new Appointment());
        mList.add(new Appointment());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_saved_appointment, parent, false);
        return new AppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        };
//        ((AppointmentViewHolder) holder).bind(mList.get(position));
        ((AppointmentViewHolder) holder).setClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
