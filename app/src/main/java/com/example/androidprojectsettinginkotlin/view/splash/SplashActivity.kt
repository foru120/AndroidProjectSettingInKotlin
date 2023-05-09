package com.example.androidprojectsettinginkotlin.view.splash

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.androidprojectsettinginkotlin.R
import com.example.androidprojectsettinginkotlin.databinding.ActivitySplashBinding
import com.example.androidprojectsettinginkotlin.view.main.MainActivity
import com.example.androidprojectsettinginkotlin.viewmodel.SplashViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class SplashActivity : FragmentActivity() {
    private lateinit var binding: ActivitySplashBinding

    @Inject
    lateinit var viewModel: SplashViewModel

    @Inject
    lateinit var firstSplashFragment: FirstSplashFragment
    @Inject
    lateinit var secondSplashFragment: SecondSplashFragment
    @Inject
    lateinit var thirdSplashFragment: ThirdSplashFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this@SplashActivity)

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        setUpBinding()
        setUpObserve()
    }

    fun setUpBinding() {
        with(binding) {
            viewModel = this@SplashActivity.viewModel

            pager.adapter = PagerAdapter(this@SplashActivity)
            pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

            indicator.setViewPager(pager)
            indicator.createIndicators(3, 0)

            pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    indicator.animatePageSelected(position)
                }
            })
        }
    }

    fun setUpObserve() {
        binding.viewModel!!.isNext.observe(this, Observer {
            if (it) {
                val intent = Intent(this, MainActivity::class.java)
                finishAffinity()
                startActivity(intent)
            }
        })
    }

    inner class PagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

        private val fragmentList = listOf<Fragment>(firstSplashFragment, secondSplashFragment, thirdSplashFragment)

        override fun getItemCount(): Int = fragmentList.size

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }
    }
}