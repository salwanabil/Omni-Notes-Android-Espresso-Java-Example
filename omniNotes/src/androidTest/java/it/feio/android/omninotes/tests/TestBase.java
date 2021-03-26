package it.feio.android.omninotes.tests;

import android.annotation.SuppressLint;
import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.BeforeClass;
import org.junit.Rule;

import it.feio.android.omninotes.MainActivity;
import it.feio.android.omninotes.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isOpen;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

public class TestBase {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class, false , true);
    //crouton_handle
    public final int topToolbar =  R.id.crouton_handle;

    /*
    @BeforeClass
    public void initSetup(){
        if (onView(withText("Trash")).equals("Trash")){
            onView(withContentDescription("drawer open")).perform(click());
            onView(withText("Notes")).perform(click());
        }
    }*/

    public static void navigateViewToNotesTitleDisplayed(String viewName){
        onView(withContentDescription("drawer open")).perform(click());
        onView(withId(R.id.note_title)).check(matches(withText(viewName))).perform(click());
    }

    public static void openDrawerMenu(){
        onView(withContentDescription("drawer open")).perform(DrawerActions.open())
                .check(matches(isOpen()));
    }

/*
    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex;
            int viewObjHash;

            @SuppressLint("DefaultLocale") @Override
            public void describeTo(Description description) {
                description.appendText(String.format("with index: %d ", index));
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                if (matcher.matches(view) && currentIndex++ == index) {
                    viewObjHash = view.hashCode();
                }
                return view.hashCode() == viewObjHash;
            }
        };
    }*/

    /*
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
