package fr.cjanienumerique.mobile.android.alifon.ui.ui.main;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListWordsRecyclerViewAdapter extends RecyclerView.Adapter<ListWordsRecyclerViewAdapter.ViewHolder> {

    private List list;

    public ListWordsRecyclerViewAdapter(List list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ListWordsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListWordsRecyclerViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
