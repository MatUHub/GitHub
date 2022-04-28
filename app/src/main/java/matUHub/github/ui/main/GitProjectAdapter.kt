package matUHub.github.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import matUHub.github.databinding.GitItemBinding
import matUHub.github.domain.GitProjectEntity
import matUHub.github.ui.main.GitProjectAdapter.*

class GitProjectAdapter : RecyclerView.Adapter<GitViewHolder>() {

    var onItemClick: ((GitProjectEntity) -> Unit)? = null

    private var data: List<GitProjectEntity> = mutableListOf()

    fun setData(repos: List<GitProjectEntity>) {
        data = repos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitViewHolder {
        return GitViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: GitViewHolder, position: Int) {
        holder.bind(getItem(position))

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(getItem(position))
        }
    }

    override fun getItemCount(): Int = data.size


    private fun getItem(pos: Int): GitProjectEntity = data[pos]


    class GitViewHolder(private val binding: GitItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun create(parent: ViewGroup): GitViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                return GitViewHolder(GitItemBinding.inflate(inflater))
            }
        }

        fun bind(item: GitProjectEntity) {
            binding.itemImageView.setImageResource(item.image)
            binding.itemIdTextView.text = item.id.toString()
            binding.itemNameTextView.text = item.name
        }
    }
}
