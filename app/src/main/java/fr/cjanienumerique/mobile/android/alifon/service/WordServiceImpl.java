package fr.cjanienumerique.mobile.android.alifon.service;

import java.util.List;

import fr.cjanienumerique.mobile.android.alifon.model.Word;

public class WordServiceImpl implements WordService {

    @Override
    public List<Word> getWords() {
        return WordDataGenerator.generateWords();
    }
}
