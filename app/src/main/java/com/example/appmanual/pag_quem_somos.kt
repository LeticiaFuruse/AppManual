package com.example.appmanual

import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class pag_quem_somos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pag_quem_somos)

        // chamando minha toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

        // Adicionado controle para reprodução do vídeo no VideoView
        val videoView = findViewById<VideoView>(R.id.videoView)
        val videoPath = "android.resource://" + packageName + "/" + R.raw.video_teste
        val uri = Uri.parse(videoPath)
        videoView.setVideoURI(uri)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.requestFocus()
        videoView.start()
    }

    // abrir o menu de botões
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}
