package com.example.android_todo_list

import android.os.Bundle
import android.util.SparseBooleanArray
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var todolistArray = arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1,todolistArray)

        TodoButton_add.setOnClickListener(){
            var todotext = TodoText.text.toString()
            if (todotext.isNotEmpty()){
                todolistArray.add(todotext);
                TodoList.adapter=adapter
                adapter.notifyDataSetChanged()
                TodoText.text.clear()
                Toast.makeText(applicationContext, "할일이 추가되었습니다.", Toast.LENGTH_LONG).show()
            }
        }

        TodoList.setOnItemClickListener(){
            parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            android.widget.Toast.makeText(this, "항목을 선택하였습니다",android.widget.Toast.LENGTH_LONG ).show()
        }

        TodoButton_delete.setOnClickListener(){
            val position :SparseBooleanArray = TodoList.checkedItemPositions
            val count = TodoList.count
            var item = count -1
            while(item>=0){
                if(position.get(item)){
                    adapter.remove(todolistArray.get(item))
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()
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