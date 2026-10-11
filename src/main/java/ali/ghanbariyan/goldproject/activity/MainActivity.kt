package ali.ghanbariyan.goldproject.activity

import ali.ghanbariyan.goldproject.adapter.RecyclerMainAdapter
import ali.ghanbariyan.goldproject.databinding.ActivityMainBinding
import ali.ghanbariyan.goldproject.remote.api.goldApi.GoldApiRepository
import ali.ghanbariyan.goldproject.remote.api.goldApi.GoldRequest
import ali.ghanbariyan.goldproject.remote.api.timeApi.TimeApiRepository
import ali.ghanbariyan.goldproject.remote.api.timeApi.TimeRequest
import ali.ghanbariyan.goldproject.remote.model.dateModel.DateModel
import ali.ghanbariyan.goldproject.remote.model.goldModel.ContentModel
import ali.ghanbariyan.goldproject.remote.model.goldModel.GoldModel
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val goldPrice = ArrayList<ContentModel>()
    private val currencyPrice = ArrayList<ContentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        TimeApiRepository.instance.getTime(object : TimeRequest {
            override fun onSuccess(data: DateModel) {
                val date = data.date
                val text = "${date.l_value_date} ${date.j_value_date} ${date.F_value_date} ${date.Y_value_date}"
                binding.persianDate.text = text
            }

            override fun onNotSuccess(message: String) {
                Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
            }

            override fun onError(error: String) {
                Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
            }
        })

        getInformationForGolds()

        binding.recyclerviewListGold.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        binding.goldPriceText.setOnClickListener {
            binding.goldPriceText.setTextColor("#E7C376".toColorInt())
            binding.priceArzText.setTextColor("#787879".toColorInt())
            setData(goldPrice)
        }
        binding.priceArzText.setOnClickListener {
            binding.goldPriceText.setTextColor("#787879".toColorInt())
            binding.priceArzText.setTextColor("#E7C376".toColorInt())
            setData(currencyPrice)
        }

    }

    private fun getInformationForGolds() {
        GoldApiRepository.instance.getGold(
            object : GoldRequest {
                override fun onSuccess(data: GoldModel) {
                    goldPrice.addAll(data.data.golds)
                    currencyPrice.addAll(data.data.currencies)
                    setData(goldPrice)
                    binding.progressBarPrice.visibility = View.GONE
                }

                override fun onNotSuccess(message: String) {
                    Toast.makeText(
                        this@MainActivity,
                        "اپلیکیشن در دریافت اطلاعات از سرور با مشکل مواجه شده است",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.i("show message",message)
                }

                override fun onError(error: String) {
                    Toast.makeText(
                        this@MainActivity,
                        "اپلیکیشن دچار خطا شده است",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.i("show error",error)
                }

            }
        )

    }

    private fun setData(data: ArrayList<ContentModel>) {

        binding.recyclerviewListGold.adapter = RecyclerMainAdapter(data)
    }

}