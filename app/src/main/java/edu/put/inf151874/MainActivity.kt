package edu.put.inf151874

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE =10000
    private lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun runDate(v: View){
        val i=Intent(this,KalkulatorDaty::class.java)
        startActivity(i)
    }
    fun runTime(v: View){
        val i=Intent(this,Kalkulator_czasu::class.java)
        startActivity(i)
    }
}