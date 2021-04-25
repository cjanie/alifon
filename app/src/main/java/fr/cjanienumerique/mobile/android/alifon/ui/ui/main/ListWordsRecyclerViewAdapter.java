package fr.cjanienumerique.mobile.android.alifon.ui.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cjanienumerique.mobile.android.alifon.R;
import fr.cjanienumerique.mobile.android.alifon.entities.Word;

public class ListWordsRecyclerViewAdapter extends RecyclerView.Adapter<ListWordsRecyclerViewAdapter.ViewHolder> {

    private List<Word> list;

    public ListWordsRecyclerViewAdapter(List<Word> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ListWordsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_words_item, parent, false);
        return new ListWordsRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListWordsRecyclerViewAdapter.ViewHolder holder, int position) {
        Word word = this.list.get(position);
        holder.transliteration.setText(word.getTransliteration());
        holder.translations.setText(word.getTranslationsAsString());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.word_transliteration)
        public TextView transliteration;
        @BindView(R.id.word_translations)
        public TextView translations;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
