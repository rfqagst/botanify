package com.example.botanify.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.botanify.data.local.room.entity.KoleksiTanaman
import com.example.botanify.data.local.room.entity.User

@Database(
    entities = [
        KoleksiTanaman::class,
        User::class,
    ],
    version = 1
)
abstract class BotanifyDatabase : RoomDatabase() {


    companion object {
        @Volatile
        private var INSTANCE: BotanifyDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): BotanifyDatabase {
            if (INSTANCE == null) {
                synchronized(BotanifyDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        BotanifyDatabase::class.java, "botanify_database"
                    )
                        .build()
                }
            }
            return INSTANCE as BotanifyDatabase
        }
    }

}