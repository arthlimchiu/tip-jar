package com.arthlimchiu.core.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arthlimchiu.core.local.dao.PaymentDao
import com.arthlimchiu.core.local.model.PaymentEntity

@Database(
    entities = [PaymentEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TipDatabase : RoomDatabase() {

    abstract fun paymentDao(): PaymentDao

    companion object {

        @Volatile
        private var INSTANCE: TipDatabase? = null

        fun getInstance(context: Context): TipDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): TipDatabase {
            return Room
                .databaseBuilder(context, TipDatabase::class.java, "tip_jar_database")
                .fallbackToDestructiveMigration() // Don't use this for production and instead use migrations
                .build()
        }
    }
}