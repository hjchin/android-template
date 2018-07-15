package world.trav.template.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.migration.Migration
import android.util.Log
import world.trav.template.TemplateApp
import world.trav.template.activity.main.repo.TemplateDao
import world.trav.template.activity.main.repo.TemplateEntity

@Database(entities = arrayOf(
        TemplateEntity::class
        ), version = 1)
abstract class TemplateDatabase : RoomDatabase() {
    abstract fun templateDao() : TemplateDao

    companion object {

        val instance : TemplateDatabase by lazy{
            synchronized(TemplateDatabase::class){
                Room.databaseBuilder(TemplateApp.getInstance(),
                    TemplateDatabase::class.java,"template.db")
                    .addMigrations(
                        migration1_2)
                    .build()
            }
        }

        private val migration1_2 : Migration = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                Log.i("database","upgrade database from 1 to 2")
            }
        }

    }
}