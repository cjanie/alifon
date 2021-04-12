package fr.cjanienumerique.mobile.android.alifon;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import fr.cjanienumerique.mobile.android.alifon.model.Word;
import fr.cjanienumerique.mobile.android.alifon.repository.WordRepository;
import fr.cjanienumerique.mobile.android.alifon.service.WordDataGenerator;


@RunWith(JUnit4.class)
public class WordRepositoryTest {
    private WordRepository wordRepository;

    @Before
    public void setup() {
        this.wordRepository = WordRepository.getInstance();
    }

    @Test
    public void getWordsWithSuccess() {
        List<Word> words = this.wordRepository.getWords();
        List<Word> expectedWords = WordDataGenerator.WORDS_FROM_FAULKNER_DICTIONNARY;
        assert(words.equals(expectedWords));
    }
}