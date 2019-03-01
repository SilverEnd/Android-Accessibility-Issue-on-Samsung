package com.erikzuo.androidplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erikzuo.androidplayground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityBinding: ActivityMainBinding
    private val adapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        activityBinding.list.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        adapter.setData()
    }
}

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val myDataset: MutableList<String> = mutableListOf()

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyAdapter.MyViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(
            R.layout.my_text_view, parent, false
        ) as TextView

        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.textView.text = myDataset[position]
    }

    override fun getItemCount() = myDataset.size

    fun setData() {
        val newList = mutableListOf<String>()
        for (i in 0..100) {
            newList.add("string $i")
        }

        myDataset.apply {
            clear()
            addAll(newList)
        }

        notifyDataSetChanged()
    }
}