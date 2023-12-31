package com.example.myapplication.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentQuizResultBinding
import com.example.myapplication.models.QuestionAnswer
import com.example.myapplication.viewmodels.QuizViewModel

// This was another approach of the task, after reading the task again carefully
// I decided to remove it as the task says to 'Present with the result' rather than swipe to the result.

class QuizResultFragment : Fragment() {
    private lateinit var binding: FragmentQuizResultBinding
    private val quizViewModel: QuizViewModel by activityViewModels()
//    private var result = ""
//    private var totalQuestions = 0
//    private var quizScore = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuizResultBinding.inflate(layoutInflater)
//        totalQuestions = QuestionAnswer.questions.size
//        quizScore = quizViewModel.quizScore

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

//        if (quizScore > totalQuestions * 0.60){
//            binding.resultImg.setImageResource(R.drawable.pass_ic)
//            binding.resultTv.text = "Passed"
//        } else {
//            binding.resultImg.setImageResource(R.drawable.fail_ic)
//            binding.resultTv.text = "Failed"
//        }
//
//        binding.scoreTv.text = "Score:\n" + quizScore + " out of " + totalQuestions

    }
}