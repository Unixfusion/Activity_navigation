package com.example.ctivitynavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ctivitynavigation.databinding.ActivityAboutBinding

class AboutActivity : BaseActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.twAppNameText.text = this.packageManager.getPackageInfo(packageName, 0).packageName.toString()
        binding.twAppNameText.text = applicationInfo.loadLabel(packageManager)
        binding.twVersionCodeText.text = this.packageManager.getPackageInfo(packageName, 0).versionName
        binding.twVersionNameText.text = this.packageManager.getPackageInfo(packageName, 0).versionCode.toString()
        binding.btnBack.setOnClickListener { onBtnBackPressed() }

    }
    fun onBtnBackPressed() {
        finish()
    }
}