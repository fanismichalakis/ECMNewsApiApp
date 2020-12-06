package fr.centrale.newsapiapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataSet: ArrayList<ArticlePreview>)
    : RecyclerView.Adapter<CustomAdapter.ViewHolder>()  {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val txtTitle: TextView
        val txtAuthor: TextView
        val txtDate: TextView
        val imagePreview: ImageView

        init {
            view.setOnClickListener{ Log.d("VIEW_HOLDER", "Element $adapterPosition clicked")}
            txtTitle =  view.findViewById(R.id.txtTitle)
            txtAuthor = view.findViewById(R.id.txtAuthor)
            txtDate = view.findViewById(R.id.txtDate)
            imagePreview = view.findViewById(R.id.imagePreview)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.article_preview, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d("ADAPTER", "Element $position set.")
        viewHolder.txtTitle.text = dataSet[position].title
        viewHolder.txtAuthor.text = dataSet[position].author
        viewHolder.txtDate.text = dataSet[position].date
        // viewHolder.imagePreview = dataSet[position].image
    }

    override fun getItemCount() = dataSet.size
}