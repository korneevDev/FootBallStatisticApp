package github.mik0war.betmatchapp.statistic.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import github.mik0war.betmatchapp.R
import github.mik0war.betmatchapp.core.ColorGetter
import github.mik0war.betmatchapp.core.GetList
import github.mik0war.betmatchapp.statistic.entityModel.StatisticUIModel

class StatisticAdapter(
    private val statisticList: GetList<StatisticUIModel>,
    private val colorGetter: ColorGetter
) : RecyclerView.Adapter<StatisticViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun update() {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticViewHolder =
        if (viewType == 0)
            StatisticViewHolder.Defence(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.statistic_defence_item, parent, false)
            )
        else StatisticViewHolder.Attack(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.statistic_attack_item, parent, false)
        )

    override fun getItemCount(): Int = statisticList.getList().size

    override fun onBindViewHolder(holder: StatisticViewHolder, position: Int) {
        holder.bind(statisticList.getList()[position], colorGetter.getColor(position))
    }

    override fun getItemViewType(position: Int): Int {
        return when (statisticList.getList()[position]) {
            is StatisticUIModel.Defence -> 0
            is StatisticUIModel.Attack -> 1
        }
    }
}

sealed class StatisticViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    open fun bind(uiModel: StatisticUIModel, backGroundColor: Int) {
        val layout = itemView.findViewById<LinearLayout>(R.id.root_layout)
        layout.setBackgroundColor(backGroundColor)
    }

    class Defence(
        view: View
    ) : StatisticViewHolder(view) {

        override fun bind(uiModel: StatisticUIModel, backGroundColor: Int) {
            super.bind(uiModel, backGroundColor)
            val teamView = itemView.findViewById<TextView>(R.id.teamView)
            val tournamentView = itemView.findViewById<TextView>(R.id.tournamentView)
            val kickView = itemView.findViewById<TextView>(R.id.kickView)
            val tackleView = itemView.findViewById<TextView>(R.id.ratingView)

            (uiModel as StatisticUIModel.Defence).show(
                teamView,
                tournamentView,
                kickView,
                tackleView
            )
        }
    }

    class Attack(
        view: View
    ) : StatisticViewHolder(view) {
        override fun bind(uiModel: StatisticUIModel, backGroundColor: Int) {
            super.bind(uiModel, backGroundColor)
            val teamView = itemView.findViewById<TextView>(R.id.teamView)
            val tournamentView = itemView.findViewById<TextView>(R.id.tournamentView)
            val kickView = itemView.findViewById<TextView>(R.id.kickView)
            val tackleView = itemView.findViewById<TextView>(R.id.ratingView)

            (uiModel as StatisticUIModel.Attack).show(
                teamView,
                tournamentView,
                kickView,
                tackleView
            )
        }
    }
}
