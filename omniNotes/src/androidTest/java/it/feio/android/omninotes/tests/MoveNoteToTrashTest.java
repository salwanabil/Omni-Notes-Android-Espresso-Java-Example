package it.feio.android.omninotes.tests;

import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import it.feio.android.omninotes.pageobjects.NoteDetailsScreen;
import it.feio.android.omninotes.pageobjects.OmniNotesMainScreen;
import it.feio.android.omninotes.pageobjects.TextNoteScreen;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MoveNoteToTrashTest extends TestBase {
    TextNoteScreen textNoteScreen = new TextNoteScreen();
    String noteTitle = "TestToBeTrashed";
    String noteContent = "TestToBeTrashed";

    OmniNotesMainScreen omniNotesMainScreen = new OmniNotesMainScreen();
    NoteDetailsScreen noteDetailsScreen = new NoteDetailsScreen();

    @Test
    public void moveToTrash() throws InterruptedException {
         omniNotesMainScreen.tapExpandAddButton();
         omniNotesMainScreen.tapAddTextNoteButton();
         textNoteScreen.addTextNote(noteTitle,noteContent);
        noteDetailsScreen.moveToTrash(noteTitle);
        //Thread.sleep added only to let the tester watch that item is trashed , will be updated to intent or make watcher()
        Thread.sleep(2000);
    }


    @Test
    public void checkNoteExistanceInTheTrash() throws InterruptedException {
        // Open Drawer
        onView(withContentDescription("drawer open")).perform(click());
        // Tap on Trash
        onView(withText("Trash")).perform(click());
        Thread.sleep(2000);
    }
/*
    @Test
    public void RestoreNoteFromTrash() {
        noteDetailsScreen.selectNoteWithSpecificText(noteTitle);
        // tap on More options
        onView(withContentDescription("More options")).perform(click());
        //Restore from trash
        onView(withText("Restore from trash")).perform(click());
        // Open Drawer
        onView(withContentDescription("drawer open")).perform(click());
        onView(withText("Notes")).perform(click());
    }

    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }
*/
}
