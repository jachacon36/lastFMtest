package com.example.lastfmtest.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lastfmtest.R
import com.example.lastfmtest.databinding.ActivityMainBinding
import com.example.lastfmtest.injection.ViewModelProviderFactory
import com.example.lastfmtest.ui.ApiViewModel
import com.google.android.material.snackbar.Snackbar

class ArtistsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ApiViewModel
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDataBinding()
        createRecyclerView()
        createRecyclerViewListeners()
        createViewModel()
        createObservers()
        callArtists()

    }

    private fun createDataBinding(){
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
    }

    private fun createRecyclerView(){
        binding.artistList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
    private fun createRecyclerViewListeners(){
        binding.artistList.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState==RecyclerView.SCROLL_STATE_IDLE) {
                    viewModel.loadArtists(viewModel.oneCall)
                    Toast.makeText(this@ArtistsActivity, getString(R.string.page,viewModel.getPageCurrent()),Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun createViewModel(){
        viewModel = ViewModelProvider(this, ViewModelProviderFactory(this)).get(ApiViewModel::class.java)
    }

    private fun createObservers(){
        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        viewModel.pageCurrent.observe(this, Observer {
                pageCurrent -> updatePage(pageCurrent)
        })
        binding.viewModel = viewModel
    }

    private fun callArtists(){
        viewModel.loadArtists(viewModel.oneCall)
    }

    private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }


    private fun updatePage(pageCurrent: Int) {
        viewModel.page = (pageCurrent+1).toString()
    }
}
