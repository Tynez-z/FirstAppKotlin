package com.example.firstappkotlin

data class Questions(
    val id: Int,
    val question: String,
    val img: Int,
    val answerOptionOne: String,
    val answerOptionTwo: String,
    val answerOptionThree: String,
    val answerOptionFour: String,
    val correctAnswer: Int
    )
