package com.erikzuo.androidplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erikzuo.androidplayground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityBinding: ActivityMainBinding
    private val epoxyController = MyListEpoxyController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        activityBinding.apply {
            content.setController(epoxyController)
        }

        epoxyController.setData(
            listOf(
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg",
                "https://wowpmediaaae.azureedge.net/content/wowproductimages/large/668005.jpg"
            )
        )
    }
}

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, imageUrl: String) {
    GlideApp.with(imageView.context)
        .load(imageUrl)
        .into(imageView)
}
