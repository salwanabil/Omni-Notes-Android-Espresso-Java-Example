package it.feio.android.omninotes.tests;

import org.junit.Test;

import it.feio.android.omninotes.pageobjects.OmniNotesMainScreen;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class SideLeftMenuNavigationTest extends TestBase {

    // Enable swipe to trash from Settings → Behaviours.
    @Test
    public void swipeTrashFromSettingsBehaviours() throws InterruptedException {
        OmniNotesMainScreen.tapOpenDrawer();
        OmniNotesMainScreen.tapSettingsFromDrawer();
        onView(withText("Behaviors")).perform(click());
        onView(withText("Swipe notes")).perform(click());
        onView(withText("Swipe to trash")).perform(click());
        Thread.sleep(2000);
    }
}
