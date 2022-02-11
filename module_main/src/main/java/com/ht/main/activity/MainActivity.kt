package com.ht.main.activity

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.doit.base.activity.BaseActivity
import com.ht.main.R
import com.ht.main.databinding.ActivityMainBinding

/**
 * Jetpack Navigation
 * BottomNavigationView 底部导航
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var navController: NavController

    override fun init() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        viewDataBinding!!.bnvMenu.setupWithNavController(navController)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onRetryBtnClick() {
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }
}