package com.rax.jetpackcompose

import androidx.compose.Model

/**
 * by use of @Model, Compose Compiler plugin makes all the variables in your model observable so they can be used to recompose your widgets
 */
@Model
class News {
    var id: Int = 0
    var text: String = "A 12211 day in Shark Fin Cove"
    var date: String = "Davenport, California"
    var desc: String = "December 2018"
    var optionChecked: Boolean = false

    var counter: Int = 0

    fun add() { counter++ }

    fun subtract() { counter-- }
}