package com.example.android_todo_list

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var todolistArray = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1,todolistArray)
        TodoList.adapter=adapter

        TodoButton.setOnClickListener(){
            var todotext = TodoText.text.toString()
            if (todotext.isNotEmpty()){
                todolistArray.add(todotext);
                adapter.notifyDataSetChanged()
                TodoText.setText("");
            }
        }
    }

//    fun TodoButtion_add(view: View) {
//        var edittext:String = TodoText.text.toString()
//
//        if (edittext.isNotEmpty()){
//            todolistArray.add(edittext);
//            TodoText.setText("")
//
//        }
//
//        Toast.makeText(applicationContext,"할일이 추가 되었습니다.",Toast.LENGTH_LONG).show()
//    }
}