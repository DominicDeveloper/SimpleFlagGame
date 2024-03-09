package com.asadbek.myflaygame

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.asadbek.myflaygame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var tartib = 0
    var javob = "empty"
    var trueAnswers = 0
    var falseAnswers = 0
    lateinit var binding: ActivityMainBinding
    val list = arrayOf(R.drawable.country_ar,R.drawable.country_br,R.drawable.country_de,R.drawable.country_fr,
        R.drawable.country_in,R.drawable.country_kr,R.drawable.country_pk,R.drawable.country_ru,R.drawable.country_us,R.drawable.country_uz)
    var countryName = ArrayList<String>()
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addNames()
        binding.imageView.setImageDrawable(ContextCompat.getDrawable(this,list[tartib]))
        javob = countryName[tartib]
        binding.btnCheck.setOnClickListener {
            if (tartib != list.size-1){
                if (binding.edtCountryName.text.toString().uppercase() == javob){
                    trueAnswers++
                    binding.textTrueAnswers.text = "To`g`ri javoblar: $trueAnswers"
                    binding.edtCountryName.text!!.clear()
                    tartib++
                    javob = countryName[tartib]
                    binding.imageView.setImageDrawable(ContextCompat.getDrawable(this,list[tartib]))
                }else if (binding.edtCountryName.text!!.isEmpty()){
                    Toast.makeText(this, "Iltimos ma`lumot kiriting!", Toast.LENGTH_SHORT).show()
                        val vibe:Vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                        vibe.vibrate(500)
                }
                else{
                    falseAnswers++
                    binding.textFalseAnswers.text = "Noto`g`ri javoblar: $falseAnswers"
                    binding.edtCountryName.text!!.clear()
                    binding.edtCountryName.error = "Xato"
                }
            }else{
                binding.btnCheck.visibility = View.INVISIBLE
                binding.cardView.visibility = View.INVISIBLE
                binding.edtCountryName.visibility = View.INVISIBLE
            }
        }
    }
    fun addNames(){
        countryName.add("ARGENTINA")
        countryName.add("BRAZILYA")
        countryName.add("GERMANIYA")
        countryName.add("FRANSIYA")
        countryName.add("HINDISTON")
        countryName.add("KOREYA")
        countryName.add("POKISTON")
        countryName.add("ROSSIYA")
        countryName.add("AMERIKA")
        countryName.add("UZBEKSITON")
    }
}