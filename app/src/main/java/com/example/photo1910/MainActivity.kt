package com.example.photo1910



import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.PorterDuff
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            val uploaded_image = findViewById<ImageView>(R.id.uploaded_image)
            val button = findViewById<Button>(R.id.btn_picture)
            val rotationX = findViewById<SeekBar>(R.id.seekBar_rotationX)
            val rotationY = findViewById<SeekBar>(R.id.seekBar_rotationY)
            val img_visibility = findViewById<SeekBar>(R.id.seekBar_visibility)
            val red = findViewById<SeekBar>(R.id.seekBar_red)
            val green = findViewById<SeekBar>(R.id.seekBar_green)
            val blue = findViewById<SeekBar>(R.id.seekBar_blue)

        fun set_rgb()
        {
            var colour = Color.rgb(red.progress,green.progress,blue.progress)
            uploaded_image.setColorFilter(colour,PorterDuff.Mode.OVERLAY)
        }
        button.setOnClickListener(){

            val picture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(picture, 200)

        }
        rotationX?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                uploaded_image.setRotationX(progress.toFloat())
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {


            }
        })
        rotationY?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                uploaded_image.setRotationY(progress.toFloat())
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {


            }
        })
        img_visibility?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                uploaded_image.setImageAlpha(progress)
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {


            }
        })
        red?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                set_rgb()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {


            }
        })
        green?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                set_rgb()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {


            }
        })
        blue?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                set_rgb()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {


            }
        })

        /*rotation.setOnClickListener(){
            uploaded_image.setRotationX(99f)
        }*/






    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val uploaded_image = findViewById<ImageView>(R.id.uploaded_image)
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK && data != null) {
            uploaded_image.setImageBitmap(data.extras?.get("data") as Bitmap)
        }
    }
}