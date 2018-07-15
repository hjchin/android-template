package world.trav.util.executor

import android.support.annotation.NonNull
import java.util.concurrent.Executor
import java.util.concurrent.Executors.*

class DiskIOThreadExecutor: Executor {
    private val mDiskIO:Executor
    init{
        mDiskIO = newSingleThreadExecutor()
    }
    override fun execute(@NonNull command:Runnable) {
        mDiskIO.execute(command)
    }
}