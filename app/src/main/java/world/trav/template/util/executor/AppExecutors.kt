package world.trav.util.executor

import android.os.Handler
import android.os.Looper
import android.support.annotation.NonNull
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors
internal constructor(diskIO:Executor, networkIO:Executor, mainThread:Executor) {

    private val diskIO : Executor
    private val networkIO:Executor
    private val mainThread:Executor

    init{
        this.diskIO = diskIO
        this.networkIO = networkIO
        this.mainThread = mainThread
    }
    constructor() : this(DiskIOThreadExecutor(), Executors.newFixedThreadPool(THREAD_COUNT),
            MainThreadExecutor())

    fun diskIO():Executor {
        return diskIO
    }
    fun networkIO():Executor {
        return networkIO
    }
    fun mainThread():Executor {
        return mainThread
    }
    private class MainThreadExecutor:Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(@NonNull command:Runnable) {
            mainThreadHandler.post(command)
        }
    }
    companion object {
        private val THREAD_COUNT = 3
        val instance by lazy {
            AppExecutors()
        }
    }
}