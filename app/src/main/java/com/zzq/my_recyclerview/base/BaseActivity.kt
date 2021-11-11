package com.zzq.my_recyclerview.base

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "Trace Tracker"
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.d(TAG, "$javaClass onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$javaClass onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$javaClass onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$javaClass onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$javaClass onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$javaClass onDestroy")
    }
}