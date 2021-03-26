package it.feio.android.omninotes.tests;

import org.junit.Test;

import it.feio.android.omninotes.pageobjects.ChecklistNoteScreen;
import it.feio.android.omninotes.pageobjects.OmniNotesMainScreen;

public class ChecklistNoteTest extends TestBase {

    OmniNotesMainScreen omniNotesMainScreen = new OmniNotesMainScreen();
    ChecklistNoteScreen checklistNoteScreen = new ChecklistNoteScreen();

    /*
    This method used to :
    1- tap on tapExpandAddButton.
    2- tap on add Text Note
    3- addCheckListNote method takes
        @param      checklist note title
        @param      checklist note content/body
     */

    @Test
    public void addChecklistNote(){
        omniNotesMainScreen.tapExpandAddButton();
        omniNotesMainScreen.tapAddChecklistNoteButton();

        checklistNoteScreen.addCheckListNote("salwa", "item1SN");
    }

}
