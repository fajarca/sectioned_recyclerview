package io.fajarca.project.sectionedrecyclerview.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.fajarca.project.sectionedrecyclerview.R
import io.fajarca.project.sectionedrecyclerview.data.RecyclerViewType
import io.fajarca.project.sectionedrecyclerview.adapter.ContainerAdapter
import io.fajarca.project.sectionedrecyclerview.data.DataStore
import kotlinx.android.synthetic.main.activity_content.*


class ContentActivity : AppCompatActivity() {

    companion object {
        private const val INTENT_KEY_RECYCLERVIEW_TYPE = "recyclerview_type"

        fun start(context: Context, recyclerViewType: RecyclerViewType) {
            val bundle = Bundle()
            bundle.putSerializable(INTENT_KEY_RECYCLERVIEW_TYPE, recyclerViewType)

            val intent = Intent(context, ContentActivity::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        handleExtrasParams()
    }

    private fun handleExtrasParams() {
        if (intent.extras != null) {
            val bundle = intent.extras
            val recyclerViewType = bundle?.getSerializable(INTENT_KEY_RECYCLERVIEW_TYPE) as RecyclerViewType
            setupToolbar(recyclerViewType)
            setupRecyclerView(recyclerViewType)
        }
    }



    private fun setupToolbar(recyclerViewType: RecyclerViewType) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        when(recyclerViewType) {
            RecyclerViewType.LINEAR_VERTICAL -> {
                supportActionBar?.title = "Linear RecyclerView"
            }
            RecyclerViewType.LINEAR_HORIZONTAL -> {
                supportActionBar?.title = "Horizontal RecyclerView"

            }
            RecyclerViewType.GRID -> {
                supportActionBar?.title = "Grid RecyclerView"
            }
        }
    }

    private fun setupRecyclerView(recyclerViewType: RecyclerViewType) {
        recyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        val adapter =
            ContainerAdapter(
                this,
                DataStore.populateData(),
                recyclerViewType
            )
        recyclerView.adapter = adapter
    }


}
