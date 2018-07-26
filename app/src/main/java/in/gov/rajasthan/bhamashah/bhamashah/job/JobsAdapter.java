package in.gov.rajasthan.bhamashah.bhamashah.job;

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
public class JobsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Job> mList;
    private JobSelectionListener listener;
    public static final int EMPTY = 0;
    public static final int NON_EMPTY = 1;
    private String emptyMessage = "No jobs found.";

    public JobsAdapter(Context context, ArrayList<Job> mList) {
        this.mList = mList;
        this.listener = (JobSelectionListener) context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == EMPTY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_list, parent, false);
            return new EmptyListViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_job, parent, false);
        return new JobViewHolder(view);
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
                listener.onJobSelected(mList.get(holder.getAdapterPosition()));
            }
        };
        ((JobViewHolder) holder).bind(mList.get(position));
        ((JobViewHolder) holder).setClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return mList.size() == 0 ? 1 : mList.size();
    }

    public void setList(ArrayList<Job> filteredList) {
        this.mList = filteredList;
        notifyDataSetChanged();
    }

    public interface JobSelectionListener {
        void onJobSelected(Job job);
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
