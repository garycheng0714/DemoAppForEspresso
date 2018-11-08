package com.example.garycheng.myapplication

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItem
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.*

import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    // activity to be launched
    val appActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test() {
        // Run test case
    }

    @Test
    fun testAnimalsRecyclerView() {
        onView(withId(R.id.animals_button)).perform(click())

        onView(withId(R.id.rv_animal_list))
                .perform(actionOnItem<ViewHolder>(hasDescendant(withText("dog")), click()))

        onView(withId(R.id.animal_type)).check(matches(withText("dog")))
    }

    @Test
    fun testAnimalsPosition() {
        onView(withId(R.id.animals_button)).perform(click())

        onView(withId(R.id.rv_animal_list))
                .perform(actionOnItemAtPosition<ViewHolder>(5, click()))

        onView(withId(R.id.animal_position)).check(matches(withText("5")))
    }

    @Test
    fun testGotTreasure() {
        onView(withId(R.id.animals_button)).perform(click())

        onView(withId(R.id.rv_animal_list))
                .perform(actionOnItem<ViewHolder>(hasDescendant(withText("treasure")), click()))

        onView(withId(R.id.animal_type)).check(matches(withText("treasure")))
    }

    @Test
    fun testCount() {
        onView(withId(R.id.count_button)).perform(click())

        onView(withId(R.id.textView)).check(matches(withText("1")))
    }
}
