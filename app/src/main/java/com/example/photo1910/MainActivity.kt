package com.example.photo1910



import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            val uploaded_image = findViewById<ImageView>(R.id.uploaded_image)
            val button = findViewById<Button>(R.id.btn_picture)
        button.setOnClickListener(){

            val picture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(picture, 200)
            uploaded_image.setRotationX(99f)
        }






    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val uploaded_image = findViewById<ImageView>(R.id.uploaded_image)
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK && data != null) {
            uploaded_image.setImageBitmap(data.extras?.get("data") as Bitmap)
        }
    }
}