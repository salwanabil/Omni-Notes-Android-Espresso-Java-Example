package it.feio.android.omninotes.pageobjects;

import androidx.test.espresso.matcher.ViewMatchers;

import it.feio.android.omninotes.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class OmniNotesMainScreen {
    //locate screen elements
    private final int exbandButton = R.id.fab_expand_menu_button;
    private final int textNoteButton = R.id.fab_note;
    private final int ckecklistNoteButton = R.id.fab_checklist;
    private final int searchIcon = R.id.menu_search;

    public void tapExpandAddButton(){
        onView(withId(exbandButton)).perform(click());
    }
     public void tapAddTextNoteButton(){
         onView(withId(textNoteButton)).perform(click());
     }
    public void tapAddChecklistNoteButton(){
        onView(withId(ckecklistNoteButton)).perform(click());
    }

    public static void tapActionMenu(){
        onView(ViewMatchers.withContentDescription("More options"))
                .perform(click());
    }

    // Side Left Menu Navigation ui elements
    public static void tapOpenDrawer(){
        // Open Drawer
        onView(withContentDescription("drawer open")).perform(click());
    }

    public static void tapSettingsFromDrawer(){
        // Open SETTINGS
        onView(withId(R.id.settings_view)).perform(click());
    }




}

