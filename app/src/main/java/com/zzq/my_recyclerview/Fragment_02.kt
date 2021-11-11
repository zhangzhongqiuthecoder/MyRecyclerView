package com.zzq.my_recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment_02 : Fragment(){

    companion object {
        private const val TAG = "Fragment_02"

        fun createInstance(): Fragment_02 {
            val fragment = Fragment_02().apply {
                arguments = Bundle().apply {
                    // putString( , )
                }
            }
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //TODO
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    private fun initData() {

    }

    private fun initView() {

    }
}