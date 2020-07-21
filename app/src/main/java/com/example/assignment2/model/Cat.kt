package com.example.assignment2.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Monil Panchal, B00838558 on 2020-03-26.
 * Organization: Dalhousie university
 * Email: monil.panchal@dal.ca
 */

/**
 * Model class for [Cat] instance
 */
data class Cat(

    @SerializedName("image_url")
    var imageUrl: String,
    var name: String,
    var id: String
)
