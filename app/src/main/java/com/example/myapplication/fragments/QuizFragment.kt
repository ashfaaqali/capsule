package com.example.myapplication.fragments

import android.app.AlertDialog
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
import com.example.myapplication.databinding.ResultLayoutBinding
import com.example.myapplication.viewmodels.QuizViewModel

class QuizFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentQuizBinding
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
        getNewQuestion()
        binding.option1.setOnClickListener(this)
        binding.option2.setOnClickListener(this)
        binding.option3.setOnClickListener(this)
        binding.submitBtn.setOnClickListener(this)
    }

    private fun getNewQuestion() {
        if (currentQuestionIndex == quizViewModel.totalQuestions) {
            finishQuiz()
            return
        }
        // Show current question no.
        binding.totalQuestions.text = "${currentQuestionIndex + 1} of ${quizViewModel.totalQuestions}"

        binding.question.text = quizViewModel.getQuestions()[currentQuestionIndex]
        binding.option1.text = quizViewModel.getOptions()[currentQuestionIndex][0]
        binding.option2.text = quizViewModel.getOptions()[currentQuestionIndex][1]
        binding.option3.text = quizViewModel.getOptions()[currentQuestionIndex][2]
        // Reset selected answer for the new question
        selectedAnswer = ""
    }

    private fun finishQuiz() {
        var alertDialog: AlertDialog? = null
        val builder = AlertDialog.Builder(requireContext())

        val view = ResultLayoutBinding.inflate(layoutInflater)
        builder.setView(view.root)

        if (quizViewModel.quizScore > quizViewModel.totalQuestions * 0.60){
            view.tv1.text = "Passed!"
            view.tv2.text = "Score:\n" + quizViewModel.quizScore + " out of " + quizViewModel.totalQuestions
            view.resultImg.setImageResource(R.drawable.pass_ic)
            view.resultImg.setColorFilter(Color.GREEN)
        } else {
            view.resultImg.setImageResource(R.drawable.fail_ic)
            view.tv1.text = "Failed"
            view.tv2.text = "Score:\n" + quizViewModel.quizScore + " out of " + quizViewModel.totalQuestions
            view.resultImg.setColorFilter(Color.RED)
        }

        view.okBtn.setOnClickListener{
            alertDialog?.dismiss()
        }

        alertDialog = builder.create()
        alertDialog.show()
    }

    override fun onClick(p0: View?) {
        resetOptionsAppearance()

        val clickedButton: Button? = p0 as? Button
        if (clickedButton?.id == R.id.submit_btn) {
            if (selectedAnswer.isEmpty()) { // No option selected
                Toast.makeText(
                    requireContext(),
                    "Select an option",
                    Toast.LENGTH_LONG
                ).show()
            } else if (currentQuestionIndex < quizViewModel.totalQuestions) { // More questions left
                // Check if the selected answer is correct
                if (selectedAnswer == quizViewModel.getCorrectAnswers()[currentQuestionIndex]) {
                    quizViewModel.quizScore++
                }
                // Move to the next question
                currentQuestionIndex++
                getNewQuestion()
            } else { // No questions left
                finishQuiz()
            }
        } else {
            // Clicked button
            selectedAnswer = clickedButton?.text.toString()
            clickedButton?.setTextColor(Color.WHITE)
            clickedButton?.setBackgroundColor(resources.getColor(R.color.md_theme_light_primary))
        }
    }

    private fun resetOptionsAppearance() {
        // Reset background color and text color for all options
        binding.option1.setBackgroundColor(Color.WHITE)
        binding.option2.setBackgroundColor(Color.WHITE)
        binding.option3.setBackgroundColor(Color.WHITE)
        binding.option1.setTextColor(resources.getColor(R.color.md_theme_dark_outlineVariant))
        binding.option2.setTextColor(resources.getColor(R.color.md_theme_dark_outlineVariant))
        binding.option3.setTextColor(resources.getColor(R.color.md_theme_dark_outlineVariant))
    }
}