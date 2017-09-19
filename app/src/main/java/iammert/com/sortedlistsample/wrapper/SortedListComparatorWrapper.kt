package iammert.com.sortedlistsample.wrapper

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.util.SortedListAdapterCallback
import java.util.*

/**
 * Created by mertsimsek on 19/09/2017.
 */

abstract class SortedListComparatorWrapper<T>(adapter: RecyclerView.Adapter<*>, private var comparator: Comparator<T>?) : SortedListAdapterCallback<T>(adapter) {

    fun setComparator(comparator: Comparator<T>) {
        if (comparator == this.comparator) {
            return
        }

        this.comparator = comparator
    }

    override fun compare(o1: T, o2: T) = comparator!!.compare(o1, o2)
}
