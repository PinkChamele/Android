package com.example.lab4

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class Video : AppCompatActivity() {

    private lateinit var videoField: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        videoField = findViewById(R.id.videoField)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoField)

        val onlineUri = Uri.parse("android.resource://$packageName/${R.raw.owl}")
        videoField.setVideoURI(onlineUri)
        videoField.requestFocus()
        videoField.start()
        videoField.setMediaController(mediaController)
        mediaController.setAnchorView(videoField)
    }
}