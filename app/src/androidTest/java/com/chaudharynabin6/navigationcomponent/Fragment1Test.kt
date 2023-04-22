package com.chaudharynabin6.navigationcomponent

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.google.common.truth.Truth.assertThat
import org.junit.Test

//https://developer.android.com/guide/navigation/navigation-testing

class Fragment1Test {

    @Test
    fun navigationFrom_fragment1_to_fragment2() {
        // Create a TestNavHostController
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )

        // Create a graphical FragmentScenario for the TitleScreen
        val fragment1Scenario = launchFragmentInContainer<Fragment1>()

        fragment1Scenario.onFragment { fragment ->
            // Set the graph on the TestNavHostController
            navController.setGraph(R.navigation.nav_graph_1)


            // Make the NavController available via the findNavController() APIs
            Navigation.setViewNavController(fragment.requireView(), navController)
        }


        // Verify that performing a click changes the NavController’s state
        onView(ViewMatchers.withId(R.id.navigate_to_fragment_2)).perform(ViewActions.click())
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.fragment2)
    }


    @Test
    fun navigationFrom_fragment1_to_FragmentHistory() {
        // Create a TestNavHostController
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )

        // Create a graphical FragmentScenario for the TitleScreen
        val fragment1Scenario = launchFragmentInContainer<Fragment1>()

        fragment1Scenario.onFragment { fragment ->
            // Set the graph on the TestNavHostController
            navController.setGraph(R.navigation.nav_graph_1)


            // Make the NavController available via the findNavController() APIs
            Navigation.setViewNavController(fragment.requireView(), navController)
        }


        // Verify that performing a click changes the NavController’s state
        onView(ViewMatchers.withId(R.id.navigate_to_history)).perform(ViewActions.click())
        assertThat(navController.currentDestination?.label).isEqualTo("fragment_history_entry_point")
    }


}