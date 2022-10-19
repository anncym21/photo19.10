package com.example.photo1910




import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    lateinit var uploaded_image: ImageView
    lateinit var btn_picture: Button
    val pick_image = 100
    var image_uri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {


            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            title = "photo"
            btn_picture = findViewById<Button>(R.id.btn_picture)
            uploaded_image = findViewById<ImageView>(R.id.uploaded_image)
            btn_picture.setOnClickListener(){
                val picture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(picture, 200)
            }



        setContentView(R.layout.activity_main)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK && requestCode == pick_image) {
            image_uri = data?.data
            uploaded_image.setImageURI(image_uri)
        }
    }
}