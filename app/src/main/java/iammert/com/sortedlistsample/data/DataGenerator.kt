package iammert.com.sortedlistsample.data

import java.util.ArrayList

/**
 * Created by mertsimsek on 19/09/2017.
 */

object DataGenerator {

    private val names = arrayOf("Ali", "Ahmet", "Veli", "Niyazi", "Alican", "Cihad", "Taylan", "Hakan", "Şamil", "Nuri")

    fun generateNewUser(): User {
        val user = User()
        user.id = (Math.random() * 1000).toInt()
        user.age = (Math.random() * 120).toInt()
        user.name = names[(Math.random() * names.size).toInt()] + " " + names[(Math.random() * names.size).toInt()]
        user.score = (Math.random() * 10000).toInt()
        return user
    }

    fun generateBulkUsers(): List<User> {
        val users = ArrayList<User>()
        for (i in 0..9) {
            users.add(generateNewUser())
        }
        return users
    }
}
