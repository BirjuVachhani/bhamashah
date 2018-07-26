package in.gov.rajasthan.bhamashah.bhamashah.hospital;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.gov.rajasthan.bhamashah.bhamashah.EmptyListViewHolder;
import in.gov.rajasthan.bhamashah.bhamashah.R;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class HospitalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Hospital> mList;
    private HospitalSelectionListener listener;
    public static final int EMPTY = 0;
    public static final int NON_EMPTY = 1;
    private String emptyMessage = "No hospitals found.";

    public HospitalAdapter(Context context, ArrayList<Hospital> mList) {
        this.mList = mList;
        this.listener = (HospitalSelectionListener) context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == EMPTY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_list, parent, false);
            return new EmptyListViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hospital_no_card, parent, false);
        return new HospitalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == EMPTY) {
            ((EmptyListViewHolder) holder).bind(emptyMessage);
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onHospitalSelected(mList.get(holder.getAdapterPosition()));
            }
        };
        ((HospitalViewHolder) holder).bind(mList.get(position));
        ((HospitalViewHolder) holder).setClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return mList.size() == 0 ? 1 : mList.size();
    }

    public void setList(ArrayList<Hospital> filteredList) {
        this.mList = filteredList;
        notifyDataSetChanged();
    }

    public interface HospitalSelectionListener {
        void onHospitalSelected(Hospital hospital);
    }

    @Override
    public int getItemViewType(int position) {
        return mList.size() == 0 ? EMPTY : NON_EMPTY;
    }

    public String getEmptyMessage() {
        return emptyMessage;
    }

    public void setEmptyMessage(String emptyMessage) {
        this.emptyMessage = emptyMessage;
    }
}
