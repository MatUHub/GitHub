package matUHub.github.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import matUHub.github.databinding.GitItemBinding
import matUHub.github.domain.GitProjectEntity
import matUHub.github.ui.GitProjectAdapter.*

class GitProjectAdapter : RecyclerView.Adapter<GitViewHolder>() {

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
binding.itemId.text = item.id.toString()
            binding.itemName.text = item.name
        }
    }
}
