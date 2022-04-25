package id.ac.ukdw.pertemuan8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = findViewById<ViewPager2>(R.id.pager)
        val listFragment: ArrayList<Fragment> = arrayListOf(FragmentMessage(), FragmentHome(), FragmentSettings())
        val pagerAdapter = PagerAdapter(this, listFragment)
        viewPager.adapter = pagerAdapter
        viewPager.setCurrentItem(1)
        setSupportActionBar(findViewById(R.id.toolbar_default))
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    class PagerAdapter(val activity: AppCompatActivity, val listFragment: ArrayList<Fragment>): FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = listFragment.size
        override fun createFragment(position: Int): Fragment = listFragment.get(position)
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_default, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.settings -> {
            val viewPager = findViewById<ViewPager2>(R.id.pager)
            viewPager.setCurrentItem(2)
            true
        }
        R.id.message -> {
            val viewPager = findViewById<ViewPager2>(R.id.pager)
            viewPager.setCurrentItem(0)
            true
        }
        R.id.home -> {
            val viewPager = findViewById<ViewPager2>(R.id.pager)
            viewPager.setCurrentItem(1)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}