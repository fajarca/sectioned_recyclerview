package io.fajarca.project.sectionedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerClickListener()
    }

    private fun registerClickListener() {
        btnLinear.setOnClickListener { ContentActivity.start(this, RecyclerViewType.LINEAR_VERTICAL) }
        btnGrid.setOnClickListener { ContentActivity.start(this, RecyclerViewType.GRID) }
        btnLinearHorizontal.setOnClickListener { ContentActivity.start(this, RecyclerViewType.LINEAR_HORIZONTAL) }
    }

}
