package ali.ghanbariyan.goldproject.adapter

import ali.ghanbariyan.goldproject.databinding.RecyclermainitemBinding
import ali.ghanbariyan.goldproject.remote.model.goldModel.ContentModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerMainAdapter(
    private val allData: ArrayList<ContentModel>
) : RecyclerView.Adapter<RecyclerMainAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        val view = MainViewHolder(
            RecyclermainitemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        return view
    }

    override fun onBindViewHolder(
        holder: MainViewHolder,
        position: Int
    ) {
        holder.setData(allData[position])
    }

    override fun getItemCount(): Int {
        return allData.size
    }

     class MainViewHolder(private val binding: RecyclermainitemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(data: ContentModel) {
            binding.labelNameList.text = data.label
            val price = data.price / 10

            binding.priceTextList.text = String.format(
                java.util.Locale.US,
                "%,d",
                price
            )

        }

    }

}