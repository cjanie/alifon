package fr.cjanienumerique.mobile.android.alifon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import fr.cjanienumerique.mobile.android.alifon.entities.Word;

public class WordTests {

    @Test
    public void getTranslationsAsString() {
        Word wordXAa = new Word();
        wordXAa.setTransliteration("XAa");
        List<String> translations = new ArrayList<>();
        assert (wordXAa.getTranslationsAsString().equals(""));
        translations.add("to throw");
        wordXAa.setTranslations(translations);
        assert(wordXAa.getTranslationsAsString().equals("to throw"));
        wordXAa.getTranslations().add("to abandon");
        assert(wordXAa.getTranslationsAsString().equals("to throw, to abandon"));
    }
}
