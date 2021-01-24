package com.magdaproject.testthreading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launch {
            val text = createText()
            textz.text = "makira"
            textv.text = text.await()
        }



//        Thread.sleep(3000)
//        textz.text = "marin"

    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    suspend fun createText() = async  ( Dispatchers.IO) {
        var s: String
        Thread.sleep(10000)
        s = "nomans"

        return@async s

    }
}