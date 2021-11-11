package com.zzq.my_recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import com.zzq.my_recyclerview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_simple_text_list.*

class SimpleTextListActivity : BaseActivity() {
    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, SimpleTextListActivity::class.java)
        }
    }

    private var dataList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_text_list)
        initData()
        initAdapter()
        initView()
    }

    private fun initData() {
        dataList.apply {
            add("1111111111")
            add("2222222222")
            add("3333333333")
            add("4444444444")
        }
    }

    private fun initAdapter() {
        simpleRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@SimpleTextListActivity)
            adapter = MyRecyclerViewAdapter(
                items = dataList,
                onItemBind = { holder, position ->//回调函数的两个形参
                    onItemBind(holder = holder, position = position)
                }
            )
        }
    }

    private fun onItemBind(holder: MyRecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.apply {
            tvLog.apply {
                text = "$position : ${dataList[position]}"
                setOnClickListener {
                    showToast("you clicked tvLog at holder's view, position is $position")
                }
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initView() {
        btnTitle.setOnTouchListener { v, event ->
            dataList.add("action is ${event.action}")
            // setData, 全量刷新
            (simpleRecyclerView.adapter as MyRecyclerViewAdapter).setData(dataList)
            // 滚动到最后一格
            val linearSmoothScroller = LinearSmoothScroller(this)
            linearSmoothScroller.targetPosition = dataList.size - 1
            simpleRecyclerView.layoutManager?.startSmoothScroll(linearSmoothScroller)

            return@setOnTouchListener false
        }

        btnTitle.setOnClickListener {
            showToast("tvTitle is clicked")
        }

        btnClear.setOnClickListener {
            dataList.clear()
            (simpleRecyclerView.adapter as MyRecyclerViewAdapter).setData(dataList)
        }
    }

    private fun showToast(text: String = "", time: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, text, time).show()
    }
}