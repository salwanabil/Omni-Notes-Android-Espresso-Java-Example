package it.feio.android.omninotes.pageobjects;

import android.widget.LinearLayout;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

import it.feio.android.omninotes.R;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.hasSibling;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsAnything.anything;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class ChecklistNoteScreen{
    // locate ui screen elements
    private final int checklistTitle = R.id.detail_title;
    private final int checklistContentItem = R.layout.checklistview_item;

    /*
    This method used to : add CheckList Note
        @param      checklist note title
        @param      checklist note content/body
     */
    public void addCheckListNote(String title , String item){
        onView(withId(checklistTitle))
                .perform(typeText(title), click());

        Espresso.onView(allOf(ViewMatchers.withText("New item"), isDisplayed())).perform(new ViewAction[] {
                RecyclerViewActions.actionOnItemAtPosition(0, click()  )
        });
/*
        onView(allOf(withText("New item"),
                isDescendantOfA(withId(R.id.content_wrapper)))).perform(typeText(item));
*/


        //onData(withText("New item")).getClass().asSubclass("android.widget.LinearLayout")
        //onData(allOf(is(instanceOf(String.class)), startsWith("android.widget.EditText"))).perform(typeText(item),click());

        //onView(withText("New item"))                .perform(typeText(item), click());
       //onView(withClassName(is("android.widget.EditText"))).perform(typeText(item),click());

        //onData(allOf(is(instanceOf()))

        /*onData(anything())
                .inAdapterView(withId(android.R.id.list))
                .atPosition(numberOfAdapterItems - 1 - position)
                .onChildView(withClassName(getClass("android.widget.EditText")))
                .perform(click());*/

        /*onData(allOf(instanceOf(String.class), is("android.widget.EditText")))
                .perform(typeText(title), click());*/
//onData(anything()).inAdapterView(allOf(withId(R.id.horizontal), hasSibling(withText("Text")))).atPosition(2).onChildView(withId(R.id.image)).perform(click());

       // onData(anything()).inAdapterView(allOf(withId(R.id.detail_content_card), hasSibling(withText("New item")))).atPosition(2).onChildView(withClassName(is("android.widget.EditText"))).perform(typeText(title), click());
    }

    /*public DataInteraction onLayerAt(int listPosition) {
        return onData(instanceOf(LinearLayout.))
                .inAdapterView(withId(R.id.pocketpaint_layer_side_nav_list))
                .atPosition(listPosition);
    }*/
}
