package com.example.cinaeste

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cinaeste.view.SimpleStringAdapter
import com.example.cinaeste.viewmodel.MovieDetailViewModel

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LV5Test {
    @Test
    fun actorsTest(){
        val pokreniDetalje = Intent(ApplicationProvider.getApplicationContext(),MovieDetailActivity::class.java)
        pokreniDetalje.putExtra("movie_title","Pulp Fiction")
        launchActivity<MovieDetailActivity>(pokreniDetalje)
        val actors = MovieDetailViewModel().getActorsByTitle("Pulp Fiction")
        for(actor in actors)
            onView(withId(R.id.listActors)).perform(RecyclerViewActions.scrollTo<SimpleStringAdapter.SimpleViewHolder>(
                withText(actor))).check(matches(isDisplayed()))
    }
    @Test
    fun sendTest() {
        val intent: Intent = Intent()
        intent.putExtra(Intent.EXTRA_TEXT, "Neki tekst")
        intent.action = Intent.ACTION_SEND
        intent.type = "text/plain"
        intent.`package` = "com.example.cinaeste"
        // intent.`package` = ApplicationProvider.getApplicationContext<Context?>().packageName
        //  Log.v("ime paketa je" , intent.`package`.toString())
      //  intent.`package` = "com.example.cinaeste"

        launchActivity<MainActivity>(intent) .use {
            onView(withId(R.id.searchText)).check(matches(withText("Neki tekst")))
        }
    }
}