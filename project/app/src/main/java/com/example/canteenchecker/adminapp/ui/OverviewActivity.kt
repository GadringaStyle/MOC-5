package com.example.canteenchecker.adminapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.canteenchecker.adminapp.R
import com.example.canteenchecker.adminapp.databinding.ActivityOverviewBinding
import com.example.canteenchecker.adminapp.misc.ViewPagerAdapter
import com.example.canteenchecker.adminapp.ui.fragments.CanteenDetailsFragment
import com.example.canteenchecker.adminapp.ui.fragments.ReviewsFragment
import com.google.android.material.tabs.TabLayoutMediator

class OverviewActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: ViewPagerAdapter;
    private lateinit var binding: ActivityOverviewBinding;
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityOverviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.tbaOverview)
        setUpViewPager()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overview, menu)
        return true
    }

    private fun setUpViewPager(){
        var listOfFragments = listOf(CanteenDetailsFragment(), ReviewsFragment());
        viewPagerAdapter = ViewPagerAdapter(
            listOfFragments,
            supportFragmentManager,
            lifecycle
        )
        binding.vpaOverview.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tblOverview, binding.vpaOverview) {tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Canteen Details"
                    tab.setIcon(R.drawable.img_settings)
                }
                1 -> {
                    tab.text = "Reviews"
                    tab.setIcon(R.drawable.img_half_star)
                }
            }
        }.attach()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.btnLogout -> {
                performLogout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun performLogout() {
        // Example: clear session, go to login activity
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    companion object{
        fun intent(context: Context): Intent = Intent(context, OverviewActivity::class.java)
    }
}