package fr.cjanienumerique.mobile.android.alifon.di;

import fr.cjanienumerique.mobile.android.alifon.service.WordService;
import fr.cjanienumerique.mobile.android.alifon.service.WordServiceImpl;

public class DI {

    private static WordService wordService = new WordServiceImpl();

    public static WordService getWordService() {
        return DI.wordService;
    }

    public static WordService getNewInstanceWordService() {
        return new WordServiceImpl();
    }
}
