package info.jakariya.bmicalculator

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    lateinit var tvHeading :TextView
    lateinit var tvResult :TextView
    lateinit var tvTips :TextView
    lateinit var btnBack :Button
    lateinit var llResult :LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val bmiResult = intent.getStringExtra("bmi_result")?.toDouble()

        tvHeading = findViewById(R.id.tv_heading_id)
        tvResult = findViewById(R.id.tv_result_id)
        tvTips = findViewById(R.id.tv_tips_id)
        btnBack = findViewById(R.id.btn_back_id)
        llResult = findViewById(R.id.ll_result_id)

        tvResult.text = bmiResult.toString()

        if (bmiResult != null) {

            if (bmiResult <= 18.4){

                tvHeading.text = "You are underweight"
                tvResult.text = "BMI is $bmiResult"
                tvTips.text = "Eat more food and gain weight"
            }
            else if (bmiResult >= 18.5 && bmiResult <= 24.9){

                tvHeading.text = "You are Normal"
                tvResult.text = "BMI is $bmiResult"
                tvTips.text = "Nothing to do, enjoy your life"
                llResult.setBackgroundColor(Color.parseColor("#00ff00"))
            }
            else if (bmiResult >= 25.0){

                tvHeading.text = "You are overweight"
                tvResult.text = "BMI is $bmiResult"
                tvTips.text = "Choose a diet plan and do exercise"
            }

        }

        btnBack.setOnClickListener {
            finish()
        }


    }
}