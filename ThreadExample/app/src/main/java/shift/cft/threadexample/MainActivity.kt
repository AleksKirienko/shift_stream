package shift.cft.threadexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
//import androidx.lifecycle.lifecycleScope
//import kotlinx.coroutines.*
//import kotlinx.coroutines.flow.*

class MainActivity : AppCompatActivity() {

    fun fibbonaci(count: Int): List<Int> {
        var a = 0
        var b = 1

        val result = IntArray(count)

        result[0] = 0

        for (i in 1 until count) {
            result[i] = (a + b)

            val tmp = a + b
            a = b
            b = tmp
        }

        return result.toList()
    }

//    private val fibonacciFlow = flow {
//        var a = 0
//        var b = 1
//
//        emit(1)
//
//        while (true) {
//            emit(a + b)
//
//            val tmp = a + b
//            a = b
//            b = tmp
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {

//            fibonacciFlow.map {
//                it.toString()
//            }

//                .flowOn(Dispatchers.Default)
//                .onEach { result ->
//                    delay(1000)
//                    resultView.text = result
//                }
//                .launchIn(lifecycleScope)

            val fibbonaci: List<Int> = fibbonaci(100_000)

            val currentThread: Thread = Thread.currentThread()

            runOnUiThread {
                resultView.text = """
                Fibbonaci: ${fibbonaci[0]}, ${fibbonaci[1]},${fibbonaci[2]}, ${fibbonaci[3]}
                Current Thread: $currentThread
            """.trimIndent()
            }

        }
    }
}