package shift.cft.threadexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


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

//    private suspend fun fibbonaciSaspend(count: Int): List<Int> =
//        withContext(Dispatchers.Default) {
//            fibbonaci(count)
//        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {

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