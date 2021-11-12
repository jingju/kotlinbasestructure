package com.doit.base.db.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 *
 * @Description: 数据库升级处理;每次升级应单独创建Migration
 * <p>
 *     startVersion表示当前版本
 *     endVersion表示将要升级到的版本
 * <p>
 * @CreateDate: 2021/11/11 6:39 下午
 * @Author: yzp
 */
class Migration1_2 : Migration(1, 2) {

    override fun migrate(database: SupportSQLiteDatabase) {
        //todo 升级处理
        database.execSQL("ALTER TABLE Person ADD COLUMN last_update INTEGER");
    }
}