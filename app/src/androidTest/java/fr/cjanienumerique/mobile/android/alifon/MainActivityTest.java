package fr.cjanienumerique.mobile.android.alifon;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.cjanienumerique.mobile.android.alifon.ui.MainActivity;
import fr.cjanienumerique.mobile.android.alifon.ui.ui.main.ListWordsFragment;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    // This is not fixed
    private static int itemsCount = 0; // TODO

    private ActivityScenario<MainActivity> mainActivity;

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        this.mainActivity = mainActivityScenarioRule.getScenario();
        assertNotNull(this.mainActivity);
    }

    @Test
    public void listWordsShouldNotBeNull() {
        onView(ViewMatchers.withId(R.id.word_transliteration)).check(matches(notNullValue()));
    }

    
}