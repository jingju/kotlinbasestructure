package com.doit.base.db.dao

import androidx.room.Dao
import com.doit.base.db.entity.Person

@Dao
interface PersonDao : BaseDao<Person> {
}