package it.feio.android.omninotes.pageobjects;

import androidx.test.espresso.matcher.ViewMatchers;

import it.feio.android.omninotes.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.hasSibling;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.containsString;

public class NoteDetailsScreen {
    //detect elements from toolbar at note details screen
    final int noteTitle = R.id.note_title;
    final int noteContent = R.id.note_content;
    final int cardLayout = R.id.card_layout;
    final int rootList = R.id.root;
    final int shareIcon = R.id.menu_share;

    //lbl nothing here
    final int emptyListlbl = R.id.empty_list;

    public void selectNoteWithSpecificText(String noteTitleToBeSelected){
        onView(allOf((withId(noteTitle)),
                hasSibling(withId(noteContent)), withText(containsString(noteTitleToBeSelected)))).perform(click());
    }

    public void moveToTrash(String noteTitleToBeDeleted){
        try {
            //Step 1 : tap on first note at notes main screen , to navigate to note details screen
           /* Espresso.onView(allOf(ViewMatchers.withId(R.id.note_content), isDisplayed())).perform(new ViewAction[] {
                    RecyclerViewActions.actionOnItemAtPosition(1, click()  )
            });*/
            selectNoteWithSpecificText(noteTitleToBeDeleted);
            //Step 2 : tap on More options ...dots at right side
            tapMoreActionsMenu();
            //onView(withContentDescription("More options")).perform(click());
            //Step 3 : tap on Trash at More options right side
            tapTrashFromActionMenu();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void tapMoreActionsMenu(){
        onView(ViewMatchers.withContentDescription("More options"))
                .perform(click());
    }

    public void tapTrashFromActionMenu(){
        onView(ViewMatchers.withText("Trash"))
                .perform(click());
    }
}

