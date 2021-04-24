package fr.cjanienumerique.mobile.android.alifon.ui.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.cjanienumerique.mobile.android.alifon.R;
import fr.cjanienumerique.mobile.android.alifon.ui.MainActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_TITLE = "section_title";

    private PageViewModel pageViewModel;

    private RecyclerView recyclerView;

    public static PlaceholderFragment newInstance(int titleId) { // int = id of externalized string
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_TITLE, titleId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity().getApplication())).get(PageViewModel.class);
        int titleId = R.string.words;
        if (getArguments() != null) {
            titleId = getArguments().getInt(ARG_SECTION_TITLE);
        }
        pageViewModel.setTitle(titleId);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView textView = root.findViewById(R.id.section_label);

        pageViewModel.getTitleText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        recyclerView = root.findViewById(R.id.recycler_view);
        pageViewModel.getList().observe(PlaceholderFragment.this, new Observer<List>() {
            @Override
            public void onChanged(List list) {

                recyclerView.setAdapter(new ListWordsRecyclerViewAdapter(list));
            }
        });

        return root;
    }
}