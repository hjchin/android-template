package world.trav.util

import android.content.Context
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


class FileUitl{

    companion object {

        fun exportDB(context: Context){
            try {
                val sd = Environment.getExternalStorageDirectory()

                if (sd.canWrite()) {
                    val backupDBPath = "trav.db"
                    val currentDB = context.getDatabasePath("trav.db")
                    val backupDB = File(sd, backupDBPath)

                    val src = FileInputStream(currentDB).channel
                    val dst = FileOutputStream(backupDB).channel
                    dst.transferFrom(src, 0, src.size())
                    src.close()
                    dst.close()
                    Log.i("database","export database done")
                }
            } catch (e: Exception) {
                Log.e("database","export database failed. "+e.message)
            }
        }

    }
}