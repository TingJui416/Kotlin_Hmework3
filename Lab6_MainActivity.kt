package com.example.lab6

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --- 1. 設定 Spinner (使用 trans_list.xml) ---
        val transNameArray = arrayOf("腳踏車", "機車", "汽車", "巴士", "飛機", "輪船")
        val transPhotoIdArray = arrayOf(
            R.drawable.trans1, R.drawable.trans2, R.drawable.trans3,
            R.drawable.trans4, R.drawable.trans5, R.drawable.trans6
        )
        val transData = Array(transNameArray.size) { i ->
            Data(transPhotoIdArray[i], transNameArray[i])
        }
        val transAdapter = MyAdapter(this, transData, R.layout.trans_list)
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.adapter = transAdapter

        // --- 2. 設定 GridView (使用 cubee_list.xml，顯示 3 列) ---
        val cubeeNameArray = arrayOf("哭哭", "發抖", "再見", "生氣", "昏倒", "竊笑", "很棒", "你好", "驚嚇", "大笑")
        val cubeePhotoIdArray = arrayOf(
            R.drawable.cubee1, R.drawable.cubee2, R.drawable.cubee3, R.drawable.cubee4,
            R.drawable.cubee5, R.drawable.cubee6, R.drawable.cubee7, R.drawable.cubee8,
            R.drawable.cubee9, R.drawable.cubee10
        )
        val cubeeData = Array(cubeeNameArray.size) { i ->
            Data(cubeePhotoIdArray[i], cubeeNameArray[i])
        }
        val cubeeAdapter = MyAdapter(this, cubeeData, R.layout.cubee_list)
        val gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter = cubeeAdapter
        gridView.numColumns = 3

        // --- 3. 設定 ListView (使用 Android 內建 simple_list_item_1) ---
        val messageArray = arrayOf("訊息1", "訊息2", "訊息3", "訊息4", "訊息5", "訊息6")
        val messageAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, messageArray)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = messageAdapter
    }
}
