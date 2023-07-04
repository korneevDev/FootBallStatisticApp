package github.mik0war.betmatchapp.statistic.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import github.mik0war.betmatchapp.R

class StatisticTabView : LinearLayout {
    private var attackButton: Button
    private var defenceButton: Button
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        (context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.tab_buttons_layout, this, true)

        attackButton = findViewById(R.id.attack_button)
        defenceButton = findViewById(R.id.defence_button)

    }

    fun setUp(attackListener: ()->Unit, defenceListener: ()->Unit){
        attackButton.setOnClickListener{
            attackListener.invoke()
            attackButton.setBackgroundColor(context.getColor(R.color.main_color))
            defenceButton.setBackgroundColor(context.getColor(R.color.blue))
        }

        defenceButton.setOnClickListener{
            defenceListener.invoke()
            attackButton.setBackgroundColor(context.getColor(R.color.blue))
            defenceButton.setBackgroundColor(context.getColor(R.color.main_color))
        }

        defenceButton.performClick()
    }


}