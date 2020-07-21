package com.example.assignment2.view

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.assignment2.R
import com.example.assignment2.model.Cat
import com.google.gson.Gson


/**
 * Created by Monil Panchal, B00838558 on 2020-03-27.
 * Organization: Dalhousie university
 * Email: monil.panchal@dal.ca
 */

/**
 * A subclass implementation of [ViewModel], instance of this class binds the data to allow fragments
 * to communicate with each other.
 */
class CatListView(application: Application) : AndroidViewModel(application) {

    private val context: Context = application
    private val gson = Gson()

    /**
     * A [MutableMap] is used to store the common data which is shared by fragments.
     */
    lateinit var cats: MutableList<Cat>
    var imageUrl = MutableLiveData<String>()
    var name = MutableLiveData<String>()
    var isListCompleted = MutableLiveData<Boolean>()
    var likeCount = MutableLiveData<Int>()
    var dislikeCount = MutableLiveData<Int>()

    init {
        initializeCatList()
    }

    /**
     * Function for initializing default counts and lists.
     *
     * Calls [CatListView.readJsonFile] every time the ListFragment is viewed in the MainActivity.
     * This method reads cat data from stored json file,
     * and initialized [CatListView.cats] MutableList.
     *
     * Calls [CatListView.advanceToNextSubject] method to re-initialize the [CatListView.cats] MutableList.
     */
    private fun initializeCatList() {
        likeCount.value = 0
        dislikeCount.value = 0
        readJsonFile()
        advanceToNextSubject()
    }

    /**
     * Function for reading cat data from stored json file stored in resource directory.
     * initialized [CatListView.cats] MutableList.
     */
    private fun readJsonFile() {
        val text = context.resources.openRawResource(R.raw.cat)
            .bufferedReader()
            .use { it.readText() }
        cats = gson.fromJson(text, Array<Cat>::class.java).toMutableList()
    }

    /**
     * Function for re-initializing the [CatListView.cats] MutableList,
     * whenever the like or dislike button is pressed or during fragment initialization.
     */
    private fun advanceToNextSubject() {
        if (cats.size > 0) {
            cats.removeAt(0).let { cat ->
                imageUrl.value = cat.imageUrl
                name.value = cat.name
            }
        } else {
            isListCompleted.value = true
        }
    }

    /**
     * Function to increment likeCount variable [CatListView.likeCount] when the like button from the UI is clicked,
     * and calls [CatListView.advanceToNextSubject] to re-initialize the [CatListView.cats] MutableList.
     */
    fun likeCatClicked() {
        likeCount.value = (likeCount.value)?.plus(1)
        advanceToNextSubject()
    }

    /**
     * Function to increment likeCount variable [CatListView.dislikeCount] when the dislike button from the UI is clicked,
     * and calls [CatListView.advanceToNextSubject] to re-initialize the [CatListView.cats] MutableList.
     */
    fun dislikeCatClicked() {
        dislikeCount.value = (dislikeCount.value)?.plus(1)
        advanceToNextSubject()
    }
}