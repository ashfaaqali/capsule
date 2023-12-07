package com.example.myapplication.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentQuizBinding
import com.example.myapplication.models.QuestionAnswer
import com.example.myapplication.viewmodels.QuizViewModel

class QuizFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentQuizBinding
    private val totalQuestions = QuestionAnswer.questions.size
    private var currentQuestionIndex = 0
    private var selectedAnswer = ""

    private val quizViewModel: QuizViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuizBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Total questions
        binding.totalQuestions.text = "Total Questions " + QuestionAnswer.questions.size.toString()

        getNewQuestion()

        binding.option1.setOnClickListener(this)
        binding.option2.setOnClickListener(this)
        binding.option3.setOnClickListener(this)
        binding.submitBtn.setOnClickListener(this)

    }

    private fun getNewQuestion() {

        if (currentQuestionIndex == totalQuestions) {
            finishQuiz()
        }

        binding.question.text = QuestionAnswer.questions[currentQuestionIndex]
        binding.option1.text = QuestionAnswer.options[currentQuestionIndex][0]
        binding.option2.text = QuestionAnswer.options[currentQuestionIndex][1]
        binding.option3.text = QuestionAnswer.options[currentQuestionIndex][2]

    }

    private fun finishQuiz() {
        Toast.makeText(
            requireContext(),
            "Quiz finished. Swipe to the next to see the result.",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onClick(p0: View?) {

        binding.option1.setBackgroundColor(Color.WHITE)
        binding.option2.setBackgroundColor(Color.WHITE)
        binding.option3.setBackgroundColor(Color.WHITE)

        binding.option1.setTextColor(resources.getColor(R.color.md_theme_dark_outlineVariant))
        binding.option2.setTextColor(resources.getColor(R.color.md_theme_dark_outlineVariant))
        binding.option3.setTextColor(resources.getColor(R.color.md_theme_dark_outlineVariant))

        val clickedButton: Button? = p0 as? Button

        if (clickedButton?.id == R.id.submit_btn) {
            currentQuestionIndex++
            getNewQuestion()
            if (selectedAnswer == QuestionAnswer.correctAnswers[currentQuestionIndex]) {
                quizViewModel.quizScore++
            }
        } else {
            // Clicked button
            selectedAnswer = clickedButton?.text.toString()
            clickedButton?.setTextColor(Color.WHITE)
            clickedButton?.setBackgroundColor(resources.getColor(R.color.md_theme_light_primary))
        }
    }
}