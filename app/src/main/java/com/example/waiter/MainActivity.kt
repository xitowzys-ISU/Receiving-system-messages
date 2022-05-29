package com.example.waiter

import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.waiter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var receiver: BroadcastReceiver
    private lateinit var receiverBattery: BroadcastReceiver

    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        receiver = MyReceiver()
        receiverBattery = MyReceiverBattery()

        binding.action.setOnClickListener {
            unregisterReceiver(receiver)
            Toast.makeText(this, getString(R.string.go), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(receiver, IntentFilter("android.intent.action.TIME_TICK"))
        registerReceiver(receiverBattery, IntentFilter("android.intent.action.BATTERY_LOW"))
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
        unregisterReceiver(receiverBattery)
    }

    internal fun update() {
        i += 1
        binding.print.text = getString(R.string.waiting_time, i)
    }
}