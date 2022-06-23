package com.example.membersprrestful

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BbsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bbs)

        var recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        val memlist = MemberDao.getInstance().allMember()
        println(memlist[0].name)

        val mAdapter = CustomAdapter(this, memlist)
        recyclerView.adapter = mAdapter

        val layout = LinearLayoutManager(this)
        recyclerView.layoutManager = layout
        recyclerView.setHasFixedSize(true)
    }
}