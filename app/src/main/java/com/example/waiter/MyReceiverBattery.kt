package com.example.waiter

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.widget.Toast

class MyReceiverBattery : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, Resources.getSystem().getString(R.string.low), Toast.LENGTH_SHORT)
            .show()
    }
}