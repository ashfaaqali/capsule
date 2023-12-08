package com.example.myapplication.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {
    private lateinit var binding: FragmentVideoBinding
    private lateinit var mediaControls: MediaController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Path
        binding.videoView.setVideoPath("android.resource://"+ requireActivity().packageName + "/" + R.raw.video1)
        binding.videoView.start()

        // Creating an object of media controller class
        mediaControls = MediaController(requireContext())
        mediaControls!!.setAnchorView(binding.videoView)

        // Set the media controller for video view
        binding.videoView.setMediaController(mediaControls)

        // Success Toast
        binding.videoView.setOnCompletionListener {
            Toast.makeText(
                requireContext(), "Video completed",
                Toast.LENGTH_LONG
            ).show()
        }

        // Error Toast
        binding.videoView.setOnErrorListener { _, _, _ ->
            Toast.makeText(
                requireContext(), "An Error Occurred " +
                        "While Playing Video !!!", Toast.LENGTH_LONG
            ).show()
            false
        }
    }
}