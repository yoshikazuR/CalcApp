package jp.techacademy.yoshikazu.takahashi.calcapp

import android.content.Intent
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add.setOnClickListener(this)
        sub.setOnClickListener(this)
        mul.setOnClickListener(this)
        div.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent(this, SecondActivity::class.java)
        var answer:Double = 0.0
        var aStr:String = editText1.text.toString()
        var bStr:String = editText2.text.toString()
        if (aStr.equals("") || bStr.equals("")) {
            Snackbar.make(v, "値が入力されていません。", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action") {
                    Log.d("UI_PARTS", "Snackをタップした")
                }.show()
        }else {
            var a:Double = aStr.toDouble()
            var b:Double = bStr.toDouble()
            when(v.id) {
                R.id.add -> {
                    answer = a+b
                    intent.putExtra("VALUE", answer)
                    startActivity(intent)
                }
                R.id.sub -> {
                    answer = a-b
                    intent.putExtra("VALUE", answer)
                    startActivity(intent)
                }
                R.id.mul -> {
                    answer = a*b
                    intent.putExtra("VALUE", answer)
                    startActivity(intent)
                }
                R.id.div -> {
                    Log.d("kotlintest", b.toString())
                    if (b.equals(0.0)) {
                        Snackbar.make(v, "分母に0を入力することはできません。", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Action") {
                                Log.d("UI_PARTS", "Snackをタップした")
                            }.show()
                    }else {
                        answer = a/b
                        intent.putExtra("VALUE", answer)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}