package iammert.com.sortedlistsample

import android.support.v7.util.SortedList
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import iammert.com.sortedlistsample.data.User
import iammert.com.sortedlistsample.wrapper.SortedListComparatorWrapper

/**
 * Created by mertsimsek on 19/09/2017.
 */

class SortedListSampleAdapter : RecyclerView.Adapter<SortedListSampleAdapter.UserViewHolder>() {

    private val userSortedList: SortedList<User>
    private val sortedListComparatorWrapper: SortedListComparatorWrapper<User>

    init {
        sortedListComparatorWrapper = UserSortedListImpl(this)
        userSortedList = SortedList(User::class.java, SortedList.BatchedCallback<User>(sortedListComparatorWrapper))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.setUser(userSortedList.get(position))
    }

    override fun getItemCount() = userSortedList.size()

    fun addUser(user: User) {
        with(userSortedList) {
            beginBatchedUpdates()
            add(user)
            endBatchedUpdates()
        }
    }

    fun addUsers(users: List<User>) {
        with(userSortedList) {
            beginBatchedUpdates()
            addAll(users)
            endBatchedUpdates()
        }
    }

    fun removeUser(index: Int) {
        with(userSortedList) {
            if (size() == 0) {
                return
            }
            beginBatchedUpdates()
            remove(userSortedList.get(index))
            endBatchedUpdates()
        }
    }


    fun changeSortType(comparator: Comparator<User>) {
        with(userSortedList){
            sortedListComparatorWrapper.setComparator(comparator)
            beginBatchedUpdates()
            val tempUsers = (0 until userSortedList.size()).mapTo(ArrayList<User>()) { get(it) }
            clear()
            addAll(tempUsers)
            tempUsers.clear()
            endBatchedUpdates()
        }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewUsername: TextView = itemView.findViewById(R.id.textViewUserName)
        var textViewBirthDate: TextView = itemView.findViewById(R.id.textViewBirthDate)
        var textViewScore: TextView = itemView.findViewById(R.id.textViewScore)

        fun setUser(user: User) {
            textViewUsername.text = user.name
            textViewBirthDate.text = "Age: " + user.age
            textViewScore.text = "Score:" + user.score
        }
    }
}
