package com.example.myworld

import android.content.Intent
import android.os.*
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    val mMeasureWith1 = 100
    val mMeasureWith2 = 100
    val mMeasureWith3 = 100
    val mMeasureWith4 = 100
    val mMeasureWith5 = 100
    val mMeasureWith6 = 100
    val mMeasureWith7 = 100
    val mMeasureWith8 = 100
    val mMeasureWith9 = 100
    val mMeasureWith10 = 100

    private val mHandler: Handler = Handler();


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        LayoutInflater

        Log.d("ansen", "onCreate---->$this")
//        val stack = Stack<Int>()
//        stack.peek()
//
//        mHandler.post {
//
//        }
//        mHandler.sendMessageDelayed()

        val message2 = Message()
        message2.what = 1
        message2.data = Bundle().apply {

        }
        message2.isAsynchronous = true
//        message2.sendToTarget()
        mHandler.sendMessage(message2)

        val message = mHandler.obtainMessage();
        message.sendToTarget()

//        val viewmode: ViewModel = ViewModelProvider()


        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.textview).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
//        val currentKeyboard =
//            Settings.Secure.getString(contentResolver, Settings.Secure.DEFAULT_INPUT_METHOD)
//        println("currentKeyboard---->$currentKeyboard");

        TestRxJava.love()
//        TestRxJava.testMap()

//        val textView = findViewById<TextView>(R.id.textview)
//        textView.text =
//            "Hello WorldHello WorldHello WorldHello WorldHello WorldHello World12345678910"

//        TestGeneral.main()
//        val handler= Handler();
//        handler.removeCallbacksAndMessages(null)


//        val emailAddress = "АаиЯК@yandex.ru"
//        val emailAddress2 = "ззз@yandex.ru"
        val mailList = listOf<String>(
            "АаиЯК@yandex.ru",
            "ззз@yandex.ru",
            "kdkelldldldşrşrodııdıd@outlook.com",
            "saroyaanis@gmail.com",
            "احبك@gmail.com",
            "жан@mail.ru",
            "топатмчоотвсл@mail.ru",
            "ا@gmail.com",
            "łôłëŝf@gmail.com",
            "сс@gmail.com",
            "тиапттмр@mail.ru",
            "ззз@yandex.ru",
            "ሰ@gmail.com",
            "\uD835\uDC82\uD835\uDC8A\uD835\uDC8F\uD835\uDC82\uD835\uDC8F\uD835\uDC82\uD835\uDC8F\uD835\uDC82271@gmail.com",
            "ангелина@mail.ru"
        )

        val mailList2 = listOf<String>(
            "АаиЯК@АаиЯК.ru", "ззз@ззз.ззз",
            "kdkelldldldşrşrodııdıd@ııdıd.ııdı"
        )

        val mailList3 = listOf<String>(
            "a_b_ccd_123@123.ru",
            "ab123s_qqq_123ccd_123@xyz.ru",
            "xyzcc_78901011223@1c2c3c.ru23",
            "xyzcc_78901011223@1c2c3c.ru2333",
            "a_b_ccd_123@123.163",
            "@@@@@163.ccccc",
            "123132123",
            "123132123@.com",
            "123132123@__.com",
            "1231...32123@__.com",
            "1231。。。32123@__.com",
            "_______@173.comm",
            "_______@@173.comm",
            "_    ______@@173.comm",
            "___%____@173.comm",
            "___*____@173.comm",
            "___()____@173.comm",
            "___123sgh____@173.comm",
            "___123sgh____@ssssssssssss.ssss",
            "hahah#$@$.163",
            "a_b#_ccd_123@123.163"
        )


//        val p: Pattern = Pattern.compile("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
//        mailList3.forEach {
//            val matcher = p.matcher(it)
//            Log.d("ansen", "$it----->${matcher.find()}")
//        }

    }

    fun test() {
        val measureWidth = mMeasureWith1 + mMeasureWith2 + mMeasureWith3
        +mMeasureWith4 + mMeasureWith5 + mMeasureWith6
    }

    companion object {
        const val mWidth = 100;
    }

    override fun onStart() {
        super.onStart()
        Log.d("ansen", "onStart---->$this")
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
        Log.d("ansen", "onResume---->$this")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ansen", "onPause---->$this")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ansen", "onStop---->$this")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ansen", "onDestroy---->$this")
    }

}

