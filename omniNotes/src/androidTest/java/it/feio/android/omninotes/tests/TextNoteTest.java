package it.feio.android.omninotes.tests;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import it.feio.android.omninotes.MainActivity;
import it.feio.android.omninotes.pageobjects.OmniNotesMainScreen;
import it.feio.android.omninotes.pageobjects.TextNoteScreen;

@RunWith(AndroidJUnit4.class)
public class TextNoteTest extends TestBase {

    OmniNotesMainScreen omniNotesMainScreen = new OmniNotesMainScreen();
    TextNoteScreen textNoteScreen = new TextNoteScreen();

    /*
    This method used to :
    1- tap on tapExpandAddButton.
    2- tap on add Text Note
    3- addTextNote method takes
        @param      note title
        @param      note content/body
     */
    @Test
    public void addTextNote(){
       // TestBase.navigateViewToNotesTitleDisplayed();
        omniNotesMainScreen.tapExpandAddButton();
        omniNotesMainScreen.tapAddTextNoteButton();
        textNoteScreen.addTextNote("text note title","txt content");
    }
}
