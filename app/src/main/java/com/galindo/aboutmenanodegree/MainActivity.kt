package com.galindo.aboutmenanodegree

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.galindo.aboutmenanodegree.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var myName: MyName = MyName("Thiago Galindo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            // Refresh UI
            invalidateAll()
            nicknameText.visibility = View.VISIBLE
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }


}