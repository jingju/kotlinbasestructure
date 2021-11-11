package com.doit.base.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    /**
     * 增加单个对象
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(element: T): Long

    /**
     *  添加数组对象数据
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg elements: T): LongArray

    /**
     * 添加对象集合
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(list: MutableList<T>): MutableList<Long>

    /**
     * 删除单个对象
     */
    @Delete
    fun delete(element: T)

    /**
     * 删除数组对象数据
     */
    @Delete
    fun delete(vararg elements: T)

    /**
     * 删除对象集合
     */
    @Delete
    fun delete(elements: MutableList<T>)

    /**
     * 更新对象
     */
    @Update
    fun update(element: T)
}