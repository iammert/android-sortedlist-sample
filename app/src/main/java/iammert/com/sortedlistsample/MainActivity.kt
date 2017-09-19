package iammert.com.sortedlistsample

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import iammert.com.sortedlistsample.data.DataGenerator

fun RecyclerView.setup(context: Context) {
    this.layoutManager = LinearLayoutManager(context)
}

class MainActivity : AppCompatActivity() {

    internal lateinit var adapter: SortedListSampleAdapter
    internal lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).also { it.setup(this) }
        adapter = SortedListSampleAdapter()
        recyclerView.adapter = adapter

        findViewById<View>(R.id.buttonAgeOrder).setOnClickListener { adapter.changeSortType(Order.AgeOrder()) }
        findViewById<View>(R.id.buttonScoreOrder).setOnClickListener { adapter.changeSortType(Order.ScoreOrder()) }

        findViewById<View>(R.id.buttonAdd).setOnClickListener { adapter.addUser(DataGenerator.generateNewUser()) }
        findViewById<View>(R.id.buttonAddBulk).setOnClickListener { adapter.addUsers(DataGenerator.generateBulkUsers()) }
        findViewById<View>(R.id.buttonRemove).setOnClickListener { adapter.removeUser((Math.random() * (adapter.itemCount - 1)).toInt()) }
        findViewById<View>(R.id.buttonUpdate).setOnClickListener {
            //todo
        }


    }
}
