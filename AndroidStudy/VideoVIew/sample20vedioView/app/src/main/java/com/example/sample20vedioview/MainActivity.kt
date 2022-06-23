package com.example.sample20vedioview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val video = findViewById<VideoView>(R.id.videoView)

        video.setMediaController(MediaController(this))

        video.setVideoURI(Uri.parse("android.resource://"+packageName+ "/" + R.raw.sindong))
    }
}