package fr.cjanienumerique.mobile.android.alifon.repository;

import java.util.List;

import fr.cjanienumerique.mobile.android.alifon.di.DI;
import fr.cjanienumerique.mobile.android.alifon.model.Word;
import fr.cjanienumerique.mobile.android.alifon.service.WordService;

public class WordRepository {

    private WordService wordService;

    private static WordRepository INSTANCE;

    private WordRepository() {
        this.wordService = DI.getWordService();
    }

    public static WordRepository getInstance() {
        if(WordRepository.INSTANCE == null) {
            WordRepository.INSTANCE = new WordRepository();
        }
        return WordRepository.INSTANCE;
    }

    public List<Word> getWords() {
        return this.wordService.getWords();
    }
}
