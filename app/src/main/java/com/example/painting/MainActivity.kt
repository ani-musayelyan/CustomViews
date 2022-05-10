package com.example.painting

import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import com.example.painting.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

      //  binding.exampleView.mode = PorterDuff.Mode.MULTIPLY

    // setContentView(EmojiCustomView(this))
   // binding.drawPorterDraw.mode = PorterDuff.Mode.LIGHTEN
    // setContentView(R.layout.activity_main)
    // setContentView(CropImageView(this))
    //setContentView(CropUsingCanvas(this))
       // setContentView(DrawView(this))
       // setContentView(CircleView(this))
//        setContentView(ExampleView(this))

      //  binding.maskImage.background = AppCompatResources.getDrawable(this , R.drawable.frame)

//        binding.maskImage.scaleType = ImageView.ScaleType.CENTER

    }





}