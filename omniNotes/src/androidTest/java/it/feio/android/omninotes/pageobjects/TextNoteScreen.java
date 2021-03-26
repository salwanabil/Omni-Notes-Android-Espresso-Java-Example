package it.feio.android.omninotes.pageobjects;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.tests.TestBase;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class TextNoteScreen {

    private final int detail_title = R.id.detail_title;
    private final int detail_content = R.id.detail_content;
    private final int backButton = R.id.crouton_handle;

    public void addTextNote(String noteTitle,String noteContent){
        onView(withId(detail_title))
                .perform(typeText(noteTitle), click());

        onView(withId(detail_content))
                .perform(typeText(noteContent), click());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //This code used to tap on back button
       // onView(isRoot()).perform(ViewActions.pressBack());

        onView(withContentDescription("drawer open")).perform(click());
        //onView(detail_title).check(matches(withText(noteTitle)));

    }

    public void checkTextNote(){
        //onView(withId()).check(matches(withText("")));
    }


}
