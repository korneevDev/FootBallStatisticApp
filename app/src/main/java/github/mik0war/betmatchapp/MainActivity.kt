package github.mik0war.betmatchapp

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeBackGround(){
        val randomId = Random.nextInt(backgrounds_list.size)
        findViewById<LinearLayout>(R.id.root_layout)
            .background = AppCompatResources.getDrawable(this, backgrounds_list[randomId])
    }

    companion object{
        val backgrounds_list: List<Int> = listOf(
            R.drawable.background_1,
            R.drawable.background_2,
            R.drawable.background_3
        )
    }
}

