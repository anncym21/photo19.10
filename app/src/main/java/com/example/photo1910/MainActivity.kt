package com.example.photo1910



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val image_btn = findViewById<Button>(R.id.btn_picture)
        val image_view = findViewById<ImageView>(R.id.uploaded_image)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}