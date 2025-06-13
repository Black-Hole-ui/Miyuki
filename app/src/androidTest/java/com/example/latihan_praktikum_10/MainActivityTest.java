package com.example.latihan_praktikum_10;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.example.latihan_praktikum_10.R;
import com.example.latihan_praktikum_10.persentation.ui.MainActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.action.ViewActions.click;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> rule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void testBottomNavigation_isDisplayed() {
        onView(withId(R.id.bottom_navigation))
                .check(matches(isDisplayed()));
    }
    @Test
    public void testClickMenuNavigation() {
        onView(withId(R.id.navigation_konten)).perform(click());
        onView(withId(R.id.navigation_menu3)).perform(click());
        onView(withId(R.id.navigation_setting)).perform(click());
        onView(withId(R.id.navigation_home)).perform(click());
    }
}