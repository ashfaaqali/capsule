package com.example.myapplication.models

import com.example.myapplication.R

class QuestionAnswer {
    companion object {
        val questions = arrayOf(
            "Which of the following is a large blood vessel that carries blood away from the heart?",
            "Which of the following is not a member of the vitamin B complex?",
            "Fungi are plants that lack........",
            "What makes a reptile a reptile?",
            "Which blood vessels have the smallest diameter?",
            "Which blood vessels have the smallest diameter?",
            "Which organ of the body produces the fluid known as bile?",
            "Which of the following hormones is a steroid?",
            "Which one of the following is not a function of the liver?",
            "Plants receive their nutrients mainly from"
        )

        val options = arrayOf(
            arrayOf("Vein", "Artery", "Capillary"),
            arrayOf("Riboflavin", "Folic acid", "Ascorbic acid"),
            arrayOf("Carbon dioxide", "Chlorophyll", "Oxygen"),
            arrayOf("Cold blooded", "Warm Blooded", "Egg-laying"),
            arrayOf("Capillaries", "Arterioles", "Venules"),
            arrayOf("Measles", "Typhoid", "Pink eye"),
            arrayOf("Liver", "Pancreas", "Kidney"),
            arrayOf("Estrogen", "Glucagon", "Insulin"),
            arrayOf("Enzyme activation", "Detoxification", "Reproduction"),
            arrayOf("chlorophyll", "atmosphere", "soil"),
        )

        val correctAnswers = arrayOf(
            "Artery",
            "Ascorbic acid",
            "Chlorophyll",
            "Egg-laying",
            "Capillaries",
            "Measles",
            "Liver",
            "Estrogen",
            "Reproduction",
            "soil"
        )
    }
}