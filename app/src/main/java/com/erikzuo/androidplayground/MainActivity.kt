package com.erikzuo.androidplayground

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.TypedEpoxyController
import com.erikzuo.androidplayground.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), StartLoadingHandler {

    private lateinit var activityBinding: ActivityMainBinding
    private val myItems = MutableList(50) { index -> MyItem(index, false) }
    private lateinit var controller: MyController

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        controller = MyController(this)
        activityBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setController(controller)
        }

        activityBinding.resetButton.setOnClickListener {
            myItems.replaceAll {
                if (it.value) {
                    it.copy(value = false)
                } else {
                    it.copy()
                }
            }
            controller.setData(myItems)
        }

        controller.setData(myItems)
    }

    override fun onStartLoadingClick(id: Int) {
        myItems[id] = MyItem(id, true)
        controller.setData(myItems)
    }
}

interface StartLoadingHandler {
    fun onStartLoadingClick(id: Int)
}

data class MyItem(
    val id: Int,
    val value: Boolean
)

class MyController(
    private val handler: StartLoadingHandler
) : TypedEpoxyController<List<MyItem>>() {

    override fun buildModels(data: List<MyItem>) {
        data.forEach {
            itemRow {
                id(it.id)
                item(it)
                handler(this@MyController.handler)
            }
        }
    }
}