package com.example.k

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

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
    private lateinit var ricxvi17: EditText
    private lateinit var ricxvi18: EditText
    private lateinit var ricxvi19: EditText
    private lateinit var ricxvi20: EditText
    private lateinit var ricxvi21: EditText
    private lateinit var ricxvi22: EditText
    private lateinit var ricxvi23: EditText
    private lateinit var ricxvi24: EditText
    private lateinit var ricxvi25: EditText
    private var array = Array(5) { IntArray(5) }
    private var saveArray = Array(5) { IntArray(5) }
    private lateinit var pasuxi: TextView
    private lateinit var button: Button
    private lateinit var ricxvebi: List<EditText>
    private var counter = 0
    private var sachiro = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ricxvi1 = findViewById(R.id.editTextTextPersonName)
        ricxvi2 = findViewById(R.id.editTextTextPersonName2)
        ricxvi3 = findViewById(R.id.editTextTextPersonName3)
        ricxvi4 = findViewById(R.id.editTextTextPersonName4)
        ricxvi5 = findViewById(R.id.editTextTextPersonName5)
        ricxvi6 = findViewById(R.id.editTextTextPersonName6)
        ricxvi7 = findViewById(R.id.editTextTextPersonName7)
        ricxvi8 = findViewById(R.id.editTextTextPersonName8)
        ricxvi9 = findViewById(R.id.editTextTextPersonName9)
        ricxvi10 = findViewById(R.id.editTextTextPersonName10)
        ricxvi11 = findViewById(R.id.editTextTextPersonName11)
        ricxvi12 = findViewById(R.id.editTextTextPersonName12)
        ricxvi13 = findViewById(R.id.editTextTextPersonName13)
        ricxvi14 = findViewById(R.id.editTextTextPersonName14)
        ricxvi15 = findViewById(R.id.editTextTextPersonName15)
        ricxvi16 = findViewById(R.id.editTextTextPersonName16)
        ricxvi17 = findViewById(R.id.editTextTextPersonName17)
        ricxvi18 = findViewById(R.id.editTextTextPersonName18)
        ricxvi19 = findViewById(R.id.editTextTextPersonName19)
        ricxvi20 = findViewById(R.id.editTextTextPersonName20)
        ricxvi21 = findViewById(R.id.editTextTextPersonName21)
        ricxvi22 = findViewById(R.id.editTextTextPersonName22)
        ricxvi23= findViewById(R.id.editTextTextPersonName23)
        ricxvi24= findViewById(R.id.editTextTextPersonName24)
        ricxvi25 = findViewById(R.id.editTextTextPersonName26)
        pasuxi = findViewById(R.id.textView)
        button = findViewById(R.id.button)


        ricxvebi = listOf(
            ricxvi1, ricxvi2, ricxvi3, ricxvi4, ricxvi5, ricxvi6, ricxvi7, ricxvi8,
            ricxvi9, ricxvi10, ricxvi11, ricxvi12, ricxvi13, ricxvi14, ricxvi15, ricxvi16,
            ricxvi17, ricxvi18, ricxvi19, ricxvi20, ricxvi21, ricxvi22, ricxvi23, ricxvi24, ricxvi25
        )
        button.setOnClickListener {
            aba()
        }

    }

    private fun aba(){
        var m  = 0
        var sum = 0
        for(k in 0..4) {
            for(i in 0..4){
                array[k][i] = ricxvebi[m].text.toString().toInt()
                m++
            }
        }
        pasuxi.text = array[1][2].toString()
        var x = 1
        for(i in 0..4) {
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
        var saveArray = Array(4-sachiro){IntArray(4-sachiro)}
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


        for (i in 0..4 - sachiro) {
            if (striqoni == i) {
                continue
            }
            for (m in 0..4 - sachiro) {
                if(sachiro > 0 && sveti == 5 - sachiro - 1) {
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
        for(i in 0..3 - sachiro){
            for (m in 0..3 - sachiro){
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

            for (i in 0..4 - sachiro1) {
                sum =  parent * (determinanti(i, striqoni, sachiro1, saveArray)) + sum
                x = x *(-1)
            }
            return sum
        }
    }
}