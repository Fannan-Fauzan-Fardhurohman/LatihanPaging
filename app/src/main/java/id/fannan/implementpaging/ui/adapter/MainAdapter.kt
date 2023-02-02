package id.fannan.implementpaging.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import id.fannan.implementpaging.databinding.ItemViewBinding
import id.fannan.implementpaging.model.RickyMorty
import id.fannan.implementpaging.ui.adapter.MainAdapter.ImageViewHolder

class MainAdapter : PagingDataAdapter<RickyMorty,
        ImageViewHolder>(diffCallback) {


    inner class ImageViewHolder(
        val binding: ItemViewBinding
    ) :
        ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<RickyMorty>() {
            override fun areItemsTheSame(oldItem: RickyMorty, newItem: RickyMorty): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RickyMorty, newItem: RickyMorty): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currChar = getItem(position)

        holder.binding.apply {

            holder.itemView.apply {
                tvDescription.text = "${currChar?.name}"

                val imageLink = currChar?.image
                imageView.load(imageLink) {
                    crossfade(true)
                    crossfade(1000)
                }
            }
        }

    }


}