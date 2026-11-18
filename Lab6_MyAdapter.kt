package com.example.lab6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

data class Data(val photo: Int, val name: String)

class MyAdapter(
    private val context: Context,
    private val data: Array<Data>,
    private val layoutResId: Int
) : BaseAdapter() {

    override fun getCount(): int = data.size

    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(layoutResId, parent, false)

        val nameTextView = view.findViewById<TextView>(R.id.name)
        val imageView = view.findViewById<ImageView>(R.id.imageView)

        nameTextView.text = data[position].name
        imageView.setImageResource(data[position].photo)

        return view
    }
}
