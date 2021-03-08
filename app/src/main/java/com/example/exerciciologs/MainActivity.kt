package com.example.exerciciologs

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setLogListener()
        setException()

        val currentThread = Thread.currentThread()
        currentThread.setUncaughtExceptionHandler { _, thowable ->
        val x = thowable.message
        val cause = thowable.cause
        }
    }

    private fun setLogListener(){
        InfoBtn?.setOnClickListener{ Log.i("Click", "Opa! cliquei no info")}
        WarningBtn?.setOnClickListener{ Log.w("Click", "Opa! cliquei no warning")}
        VerboseBtn?.setOnClickListener{ Log.v("Click", "Opa! cliquei no verbose")}
        ErrorBtn?.setOnClickListener{ Log.e("Click", "Opa! cliquei no error")}
        DebugBtn?.setOnClickListener{ Log.d("Click", "Opa! cliquei no debug")}
    }

    private fun setException(){
        InfoBtn?.setOnClickListener{
            var message:String= ""

            try{
                val list = listOf(2 ,1 , 7)
                val a = list[5]
                message = "Sobrevivi ao try"
            }catch (e: IndexOutOfBoundsException){
                message = "Entrei no catch certo =)"
            }catch (i: NullPointerException){
                message = "Entrei no catch errado =s"
            }finally {
                inputTxt.setText(message)
            }
       }

    }
}