package com.example.lv1drugiput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var editText: EditText
    lateinit var button: Button

    private val listaVrijednosti = arrayListOf<String>()
    private lateinit var adapter: MyArrayAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<Button>(R.id.button1)
        editText = findViewById<EditText>(R.id.editText1)
        listView = findViewById<ListView>(R.id.listView1)
        adapter = MyArrayAdapter(this, R.layout.element_list, listaVrijednosti)
        listView.adapter = adapter
        button.setOnClickListener(){
            addToList()
        }
    }

    private fun addToList() {
        listaVrijednosti.add(0,editText.text.toString())
        adapter.notifyDataSetChanged()
        editText.setText("")
    }


}