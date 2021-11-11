package com.doit.base.db.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.doit.base.app.BaseApplication
import com.doit.base.db.dao.PersonDao
import com.doit.base.db.entity.Person

/**
 * 数据库创建类
 * <P>
 * entities：数据表
 */
@Database(entities = [Person::class], version = 1)
abstract class DBFactory : RoomDatabase() {

    companion object {
        private const val DB_NAME = "ht.db"

        @Volatile
        private var instance: DBFactory? = null

        fun getInstance(): DBFactory {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase().also { instance = it }
            }
        }

        /*创建数据库*/
        private fun buildDatabase(): DBFactory {
            return Room.databaseBuilder(
                BaseApplication.instance(),
                DBFactory::class.java,
                DB_NAME
            )
                .allowMainThreadQueries() //是否允许在主线程进行查询
                .addCallback(object : RoomDatabase.Callback() { //数据库创建和打开后的回调
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        //todo 数据库创建调用
                    }

                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                        //todo 数据库打开调用
                    }

                    override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                        super.onDestructiveMigration(db)
                        //todo 在数据库被破坏性迁移后调用
                    }
                })
                .fallbackToDestructiveMigration()//数据库升级异常之后的回滚
                //.addMigrations(Migration1_2()) //数据库升级
                .build()
        }
    }

    abstract fun getPerson(): PersonDao
}
