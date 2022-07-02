package com.example.ctivitynavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.ctivitynavigation.databinding.ActivityOptionsBinding
import com.example.ctivitynavigation.model.Options

class OptionsActivity : BaseActivity() {
    lateinit var binding: ActivityOptionsBinding
    lateinit var options: Options
    private lateinit var boxCountItems: List<BoxCountItem>
    private lateinit var adapter: ArrayAdapter<BoxCountItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        options = savedInstanceState?.getParcelable<Options>(EXTRA_OPTIONS) ?:
        intent.getParcelableExtra<Options>(EXTRA_OPTIONS) ?:
        throw IllegalArgumentException("Some crap")

        setupSpinner()
        updateUI()

    }

    private fun updateUI() {
        TODO("Not yet implemented")
    }

    private fun setupSpinner() {
        boxCountItems = (1..6).map { BoxCountItem(it, resources.getQuantityString(R.plurals.boxes, it, it)) }
        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, boxCountItems)
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)

        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val count = boxCountItems[position].count
                options = options.copy(boxCount = count)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_OPTIONS, options)
    }

    companion object {
        @JvmStatic val EXTRA_OPTIONS = "EXTRA_OPTIONS"
        @JvmStatic private val KEY_OPTIONS = "KEY_OPTIONS"
    }
    class BoxCountItem(
        val count: Int,
        private val optionTitle: String
    ) {
        override fun toString(): String {
            return optionTitle
        }
    }
}