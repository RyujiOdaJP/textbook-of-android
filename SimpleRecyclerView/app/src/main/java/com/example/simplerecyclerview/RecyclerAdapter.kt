package com.example.simplerecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/*
* RecyclerView.Adapter
* RecyclerView と実際のデータを結びつけ、適切なタイミングで
* ViewHolder オブジェクトの生成 (onCreateViewHolder()) や、
* 表示内容の入れ替え (onBindViewHolder()) を行います（LayoutManager から自動的に呼び出されます）。
* つまり、アプリの開発者は、onCreateViewHolder() で ViewHolder インスタンスを生成し、
* onBindViewHolder() でその表示内容を更新するように実装するだけでよいことになります。
* */
class RecyclerAdapter(
    private val context: Context,
    private val itemClickListener: RecyclerViewHolder.ItemClickListener,
    private val itemList: List<Model>
) : RecyclerView.Adapter<RecyclerViewHolder>() {

    private var mRecyclerView: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView = null
    }

    /*
    * 新しい ViewHolder インスタンスを生成する。
    * XML ファイルを inflate して作成した View オブジェクトを、
    * 独自の ViewHolder インスタンスにセットして返せばよい。
    */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.row, parent, false)

        mView.setOnClickListener { view->
            mRecyclerView?.let {
                itemClickListener.onItemClick(view, it.getChildAdapterPosition(view))
            }
        }

        return RecyclerViewHolder(mView)
    }

    /*
    * ViewHolder の表示内容を更新する。パラメータで渡される ViewHolder が
    * 最初に表示されるときにも呼び出されるし、使いまわされるときにも呼び出される。
    */
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.titleView.text = itemList.get(position).title
        holder.detailView.text = itemList.get(position).id
        holder.detailView.text = itemList.get(position).url
    }

    /*
    * セットされているデータの要素数を返す
    * */
    override fun getItemCount(): Int {
        return itemList.size
    }

}
