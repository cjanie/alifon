package fr.cjanienumerique.mobile.android.alifon.ui.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.cjanienumerique.mobile.android.alifon.R;
import fr.cjanienumerique.mobile.android.alifon.entities.Word;

public class ListWordsFragment extends Fragment {
    private PageViewModel pageViewModel;
    private RecyclerView recyclerView;
    private LiveData<List> words;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.pageViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity().getApplication())).get(PageViewModel.class);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_words, container, false);
        Context context = root.getContext();
        this.recyclerView = (RecyclerView) root;
        this.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.words = this.pageViewModel.getList();
        this.words.observe(this, new Observer<List>() {
            @Override
            public void onChanged(List list) {
                recyclerView.setAdapter(new ListWordsRecyclerViewAdapter(list));
            }
        });

    }
}
