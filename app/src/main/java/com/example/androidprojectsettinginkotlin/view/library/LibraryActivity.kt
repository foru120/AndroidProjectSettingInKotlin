package com.example.androidprojectsettinginkotlin.view.library

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.data.vo.Library
import com.example.androidprojectsettinginkotlin.databinding.ActivityLibraryBinding
import com.example.androidprojectsettinginkotlin.utils.HorizontalItemDecorator
import com.example.androidprojectsettinginkotlin.utils.VerticalItemDecorator
import com.example.androidprojectsettinginkotlin.utils.XmlDataParser
import com.example.androidprojectsettinginkotlin.view.BaseDaggerAppCompatActivity
import com.example.androidprojectsettinginkotlin.view.CaughtExceptionActivity
import com.example.androidprojectsettinginkotlin.viewmodel.LibraryViewModel
import java.io.InputStream
import javax.inject.Inject

class LibraryActivity : BaseDaggerAppCompatActivity<ActivityLibraryBinding>() {
    override val layout: Int
        get() = R.layout.activity_library

    @Inject
    lateinit var viewModel: LibraryViewModel
    @Inject
    lateinit var xmlDataParser: XmlDataParser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpBinding()
        setUpObserve()
        setUpItemList()
    }

    private fun setUpBinding() {
        with(binding) {
            viewModel = this@LibraryActivity.viewModel
        }
    }

    private fun setUpObserve() {
        viewModel.errorMessage.observe(this, Observer {
            val intent = Intent(this, CaughtExceptionActivity::class.java)
            intent.putExtra("errorMessage", it)
            finishAffinity()
            startActivity(intent)
        })
    }

    private fun setUpItemList() {
        try {
            val inputStream = getAssetFile(getString(R.string.library_file_name))
            val libraryList = xmlDataParser.getLibraryXml(inputStream)
            setUpRecyclerView(libraryList)
        } catch (e: java.lang.Exception) {
            viewModel.setErrorMessage(e.message)
        }
    }

    private fun getAssetFile(filePath: String): InputStream {
        val am = resources.assets

        am.open(filePath).use { inputStream ->
            return inputStream
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpRecyclerView(libraryList: ArrayList<Library>) {
        binding.recyclerView.addItemDecoration(VerticalItemDecorator(20))
        binding.recyclerView.addItemDecoration(HorizontalItemDecorator(10))

        val libraryAdapter = LibraryAdapter(this, libraryList)
        binding.recyclerView.adapter = libraryAdapter
        libraryAdapter.notifyDataSetChanged()
    }
}