package info.jakariya.bmicalculator

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var btnMale: LinearLayout
    lateinit var btnFemale: LinearLayout
    lateinit var tvHeight: TextView
    lateinit var seekBar: SeekBar
    lateinit var tvAge: TextView
    lateinit var tvWeight: TextView
    lateinit var btnWeightPlus: FloatingActionButton
    lateinit var btnWeightMinus: FloatingActionButton
    lateinit var btnAgePlus: FloatingActionButton
    lateinit var btnAgeMinus: FloatingActionButton
    lateinit var btnCalculate: LinearLayout

    var weight = 1; var age = 1; var height = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMale = findViewById(R.id.btn_male_id)
        btnFemale = findViewById(R.id.btn_female_id)
        tvHeight = findViewById(R.id.tv_height_id)
        tvWeight = findViewById(R.id.tv_weight_id)
        tvAge = findViewById(R.id.tv_age_id)
        seekBar = findViewById(R.id.seekbar_id)
        btnWeightPlus = findViewById(R.id.btn_weight_plus_id)
        btnWeightMinus = findViewById(R.id.btn_weight_minus_id)
        btnAgePlus = findViewById(R.id.btn_age_plus_id)
        btnAgeMinus = findViewById(R.id.btn_age_minus_id)
        btnCalculate = findViewById(R.id.btn_calculate_id)

        btnMale.setOnClickListener {
            btnMale.setBackgroundColor(Color.parseColor("#101650"))
            btnFemale.setBackgroundColor(Color.parseColor("#FF1A237E"))
        }
        btnFemale.setOnClickListener {
            btnFemale.setBackgroundColor(Color.parseColor("#101650"))
            btnMale.setBackgroundColor(Color.parseColor("#FF1A237E"))
        }
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, process: Int, p2: Boolean) {
                height = process
                tvHeight.text = "$process cm"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        btnWeightPlus.setOnClickListener{
            weight++
            tvWeight.text = weight.toString()
        }
        btnWeightMinus.setOnClickListener{
            if (1 < weight) weight--
            tvWeight.text = weight.toString()
        }
        btnAgePlus.setOnClickListener{
            age++
            tvAge.text = age.toString()
        }
        btnAgeMinus.setOnClickListener{
            if (1 < age) age--
            tvAge.text = age.toString()
        }

        btnCalculate.setOnClickListener {
            bmiCalculation(height, weight)
        }
    }

    fun bmiCalculation(height: Int, weight: Int){

        var mHeight = Math.pow((height * 0.01).toDouble(), 2.toDouble())
        var bmi = weight / mHeight

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("bmi_result", String.format("%.2f", bmi))
        startActivity(intent)

//        startActivity(Intent(this, ResultActivity::class.java).putExtra("bmi_result", bmi))

//        Toast.makeText(this, bmi.toString(), Toast.LENGTH_SHORT).show()
    }
}