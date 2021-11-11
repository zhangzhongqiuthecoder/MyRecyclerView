package com.zzq.my_recyclerview

import android.os.Bundle
import com.zzq.my_recyclerview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView(){
        btnShowList.setOnClickListener {
            startActivity(
                SimpleTextListActivity.createIntent(this)
            )
        }
    }

}