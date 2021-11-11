package com.doit.base.db

import com.doit.base.db.database.DBFactory
import com.doit.base.db.entity.Person

/**
 * db 对外公共类
 */
class DBManager {

    companion object {
        @Volatile
        private var instance: DBManager? = null

        @Synchronized
        fun getInstance(): DBManager {
            if (instance == null) {
                instance = DBManager()
            }
            return instance!!
        }
    }

    fun insertPerson(name: String): Long {
        val person = Person(0, name)
        return DBFactory.getInstance().getPerson().insert(person)
    }
}