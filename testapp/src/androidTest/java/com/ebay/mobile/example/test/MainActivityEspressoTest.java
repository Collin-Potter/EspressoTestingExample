package com.ebay.mobile.example.test;

import android.content.pm.ActivityInfo;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    /***
     *  Verifying functionality of hide button in portrait orientation
     */
    @Test
    public void clickButton_hide_portraitOrientation() {

        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        onView(withId(R.id.button))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));

        onView(withId(R.id.button))
                .check(matches(withText(R.string.button_text_show)));

    }

    /***
     *  Verifying functionality of show button in portrait orientation
     */
    @Test
    public void clickButton_show_portraitOrientation() {

        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        String stringToCheck = "Hide me!";

        onView(withId(R.id.button))
                .perform(click());

        onView(withId(R.id.button))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .check(matches(withText(stringToCheck)));

        onView(withId(R.id.button))
                .check(matches(withText(R.string.button_text_hide)));

    }

    /***
     *  Verifying functionality of hide button in landscape orientation
     */
    @Test
    public void clickButton_hide_landscapeOrientation() {

        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        onView(withId(R.id.button))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));

        onView(withId(R.id.button))
                .check(matches(withText(R.string.button_text_show)));

    }

    /***
     *  Verifying functionality of show button in landscape orientation
     */
    @Test
    public void clickButton_show_landscapeOrientation() {

        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        String stringToCheck = "Hide me!";

        onView(withId(R.id.button))
                .perform(click());

        onView(withId(R.id.button))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .check(matches(withText(stringToCheck)));

        onView(withId(R.id.button))
                .check(matches(withText(R.string.button_text_hide)));

    }

    /***
     * The following tests were not a stated requirement of the application, but I feel like it would be necessary to test
     * the state persistence of previously implemented tests during certain screen rotations
     *
     * Verifying persistence of state after testing hide functionality
     * by rotating orientation from portrait to landscape
     * This test is expected to fail due to lack of state persistence
     */
    @Test
    public void clickButton_hide_statePersistenceOnRotation_portraitToLandscape() {

        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        onView(withId(R.id.button))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));

        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        onView(withId(R.id.textView))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));

        onView(withId(R.id.button))
                .check(matches(withText(R.string.button_text_show)));

    }

    /***
     *  Verifying persistence of state after testing show functionality
     *  by rotating orientation from portrait to landscape
     */
    @Test
    public void clickButton_show_statePersistenceOnRotation_portraitToLandscape() {

        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        String stringToCheck = "Hide me!";

        onView(withId(R.id.button))
                .perform(click());

        onView(withId(R.id.button))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .check(matches(withText(stringToCheck)));

        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        onView(withId(R.id.textView))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .check(matches(withText(stringToCheck)));

        onView(withId(R.id.button))
                .check(matches(withText(R.string.button_text_hide)));

    }

    /***
     * Verifying persistence of state after testing hide functionality
     * by rotating orientation from landscape to portrait
     * This test is expected to fail due to lack of state persistence
     */
    @Test
    public void clickButton_hide_statePersistenceOnRotation_landscapeToPortrait() {

        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        onView(withId(R.id.button))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));

        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        onView(withId(R.id.textView))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));

        onView(withId(R.id.button))
                .check(matches(withText(R.string.button_text_show)));

    }

    /***
     * Verifying persistence of state after testing show functionality
     * by rotating orientation from landscape to portrait
     * This test is expected to fail due to lack of state persistence
     */
    @Test
    public void clickButton_show_statePersistenceOnRotation_landscapeToPortrait() {

        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        String stringToCheck = "Hide me!";

        onView(withId(R.id.button))
                .perform(click());

        onView(withId(R.id.button))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .check(matches(withText(stringToCheck)));

        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        onView(withId(R.id.textView))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
                .check(matches(withText(stringToCheck)));

        onView(withId(R.id.button))
                .check(matches(withText(R.string.button_text_hide)));

    }
}
