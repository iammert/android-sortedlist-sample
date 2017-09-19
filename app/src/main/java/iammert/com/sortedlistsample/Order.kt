package iammert.com.sortedlistsample

import java.util.Comparator

import iammert.com.sortedlistsample.data.User

/**
 * Created by mertsimsek on 19/09/2017.
 */

class Order {

    class AgeOrder : Comparator<User> {

        override fun compare(user: User, t1: User): Int {
            return user.age - t1.age
        }
    }

    class ScoreOrder : Comparator<User> {
        override fun compare(user: User, t1: User): Int {
            return user.score - t1.score
        }
    }
}
