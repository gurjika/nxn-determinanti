package com.example.k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private var array = Array(4) { IntArray(4) }
    private var saveArray = Array(4){IntArray(4)}
    private lateinit var ricxvi1: EditText
    private lateinit var ricxvi2: EditText
    private lateinit var ricxvi3: EditText
    private lateinit var ricxvi4: EditText
    private lateinit var ricxvi5: EditText
    private lateinit var ricxvi6: EditText
    private lateinit var ricxvi7: EditText
    private lateinit var ricxvi8: EditText
    private lateinit var ricxvi9: EditText
    private lateinit var ricxvi10: EditText
    private lateinit var ricxvi11: EditText
    private lateinit var ricxvi12: EditText
    private lateinit var ricxvi13: EditText
    private lateinit var ricxvi14: EditText
    private lateinit var ricxvi15: EditText
    private lateinit var ricxvi16: EditText
    private lateinit var pasuxi: TextView

    private lateinit var result4:Button
    private var counter = 0
    private var sachiro = 0

    private lateinit var ricxvebi: List<EditText>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        pasuxi = findViewById(R.id.textView12)
        result4 = findViewById(R.id.result4)
        ricxvi1 = findViewById(R.id.ditTextTextPersonName)
        ricxvi2 = findViewById(R.id.ditTextTextPersonName2)
        ricxvi3 = findViewById(R.id.ditTextTextPersonName3)
        ricxvi4 = findViewById(R.id.ditTextTextPersonName4)
        ricxvi5 = findViewById(R.id.ditTextTextPersonName5)
        ricxvi6 = findViewById(R.id.ditTextTextPersonName6)
        ricxvi7 = findViewById(R.id.ditTextTextPersonName7)
        ricxvi8 = findViewById(R.id.ditTextTextPersonName8)
        ricxvi9 = findViewById(R.id.ditTextTextPersonName9)
        ricxvi10 = findViewById(R.id.ditTextTextPersonName10)
        ricxvi11 = findViewById(R.id.ditTextTextPersonName11)
        ricxvi12 = findViewById(R.id.ditTextTextPersonName12)
        ricxvi13 = findViewById(R.id.ditTextTextPersonName13)
        ricxvi14 = findViewById(R.id.ditTextTextPersonName14)
        ricxvi15 = findViewById(R.id.ditTextTextPersonName15)
        ricxvi16 = findViewById(R.id.ditTextTextPersonName16)
        ricxvebi = listOf(
            ricxvi1, ricxvi2, ricxvi3, ricxvi4, ricxvi5, ricxvi6, ricxvi7, ricxvi8,
            ricxvi9, ricxvi10, ricxvi11, ricxvi12, ricxvi13, ricxvi14, ricxvi15, ricxvi16
        )
        result4.setOnClickListener {
            aba()
        }

    }

    private fun aba(){
        var m  = 0
        var sum = 0
        for(k in 0..3) {
            for(i in 0..3){
                array[k][i] = ricxvebi[m].text.toString().toInt()
                m++
            }
        }
        pasuxi.text = array[1][2].toString()
        var x = 1
        for(i in 0..3) {
            if((i + 0)%2!=0){
                x = -x
            }
            sum = determinanti(i, 0, 0, saveArray) + sum
        }
        pasuxi.text = sum.toString()
    }
    private fun determinanti(sveti:Int, striqoni:Int, sachiro:Int, Array:Array<IntArray>):Int{

        var parent = 0
        var kide = sveti
        var saveArray = Array(3-sachiro){IntArray(3-sachiro)}
        if(sachiro == 0){
            parent = array[striqoni][sveti]
        }
        if(sachiro > 0){
            parent = Array[striqoni][sveti]
        }
        if((sveti + striqoni) % 2 !=0){
            parent = -parent
        }


        var temporary:MutableList<Int> = mutableListOf()
        var e = 0


        for (i in 0..3 - sachiro) {
            if (striqoni == i) {
                continue
            }
            for (m in 0..3 - sachiro) {
                if(sachiro > 0 && sveti == 4 - sachiro - 1) {
                    if(sveti == m) {
                        continue
                    }
                }
                if(sveti == m ){
                    continue
                }
                if(sachiro == 0){
                    temporary.add(array[i][m])
                }
                if(sachiro!=0){
                    temporary.add(Array[i][m])
                }
            }
        }
        for(i in 0..2 - sachiro){
            for (m in 0..2 - sachiro){
                saveArray[i][m] = temporary[e]
                e++
            }
        }
        var sachiro1 = sachiro + 1
        if(temporary.size == 4) {
            return parent*(saveArray[0][0]*saveArray[1][1]-saveArray[1][0]*saveArray[0][1])
        }
        else {
            var sum = 0
            var x = 1

            for (i in 0..3 - sachiro1) {
                sum =  parent * (determinanti(i, striqoni, sachiro1, saveArray)) + sum
                x = x *(-1)
            }
            return sum
        }
    }
}