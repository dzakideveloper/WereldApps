package com.example.wereldapps.ui

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.example.wereldapps.R
import com.example.wereldapps.databinding.ActivityMainBinding
import com.example.wereldapps.ui.travel.TravelFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationManager: NotificationManager
    lateinit var builder: Notification.Builder
    private val channelId = "12345"
    private val description = "Test Notification"

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var _appBarConfiguration: AppBarConfiguration? = null
    private val appBarConfiguration get() = _appBarConfiguration as AppBarConfiguration

//    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        val navController = findNavController(R.id.nav_host)
        _appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.travel_fragment, R.id.negara_fragment, R.id.indo_fragment
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel(channelId, description, NotificationManager .IMPORTANCE_HIGH)
            notificationChannel.lightColor = Color.BLUE
            notificationManager.createNotificationChannel(notificationChannel)
            builder = Notification.Builder(this, channelId).setContentTitle("Wereld Notification").setContentText("Search your destination").setSmallIcon(R.drawable.logo_app).setLargeIcon(
                BitmapFactory.decodeResource(this.resources, R.drawable
                    .ic_launcher_background))
        }
        notificationManager.notify(12345, builder.build())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_action, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.travel_fragment -> Toast.makeText(this, "ALFA", Toast.LENGTH_LONG).show()
            R.id.negara_fragment -> Toast.makeText(this, "BETA", Toast.LENGTH_LONG).show()
            R.id.indo_fragment -> Toast.makeText(this, "CHARLIE", Toast.LENGTH_LONG).show()
        }

        val navController = findNavController(R.id.nav_host)
        return NavigationUI.onNavDestinationSelected(item, navController) ||
                super.onOptionsItemSelected(item)
    }
}