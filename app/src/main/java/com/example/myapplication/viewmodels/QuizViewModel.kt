package com.example.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import com.example.myapplication.models.QuestionAnswer

class QuizViewModel: ViewModel() {
    var quizScore: Int = 0
    val totalQuestions = QuestionAnswer.questions.size

    fun getQuestions(): Array<String> = QuestionAnswer.questions

    fun getOptions(): Array<Array<String>> = QuestionAnswer.options

    fun getCorrectAnswers(): Array<String> = QuestionAnswer.correctAnswers

}