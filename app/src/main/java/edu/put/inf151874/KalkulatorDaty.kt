package edu.put.inf151874

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import kotlin.math.abs


class KalkulatorDaty : AppCompatActivity() {
    private var days=0
    private var jobDays=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator_daty)

        val numberPicker1: NumberPicker= findViewById(R.id.numberPicker1)
        val numberPicker2: NumberPicker= findViewById(R.id.numberPicker2)
        val numberPicker3: NumberPicker= findViewById(R.id.numberPicker3)
        val numberPicker4: NumberPicker= findViewById(R.id.numberPicker4)
        val numberPicker5: NumberPicker= findViewById(R.id.numberPicker5)
        val numberPicker6: NumberPicker= findViewById(R.id.numberPicker6)
        val miesiace = arrayOf("Styczeń","Luty","Marzec","Kwiecień","Maj","Czerwiec","Lipiec","Sierpień","Wrzesień","Październik","Listopad","Grudzień")

        numberPicker1.minValue = 1 //dni picker 1
        numberPicker1.maxValue=31
        numberPicker1.wrapSelectorWheel=true

        numberPicker2.wrapSelectorWheel=true //miesiace picker 1
        numberPicker2.maxValue=0
        numberPicker2.maxValue=11
        numberPicker2.displayedValues=miesiace

        numberPicker3.minValue=1920 //lata picker 1
        numberPicker3.maxValue=2120
        numberPicker3.wrapSelectorWheel=true

        numberPicker4.minValue=1    //dni picker 2
        numberPicker4.maxValue=31
        numberPicker4.wrapSelectorWheel=true

        numberPicker5.wrapSelectorWheel=true //miesiace picker 2
        numberPicker5.maxValue=0
        numberPicker5.maxValue=11
        numberPicker5.displayedValues=miesiace

        numberPicker6.minValue=1920 //lata picker 2
        numberPicker6.maxValue=2120
        numberPicker6.wrapSelectorWheel=true

        var czyPrzestepny=true //poprawne wyświtlanie dat 1
        var miesiac=0
        var czyPrzestepny2=true //poprawne wyświtlanie dat 2
        var miesiac2=0


        numberPicker1.setOnValueChangedListener() { picker, oldVal, newVal ->
            licznikDni(
                numberPicker1.value, miesiac+1,numberPicker3.value,
                numberPicker4.value, miesiac2+1,numberPicker6.value
            )
            licznikDniRoboczych(
                numberPicker1.value, miesiac+1,numberPicker3.value,
                numberPicker4.value, miesiac2+1,numberPicker6.value
            )
        }
        numberPicker2.setOnValueChangedListener(){
                picker, oldVal, newVal ->
            val selected = miesiace[newVal]
            miesiac=newVal
            if(newVal == 1 && czyPrzestepny) numberPicker1.maxValue=29
            else if(newVal == 1 && czyPrzestepny==false) numberPicker1.maxValue=28
            else if(newVal==3 || newVal==5 || newVal==8 || newVal==10) numberPicker1.maxValue=30
            else numberPicker1.maxValue=31
            licznikDni(
                numberPicker1.value,
                miesiac+1,
                numberPicker3.value,
                numberPicker4.value,
                miesiac2+1,
                numberPicker6.value
            )
            licznikDniRoboczych(
                numberPicker1.value, miesiac+1,numberPicker3.value,
                numberPicker4.value, miesiac2+1,numberPicker6.value
            )
        }
        numberPicker3.setOnValueChangedListener() {
                picker, oldVal, newVal ->
            val date: LocalDate = LocalDate.of(Integer.parseInt(numberPicker3.getValue().toString()), 2, 1)
            val days: Int = date.lengthOfMonth()
            if(days==29) czyPrzestepny=true
            else czyPrzestepny=false

            if(miesiac==1 && czyPrzestepny) numberPicker1.maxValue=29
            if(miesiac==1 && czyPrzestepny==false) numberPicker1.maxValue=28
            licznikDni(
                numberPicker1.value,
                miesiac+1,
                numberPicker3.value,
                numberPicker4.value,
                miesiac2+1,
                numberPicker6.value
            )
            licznikDniRoboczych(
                numberPicker1.value, miesiac+1,numberPicker3.value,
                numberPicker4.value, miesiac2+1,numberPicker6.value
            )
        }
        numberPicker4.setOnValueChangedListener() { picker, oldVal, newVal ->
            licznikDni(
                numberPicker1.value,
                miesiac+1,
                numberPicker3.value,
                numberPicker4.value,
                miesiac2+1,
                numberPicker6.value
            )
            licznikDniRoboczych(
                numberPicker1.value, miesiac+1,numberPicker3.value,
                numberPicker4.value, miesiac2+1,numberPicker6.value
            )
        }
        numberPicker5.setOnValueChangedListener(){
                picker, oldVal, newVal ->
            val selected = miesiace[newVal]
            miesiac2=newVal
            if(newVal == 1 && czyPrzestepny2) numberPicker4.maxValue=29
            else if(newVal == 1 && czyPrzestepny2==false) numberPicker4.maxValue=28
            else if(newVal==3 || newVal==5 || newVal==8 || newVal==10) numberPicker4.maxValue=30
            else numberPicker4.maxValue=31

            licznikDni(
                numberPicker1.value,
                miesiac+1,
                numberPicker3.value,
                numberPicker4.value,
                miesiac2+1,
                numberPicker6.value
            )
            licznikDniRoboczych(
                numberPicker1.value, miesiac+1,numberPicker3.value,
                numberPicker4.value, miesiac2+1,numberPicker6.value
            )
        }
        numberPicker6.setOnValueChangedListener() { //cd wyswietlania 2
                picker, oldVal, newVal ->
            val date: LocalDate = LocalDate.of(Integer.parseInt(numberPicker6.getValue().toString()), 2, 1)
            val days: Int = date.lengthOfMonth()
            if(days==29) czyPrzestepny2=true
            else czyPrzestepny2=false

            if(miesiac2==1 && czyPrzestepny2) numberPicker4.maxValue=29
            if(miesiac2==1 && czyPrzestepny2==false) numberPicker4.maxValue=28
            licznikDni(
                numberPicker1.value,
                miesiac+1,
                numberPicker3.value,
                numberPicker4.value,
                miesiac2+1,
                numberPicker6.value
            )
            licznikDniRoboczych(
                numberPicker1.value, miesiac+1,numberPicker3.value,
                numberPicker4.value, miesiac2+1,numberPicker6.value
            )
        }
    }
    fun licznikDni(D1:Int,M1:Int,Y1:Int,D2:Int,M2:Int,Y2:Int){
        days=0
        if(D1>D2 && M1>=M2 && Y1>=Y2) days=0
        else{
        for(i in Y1..Y2){
            val date: LocalDate = LocalDate.of(i, 2, 1)
            val przestepny: Int = date.lengthOfMonth()
            if(i==Y2)
            {
                for(j in M1..M2) {
                    if(j==M2 && D2>=D1){
                        days+=abs(D2-D1)
                    }
                    else if(j==M2-1 && D2<D1){
                        var ileDni=0
                        if (j == 4 || j == 6 || j == 9 || j == 11) ileDni += 30
                        else if (j==2) ileDni += przestepny //dodac przestepnosc
                        else ileDni+=31
                        days+=abs(ileDni-D1+D2)
                        break
                    }
                    else{
                        if (j == 4 || j == 6 || j == 9 || j == 11) days += 30
                        else if (j==2) days += przestepny //dodac przestepnosc
                        else days+=31
                    }
                }
            }
            else {
                if(przestepny==29) days+=366
                else days+=365
            }
        }}
        val plainText: EditText = findViewById(R.id.day)
        plainText.setText(days.toString())
    }
    fun parserDaty(d: Int, m: Int, y: Int): Int {
        var czy_pracujacy=0
        //1 stycznia, 6 stycznia, 1 maja, 3 maja, 15 sierpnia, 1 listopada
        //11 listopada, 25 grudnia i 26 grudnia, boze cialo, wielkanoc
        val a = y % 19 // wielkanoc
        val b =y / 100
        val c = y% 100
        val t = b / 4
        val e = b % 4
        val f = (b + 8) / 25
        val g= (b-f+1)/3
        val h = (19*a +b -t -g +15)%30
        val i = c / 4
        val k = c % 4
        val l = ((32 + (2 * e) + (2 * i)) - h - k) % 7
        val r = (a + 11 * h + 22 * l) / 451
        val p = (h+l -7*r +114)%31
        val dzien = p + 1
        val miesiac = (h+l-7 * r+114)/31

        var dzienBoze=dzien
        var miesiacBoze=miesiac

        for(x in 1 ..60){
            if((miesiacBoze==3 && dzienBoze<31)||(miesiacBoze==4 && dzienBoze <30)||
                (miesiacBoze==5 && dzienBoze <31)||(miesiacBoze==6 && dzienBoze <31)) {
                dzienBoze++
            }
            else if((miesiacBoze==3 && dzienBoze == 31)||(miesiacBoze==4 && dzienBoze ==30)||
                (miesiacBoze==5 && dzienBoze ==31)){
                dzienBoze=1
                miesiacBoze++
            }
        }

        if((d==1 && m==1)||(d==6 && m==1)||(d==1 && m==5)||(d==3 && m==5)||(d==15 && m==8)||(d==1 && m==11)
            ||(d==11 && m==11)||(d==25 && m==12)||(d==26 && m==12)||(d==dzien+1 && m==miesiac)||(d==dzienBoze && m==miesiacBoze)){
            czy_pracujacy=0
        }
        else {
            if (d < 10 && m < 10) {
                val dt = LocalDate.parse(y.toString() + "-0" + m.toString() + "-0" + d.toString())
                if (dt.dayOfWeek.value == 1 || dt.dayOfWeek.value == 2 ||
                    dt.dayOfWeek.value == 3 || dt.dayOfWeek.value == 4 ||
                    dt.dayOfWeek.value == 5
                ) {
                    czy_pracujacy = 1
                }
            } else if (d >= 10 && m < 10) {
                val dt = LocalDate.parse(y.toString() + "-0" + m.toString() + "-" + d.toString())
                if (dt.dayOfWeek.value == 1 || dt.dayOfWeek.value == 2 ||
                    dt.dayOfWeek.value == 3 || dt.dayOfWeek.value == 4 ||
                    dt.dayOfWeek.value == 5
                ) {
                    czy_pracujacy = 1
                }
            } else if (d < 10 && m >= 10) {
                val dt = LocalDate.parse(y.toString() + "-" + m.toString() + "-0" + d.toString())
                if (dt.dayOfWeek.value == 1 || dt.dayOfWeek.value == 2 ||
                    dt.dayOfWeek.value == 3 || dt.dayOfWeek.value == 4 ||
                    dt.dayOfWeek.value == 5
                ) {
                    czy_pracujacy = 1
                }
            } else {
                val dt = LocalDate.parse(y.toString() + "-" + m.toString() + "-" + d.toString())
                if (dt.dayOfWeek.value == 1 || dt.dayOfWeek.value == 2 ||
                    dt.dayOfWeek.value == 3 || dt.dayOfWeek.value == 4 ||
                    dt.dayOfWeek.value == 5
                ) {
                    czy_pracujacy = 1
                }
            }
        }
        return czy_pracujacy
    }
    fun licznikDniRoboczych(D1:Int,M1:Int,Y1:Int,D2:Int,M2:Int,Y2:Int){
        val textView: TextView = findViewById(R.id.textView)
        jobDays=0
        for(y in Y1..Y2) {
            val date: LocalDate = LocalDate.of(y, 2, 1)
            val przestepny: Int = date.lengthOfMonth()
            if(y==Y2){ //jesli mamy ostatni rok
                if(Y1==Y2){ //jesli mamy ten sam rok w jednej i drugiej dacie
                    for(m in M1 .. M2){
                        var ileDni=0
                        if (m == 4 || m == 6 || m == 9 || m == 11) ileDni += 30
                        else if (m==2) ileDni += przestepny //dodac przestepnosc
                        else ileDni+=31
                        if(m==M2 && M1!=M2){
                            for (d in 1..D2) {
                                jobDays+=parserDaty(d, m, y)
                            }
                        }
                        else if(M1==M2){
                            for (d in D1+1..D2) {
                                jobDays+=parserDaty(d, m, y)
                            }
                        }
                        else if(m==M1){
                            for (d in D1..ileDni) {
                                jobDays+=parserDaty(d, m, y)
                            }
                        }
                        else {
                            for (d in 1..ileDni) {
                                jobDays+=parserDaty(d, m, y)
                            }
                        }
                    }
                }
                else{
                    for(m in 1 .. M2){ // od stycznia do M2
                        var ileDni=0
                        if (m == 4 || m == 6 || m == 9 || m == 11) ileDni += 30
                        else if (m==2) ileDni += przestepny //dodac przestepnosc
                        else ileDni+=31
                        if(m==M2){
                            for (d in 1..D2) {
                                jobDays+=parserDaty(d, m, y)
                            }
                        }
                        else{
                            for (d in 1..ileDni) {
                                jobDays+=parserDaty(d, m, y)
                            }
                        }
                    }
                }
            }
            else if(y==Y1){ // jesli mamy niepelny rok
                for(m in M1..12) {
                    var ileDni=0
                    if (m == 4 || m == 6 || m == 9 || m == 11) ileDni += 30
                    else if (m==2) ileDni += przestepny //dodac przestepnosc
                    else ileDni+=31
                    if(m==M1){ // od 1 dnia do konca miesiaca juz zaczetego
                        for (d in D1..ileDni){
                            jobDays+=parserDaty(d, m, y)
                        }
                    }
                    else{//pozosale
                        for (d in 1..ileDni) {
                            jobDays+=parserDaty(d, m, y)
                        }
                    }
                }
            }
            else{ //pozostale
                for(m in 1..12) {
                    var ileDni=0
                    if (m == 4 || m == 6 || m == 9 || m == 11) ileDni += 30
                    else if (m==2) ileDni += przestepny //dodac przestepnosc
                    else ileDni+=31
                    for (d in 1..ileDni) {
                        jobDays+=parserDaty(d, m, y)
                    }
                }
            }
        }
        if(D1==D2 && M1==M2 && Y1==Y2){
            jobDays=0
        }

        textView.setText("Dni roboczych pomiędzy datami: "+jobDays.toString())
    }
    fun AddPicker()
    {
        val plainText: EditText = findViewById(R.id.day)

        val numberPicker1: NumberPicker= findViewById(R.id.numberPicker1)
        val numberPicker2: NumberPicker= findViewById(R.id.numberPicker2)
        val numberPicker3: NumberPicker= findViewById(R.id.numberPicker3)
        val numberPicker4: NumberPicker= findViewById(R.id.numberPicker4)
        val numberPicker5: NumberPicker= findViewById(R.id.numberPicker5)
        val numberPicker6: NumberPicker= findViewById(R.id.numberPicker6)
        var czyPrzestepny2=true

        if(numberPicker4.value==numberPicker4.maxValue && numberPicker5.value==numberPicker5.maxValue){
            numberPicker6.setValue(numberPicker6.value + 1)
            numberPicker5.setValue(numberPicker5.value + 1)
            val date: LocalDate = LocalDate.of(Integer.parseInt(numberPicker6.getValue().toString()), 2, 1)
            val days: Int = date.lengthOfMonth()
            if(days==29) czyPrzestepny2=true
            else czyPrzestepny2=false
            if(numberPicker5.value == 1 && czyPrzestepny2) numberPicker4.maxValue=29
            else if(numberPicker5.value == 1 && czyPrzestepny2==false) numberPicker4.maxValue=28
            else if(numberPicker5.value==3 || numberPicker5.value==5 || numberPicker5.value==8 || numberPicker5.value==10) numberPicker4.maxValue=30
            else numberPicker4.maxValue=31
        }
        else if(numberPicker4.value==numberPicker4.maxValue && numberPicker5.value!=numberPicker5.maxValue){
            numberPicker5.setValue(numberPicker5.value + 1)

            val date: LocalDate = LocalDate.of(Integer.parseInt(numberPicker6.getValue().toString()), 2, 1)
            val days: Int = date.lengthOfMonth()
            if(days==29) czyPrzestepny2=true
            else czyPrzestepny2=false

            if(numberPicker5.value == 1 && czyPrzestepny2) numberPicker4.maxValue=29
            else if(numberPicker5.value == 1 && czyPrzestepny2==false) numberPicker4.maxValue=28
            else if(numberPicker5.value==3 || numberPicker5.value==5 || numberPicker5.value==8 || numberPicker5.value==10) numberPicker4.maxValue=30
            else numberPicker4.maxValue=31
        }
        numberPicker4.setValue(numberPicker4.value + 1)
        licznikDni(
            numberPicker1.value, numberPicker2.value+1,numberPicker3.value,
            numberPicker4.value, numberPicker5.value+1,numberPicker6.value
        )
        licznikDniRoboczych(
            numberPicker1.value, numberPicker2.value+1,numberPicker3.value,
            numberPicker4.value, numberPicker5.value+1,numberPicker6.value
        )
        plainText.setText(days.toString())
    }
    fun SubPicker(){
        val plainText: EditText = findViewById(R.id.day)

        val numberPicker1: NumberPicker= findViewById(R.id.numberPicker1)
        val numberPicker2: NumberPicker= findViewById(R.id.numberPicker2)
        val numberPicker3: NumberPicker= findViewById(R.id.numberPicker3)
        val numberPicker4: NumberPicker= findViewById(R.id.numberPicker4)
        val numberPicker5: NumberPicker= findViewById(R.id.numberPicker5)
        val numberPicker6: NumberPicker= findViewById(R.id.numberPicker6)
        var czyPrzestepny2=true

        if(numberPicker4.value==numberPicker4.minValue && numberPicker5.value==numberPicker5.minValue){
            numberPicker6.setValue(numberPicker6.value - 1)
            numberPicker5.setValue(numberPicker5.value - 1)
            val date: LocalDate = LocalDate.of(Integer.parseInt(numberPicker6.getValue().toString()), 2, 1)
            val days: Int = date.lengthOfMonth()
            if(days==29) czyPrzestepny2=true
            else czyPrzestepny2=false
            if(numberPicker5.value == 1 && czyPrzestepny2) numberPicker4.maxValue=29
            else if(numberPicker5.value == 1 && czyPrzestepny2==false) numberPicker4.maxValue=28
            else if(numberPicker5.value==3 || numberPicker5.value==5 || numberPicker5.value==8 || numberPicker5.value==10) numberPicker4.maxValue=30
            else numberPicker4.maxValue=31
        }
        else if(numberPicker4.value==numberPicker4.minValue && numberPicker5.value!=numberPicker5.minValue){
            numberPicker5.setValue(numberPicker5.value - 1)

            val date: LocalDate = LocalDate.of(Integer.parseInt(numberPicker6.getValue().toString()), 2, 1)
            val days: Int = date.lengthOfMonth()
            if(days==29) czyPrzestepny2=true
            else czyPrzestepny2=false

            if(numberPicker5.value == 1 && czyPrzestepny2) numberPicker4.maxValue=29
            else if(numberPicker5.value == 1 && czyPrzestepny2==false) numberPicker4.maxValue=28
            else if(numberPicker5.value==3 || numberPicker5.value==5 || numberPicker5.value==8 || numberPicker5.value==10) numberPicker4.maxValue=30
            else numberPicker4.maxValue=31
        }
        numberPicker4.setValue(numberPicker4.value - 1)
        licznikDni(
            numberPicker1.value, numberPicker2.value+1,numberPicker3.value,
            numberPicker4.value, numberPicker5.value+1,numberPicker6.value
        )
        licznikDniRoboczych(
            numberPicker1.value, numberPicker2.value+1,numberPicker3.value,
            numberPicker4.value, numberPicker5.value+1,numberPicker6.value
        )
        plainText.setText(days.toString())
    }
   fun runAdd(v: View) {
       AddPicker()
    }
    fun runSub(v: View) {
        SubPicker()
    }
    fun runPlainText(v: View) {
        val plainText: EditText = findViewById(R.id.day)
        if(plainText.getText().toString() != "") {
            var value = Integer.parseInt(plainText.getText().toString()) - days
            if(value>=0) {
                for (i in 1..value) {
                    AddPicker()
                }
            }
            else{
                value=abs(value)
                for (i in 1..value) {
                    SubPicker()
                }
            }
        }
    }
}