package fr.cjanienumerique.mobile.android.alifon.entities;

import java.util.ArrayList;
import java.util.List;

public class Word {

    private Long id;
    private String transliteration;
    private List<String> translations;
    private Root root;

    public Word() {
        this.translations = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransliteration() {
        return transliteration;
    }

    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }

    public String getTranslationsAsString() {
        String translationsAsString = "";
        for(int i=0; i<this.translations.size(); i++) {
            translationsAsString += this.translations.get(i) + ", ";
        }
        translationsAsString = translationsAsString.substring(0, translationsAsString.length() - 2);
        return translationsAsString;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }
}
