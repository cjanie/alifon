package fr.cjanienumerique.mobile.android.alifon.entities;

import java.util.ArrayList;
import java.util.List;

public class Root {

    private Long id;
    private String root;
    private List<Word> words;

    public Root() {
        this.words = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
