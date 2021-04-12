package fr.cjanienumerique.mobile.android.alifon.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.cjanienumerique.mobile.android.alifon.model.Word;

public abstract class WordDataGenerator {

    public static List<Word> WORDS_FROM_FAULKNER_DICTIONNARY = Arrays.asList();

    public static List<Word> generateWords() {
        return new ArrayList<>(WORDS_FROM_FAULKNER_DICTIONNARY);
    }
}
