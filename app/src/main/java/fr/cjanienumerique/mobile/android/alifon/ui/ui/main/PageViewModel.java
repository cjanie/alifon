package fr.cjanienumerique.mobile.android.alifon.ui.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.ArrayList;
import java.util.List;

import fr.cjanienumerique.mobile.android.alifon.R;

public class PageViewModel extends AndroidViewModel {

    private MutableLiveData<Integer> titleId = new MutableLiveData<>();

    private LiveData<String> titleText = Transformations.map(titleId, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return getApplication().getString(input);
        }
    });

    private LiveData<List> list = Transformations.map(titleId, new Function<Integer, List>() {
        @Override
        public List apply(Integer input) {
            List list = new ArrayList();
            if(input == R.string.words) {
                // TODO : list =
            } else if(input == R.string.roots) {
                // TODO: list =
            }
            return list;
        }
    });

    private LiveData<Integer> listLayoutId = Transformations.map(titleId, new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer input) {
            Integer listLayoutId = null;
            if(input == R.string.words) {
                listLayoutId = R.id.list_words;
            } else if(input == R.string.roots) {
                listLayoutId = R.id.list_words; // TODO Layout list_roots
            }
            return listLayoutId;
        }
    });

    public PageViewModel(@NonNull Application application) {
        super(application);
    }

    public void setTitle(int titleId) {
        this.titleId.setValue(titleId);
    }

    public LiveData<String> getTitleText() {
        return this.titleText;
    }

    public LiveData<List> getList() {
        return this.list;
    }

    public LiveData<Integer> getListLayoutId() {
        return this.listLayoutId;
    }
}