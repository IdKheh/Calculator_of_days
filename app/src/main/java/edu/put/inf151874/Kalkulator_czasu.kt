package edu.put.inf151874

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import java.lang.Math.abs

class Kalkulator_czasu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_czasu)
        val plainText1: EditText = findViewById(R.id.HH1)
        val plainText2: EditText = findViewById(R.id.MM1)
        val plainText3: EditText = findViewById(R.id.SS1)
        val plainText4: EditText = findViewById(R.id.HH2)
        val plainText5: EditText = findViewById(R.id.MM2)
        val plainText6: EditText = findViewById(R.id.SS2)

    }
    fun runReset(v: View){
        val plainText1: EditText = findViewById(R.id.HH1)
        val plainText2: EditText = findViewById(R.id.MM1)
        val plainText3: EditText = findViewById(R.id.SS1)
        val plainText4: EditText = findViewById(R.id.HH2)
        val plainText5: EditText = findViewById(R.id.MM2)
        val plainText6: EditText = findViewById(R.id.SS2)

        plainText1.setText("")
        plainText2.setText("")
        plainText3.setText("")
        plainText4.setText("")
        plainText5.setText("")
        plainText6.setText("")
    }
    fun runAdd(v: View){
        val plainText1: EditText = findViewById(R.id.HH1)
        val plainText2: EditText = findViewById(R.id.MM1)
        val plainText3: EditText = findViewById(R.id.SS1)
        val plainText4: EditText = findViewById(R.id.HH2)
        val plainText5: EditText = findViewById(R.id.MM2)
        val plainText6: EditText = findViewById(R.id.SS2)

        if(plainText1.getText().toString() != "" &&plainText2.getText().toString() != ""
            &&plainText3.getText().toString() != ""&&plainText4.getText().toString() != ""
            &&plainText5.getText().toString() != ""&&plainText6.getText().toString() != "") {
            var hh1 = Integer.parseInt(plainText1.getText().toString())
            var mm1 = Integer.parseInt(plainText2.getText().toString())
            var ss1 = Integer.parseInt(plainText3.getText().toString())
            var hh2 = Integer.parseInt(plainText4.getText().toString())
            var mm2 = Integer.parseInt(plainText5.getText().toString())
            var ss2 = Integer.parseInt(plainText6.getText().toString())
            var sekundy=(ss1+mm1*60+hh1*3600)+(ss2+mm2*60+hh2*3600)

            mm1=0
            hh1=0
            ss1=0
            while (sekundy-59>0){
                sekundy-=60
                mm1++
                if(mm1>59){
                    hh1++
                    mm1=0

                }
            }
            ss1 = sekundy % 60
            hh1 % 24


            plainText1.setText(hh1.toString())
            plainText2.setText(mm1.toString())
            plainText3.setText(ss1.toString())
            plainText4.setText("")
            plainText5.setText("")
            plainText6.setText("")
        }
    }
    fun runSub(v: View){
        val plainText1: EditText = findViewById(R.id.HH1)
        val plainText2: EditText = findViewById(R.id.MM1)
        val plainText3: EditText = findViewById(R.id.SS1)
        val plainText4: EditText = findViewById(R.id.HH2)
        val plainText5: EditText = findViewById(R.id.MM2)
        val plainText6: EditText = findViewById(R.id.SS2)

        if(plainText1.getText().toString() != "" &&plainText2.getText().toString() != ""
            &&plainText3.getText().toString() != ""&&plainText4.getText().toString() != ""
            &&plainText5.getText().toString() != ""&&plainText6.getText().toString() != "") {
            var hh1 = Integer.parseInt(plainText1.getText().toString())
            var mm1 = Integer.parseInt(plainText2.getText().toString())
            var ss1 = Integer.parseInt(plainText3.getText().toString())
            var hh2 = Integer.parseInt(plainText4.getText().toString())
            var mm2 = Integer.parseInt(plainText5.getText().toString())
            var ss2 = Integer.parseInt(plainText6.getText().toString())

            var sekundy=(ss1+mm1*60+hh1*3600)-(ss2+mm2*60+hh2*3600)
            var czy_ujemne=false
            if(sekundy<0){
                sekundy=abs(sekundy)
                czy_ujemne=true
            }

            mm1=0
            hh1=0
            while (sekundy-59>0){
                sekundy-=60
                mm1++
                if(mm1>59){
                    hh1++
                    mm1=0

                }
            }
            ss1 = sekundy % 60
            hh1 % 24
            if(czy_ujemne){
                plainText1.setText("-"+hh1.toString())
            }
            else{
                plainText1.setText(hh1.toString())
            }
            plainText2.setText(mm1.toString())
            plainText3.setText(ss1.toString())
            plainText4.setText("")
            plainText5.setText("")
            plainText6.setText("")
        }
    }
}