package com.smartdev.samplecoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    //update interval for widget
    val UPDATE_INTERVAL = 1000L

    //Handler to repeat update
    val updateWidgetHandler = Handler()

    //runnable to update widget
    var updateWidgetRunnable: Runnable = Runnable {
        run {
            //Update UI

            // Re-run it after the update interval
            updateWidgetHandler.postDelayed(updateWidgetRunnable, UPDATE_INTERVAL)
        }

    }
     var def : Job?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         def=GlobalScope.launch(Dispatchers.IO) {

//            var totalTime = measureTimeMillis {
                 async { getFirstResultFromInternet()
                     println("done 1")
                 }
               async { getSecondResultFromInternet()
                   println("done 2")
               }
              async { getSecondResultFromInternet()
                  println("done 3")

              }
                 async { getSecondResultFromInternet()
                     println("done 4")
                 }
               async { getSecondResultFromInternet()
                   println("done 5")
               }
               async { getSecondResultFromInternet()
               }
                 async { getSecondResultFromInternet() }
//                println("The result is ${one.await() + " " + two.await()}")
//            }


            println("final result") // printing total execution


        }



    }

    suspend fun getFirstResultFromInternet(): String {
        println("Getting First Result From Internet")
        delay(5000) // add some delay
        return "Hello"
    }

    suspend fun getSecondResultFromInternet(): String {
        println("Getting Second Result From Internet")
        delay(5000) // add some delay
        return "World"
    }
}