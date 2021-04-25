package fr.cjanienumerique.mobile.android.alifon.ui.ui.main;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fr.cjanienumerique.mobile.android.alifon.R;
import fr.cjanienumerique.mobile.android.alifon.entities.Root;
import fr.cjanienumerique.mobile.android.alifon.entities.Word;

public class PageViewModel extends AndroidViewModel {

    private MutableLiveData<Integer> titleId = new MutableLiveData<>();

    private LiveData<String> titleText = Transformations.map(titleId, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return getApplication().getString(input);
        }
    });

    private MutableLiveData<List> list;

    public PageViewModel(@NonNull Application application) {
        super(application);
        this.list = new MutableLiveData<>();
    }

    private void loadList() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                "http://192.168.1.11:8081/rest/words",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<Word> words = new ArrayList<>();
                        for(int i=0; i<response.length(); i++) {
                            JSONObject wordAsJsonObject = response.optJSONObject(i);
                            Word word = new Word();
                            word.setId(wordAsJsonObject.optLong("id"));
                            word.setTransliteration(wordAsJsonObject.optString("transliteration"));
                            JSONObject rootAsJsonObject = wordAsJsonObject.optJSONObject("root");
                            Root root = new Root();
                            root.setId(rootAsJsonObject.optLong("id"));
                            root.setRoot(rootAsJsonObject.optString("root"));
                            word.setRoot(root);
                            words.add(word);
                        }
                        System.out.println("Words: " + words);
                        list.setValue(words);
                        System.out.println("List: " + list.getValue());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplication().getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        );
        Volley.newRequestQueue(getApplication().getApplicationContext()).add(jsonArrayRequest);
    }




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



    public void setTitle(int titleId) {
        this.titleId.setValue(titleId);
    }

    public LiveData<String> getTitleText() {
        return this.titleText;
    }

    public LiveData<List> getList() {
        this.loadList();
        return this.list;
    }

    public LiveData<Integer> getListLayoutId() {
        return this.listLayoutId;
    }
}