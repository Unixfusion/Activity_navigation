package com.example.ctivitynavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.ctivitynavigation.databinding.ActivityMainBinding
import com.example.ctivitynavigation.model.Options

class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var options: Options

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenBox.setOnClickListener { onOpenBoxPressed() }
        binding.btnOptions.setOnClickListener { onOptionsPressed() }
        binding.btnAbout.setOnClickListener { onAboutPressed() }
        binding.btnExit.setOnClickListener { onExitPressed() }

        options = savedInstanceState?.getParcelable(KEY_OPTIONS) ?: Options.DEFAULT
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_OPTIONS, options)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == OPTIONS_REQUEST_CODE && resultCode == RESULT_OK) {
            options = data?.getParcelableExtra<Options>(OptionsActivity.EXTRA_OPTIONS) ?:
            throw IllegalArgumentException(" Something went wrong")
        }
    }

    private fun onOpenBoxPressed() {
        TODO("Not yet implemented")
    }

    private fun onOptionsPressed() {
        val intent = Intent(this, OptionsActivity::class.java)
        intent.putExtra(OptionsActivity.EXTRA_OPTIONS, options)
        startActivityForResult(intent, OPTIONS_REQUEST_CODE)
    }

    private fun onAboutPressed() {
        var intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    private fun onExitPressed() {
        finish()
    }

    companion object {
       @JvmStatic private val KEY_OPTIONS = "OPTIONS"
       @JvmStatic private val OPTIONS_REQUEST_CODE = 1
    }
}