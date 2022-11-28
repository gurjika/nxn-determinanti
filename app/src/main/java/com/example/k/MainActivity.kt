package com.example.k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var number1: EditText
    private lateinit var number2: EditText
    private lateinit var number3: EditText
    private lateinit var number4: EditText
    private lateinit var number5: EditText
    private lateinit var number6: EditText
    private lateinit var number7: EditText
    private lateinit var number8: EditText
    private lateinit var number9: EditText
    private lateinit var number10: EditText
    private lateinit var number11: EditText
    private lateinit var number12: EditText
    private lateinit var number13: EditText
    private lateinit var number14: EditText
    private lateinit var number15: EditText
    private lateinit var number16: EditText
    private lateinit var number17: EditText
    private lateinit var number18: EditText
    private lateinit var number19: EditText
    private lateinit var number20: EditText
    private lateinit var number21: EditText
    private lateinit var number22: EditText
    private lateinit var number23: EditText
    private lateinit var number24: EditText
    private lateinit var number25: EditText
    private var N = 0
    private var array = Array(5) { IntArray(5) }
    private var saveArray = Array(5) { IntArray(5) }
    private lateinit var result: TextView
    private lateinit var button: Button
    private lateinit var numbers: MutableList<EditText>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        number1 = findViewById(R.id.ditTextTextPersonName)
        number2 = findViewById(R.id.editTextTextPersonName2)
        number3 = findViewById(R.id.editTextTextPersonName3)
        number4 = findViewById(R.id.editTextTextPersonName4)
        number5 = findViewById(R.id.editTextTextPersonName5)
        number6 = findViewById(R.id.editTextTextPersonName6)
        number7 = findViewById(R.id.editTextTextPersonName7)
        number8 = findViewById(R.id.editTextTextPersonName8)
        number9 = findViewById(R.id.editTextTextPersonName9)
        number10 = findViewById(R.id.editTextTextPersonName10)
        number11 = findViewById(R.id.editTextTextPersonName11)
        number12 = findViewById(R.id.editTextTextPersonName12)
        number13 = findViewById(R.id.editTextTextPersonName13)
        number14 = findViewById(R.id.editTextTextPersonName14)
        number15 = findViewById(R.id.editTextTextPersonName15)
        number16 = findViewById(R.id.editTextTextPersonName16)
        number17 = findViewById(R.id.editTextTextPersonName17)
        number18 = findViewById(R.id.editTextTextPersonName18)
        number19 = findViewById(R.id.editTextTextPersonName19)
        number20 = findViewById(R.id.editTextTextPersonName20)
        number21 = findViewById(R.id.editTextTextPersonName21)
        number22 = findViewById(R.id.editTextTextPersonName22)
        number23= findViewById(R.id.editTextTextPersonName23)
        number24= findViewById(R.id.editTextTextPersonName24)
        number25 = findViewById(R.id.editTextTextPersonName26)
        result = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        val n = intent?.extras?.getString("N")
        N = n.toString().toInt()

        numbers = mutableListOf(
            number1, number2, number3, number4, number5, number6, number7, number8,
            number9, number10, number11, number12, number13, number14, number15, number16,
            number17, number18, number19, number20, number21, number22, number23, number24, number25
        )
        if(N == 4) {
            number1.visibility = View.INVISIBLE
            number2.visibility = View.INVISIBLE
            number3.visibility = View.INVISIBLE
            number4.visibility = View.INVISIBLE
            number5.visibility = View.INVISIBLE
            number6.visibility = View.INVISIBLE
            number11.visibility = View.INVISIBLE
            number16.visibility = View.INVISIBLE
            number21.visibility = View.INVISIBLE
            array = Array(N) { IntArray(N) }
            numbers.remove(number1)
            numbers.remove(number2)
            numbers.remove(number3)
            numbers.remove(number4)
            numbers.remove(number5)
            numbers.remove(number6)
            numbers.remove(number11)
            numbers.remove(number16)
            numbers.remove(number21)
        }
        if(N == 3){
            number1.visibility = View.INVISIBLE
            number2.visibility = View.INVISIBLE
            number3.visibility = View.INVISIBLE
            number4.visibility = View.INVISIBLE
            number5.visibility = View.INVISIBLE
            number6.visibility = View.INVISIBLE
            number11.visibility = View.INVISIBLE
            number16.visibility = View.INVISIBLE
            number21.visibility = View.INVISIBLE
            number10.visibility = View.INVISIBLE
            number15.visibility = View.INVISIBLE
            number20.visibility = View.INVISIBLE
            number25.visibility = View.INVISIBLE
            number22.visibility = View.INVISIBLE
            number23.visibility = View.INVISIBLE
            number24.visibility = View.INVISIBLE

            array = Array(N) { IntArray(N) }
            numbers.remove(number1)
            numbers.remove(number2)
            numbers.remove(number3)
            numbers.remove(number4)
            numbers.remove(number5)
            numbers.remove(number6)
            numbers.remove(number11)
            numbers.remove(number16)
            numbers.remove(number21)
            numbers.remove(number10)
            numbers.remove(number15)
            numbers.remove(number20)
            numbers.remove(number25)
            numbers.remove(number22)
            numbers.remove(number23)
            numbers.remove(number24)


        }

        button.setOnClickListener {
            aba()
        }

    }

    private fun aba(){
        var m  = 0
        var sum = 0
        for(k in 0..N -1) {
            for(i in 0..N - 1){
                array[k][i] = numbers[m].text.toString().toInt()
                m++
            }
        }
        result.text = array[1][2].toString()
        var x = 1
        for(i in 0..N - 1) {
            if((i + 0)%2!=0){
                x = -x
            }
            sum = determinant(i, 0, 0, saveArray) + sum
        }
        result.text = sum.toString()
    }
    private fun determinant(row:Int, column:Int, needed:Int, Array:Array<IntArray>):Int{

        var parent = 0

        var saveArray = Array((N - 1)- needed){IntArray((N - 1)- needed)}
        if(needed == 0){
            parent = array[column][row]
        }
        if(needed > 0){
            parent = Array[column][row]
        }
        if((row + column) % 2 !=0){
            parent = -parent
        }


        var temporary:MutableList<Int> = mutableListOf()
        var e = 0


        for (i in 0.. (N - 1)- needed) {
            if (column == i) {
                continue
            }
            for (m in 0..(N - 1) - needed) {
                if(needed > 0 && row == N - needed - 1) {
                    if(row == m) {
                        continue
                    }
                }
                if(row == m ){
                    continue
                }
                if(needed == 0){
                    temporary.add(array[i][m])
                }
                if(needed !=0){
                    temporary.add(Array[i][m])
                }
            }
        }
        for(i in 0..(N - 2) - needed){
            for (m in 0..(N - 2) - needed){
                saveArray[i][m] = temporary[e]
                e++
            }
        }
        var needed1 = needed + 1
        if(temporary.size == 4) {
            return parent*(saveArray[0][0]*saveArray[1][1]-saveArray[1][0]*saveArray[0][1])
        }
        else {
            var sum = 0
            var x = 1

            for (i in 0..(N - 1) - needed1) {
                sum =  parent * (determinant(i, column, needed1, saveArray)) + sum
            }
            return sum
        }
    }
}