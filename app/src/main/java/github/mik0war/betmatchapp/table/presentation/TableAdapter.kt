package github.mik0war.betmatchapp.table.presentation

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
import github.mik0war.betmatchapp.table.entityModel.TableDataUIModel

class TableAdapter(
    private val tableDataList: GetList<TableDataUIModel>,
    private val colorGetter: ColorGetter
) : RecyclerView.Adapter<TableViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun update(){
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder =
        TableViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.table_list_item, parent, false)
        )

    override fun getItemCount(): Int = tableDataList.getList().size

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        holder.bind(tableDataList.getList()[position], colorGetter.getColor(position))
    }

}

class TableViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(uiModel: TableDataUIModel, color: Int) {
        val layout = itemView.findViewById<LinearLayout>(R.id.root_layout)
        layout.setBackgroundColor(color)

        val numberView = itemView.findViewById<TextView>(R.id.numberView)
        val teamView = itemView.findViewById<TextView>(R.id.teamView)
        val gamesView = itemView.findViewById<TextView>(R.id.gamesCountView)
        val wonView = itemView.findViewById<TextView>(R.id.wonGamesView)
        val drawView = itemView.findViewById<TextView>(R.id.drawGamesView)
        val loseView = itemView.findViewById<TextView>(R.id.loseGamesView)
        val ballsView = itemView.findViewById<TextView>(R.id.ballsView)
        val scoreView = itemView.findViewById<TextView>(R.id.scoreView)

        uiModel.show(numberView, teamView, gamesView, wonView, drawView, loseView, ballsView, scoreView)
    }
}