package world.trav.template.util.repo

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import world.trav.template.util.exception.NoNetworkException
import java.net.SocketTimeoutException

abstract class RepoBase<T : DataModel> protected constructor(
        private var local : DataSourceBase<T>,
        private var remote : DataSourceBase<T>
){

    private lateinit var id : String
    private lateinit var callback : DataSourceBase.GetDataCallback<T>

    fun get(id : String, callback : DataSourceBase.GetDataCallback<T>){

        this@RepoBase.id = id
        this@RepoBase.callback = callback

        Log.i("repo_${this::class.qualifiedName}", "loading...")

        remote.load(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data -> onGetSuccess(data)
            },{t -> onGetFailure(t)})
    }

    private fun onGetSuccess(data : T){
        Log.i("repo_${this::class.qualifiedName}", "load from remote successfully")
        local.save(data)
        Log.i("repo_${this::class.qualifiedName}", "save into local")
        callback.onSuccess(data)
    }

    private fun loadLocal(){
        Log.i("repo_${this::class.qualifiedName}", "load from local")
        local.load(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data -> processLocal(data)
            },{
                t->onGetFailure(t)
            })
    }

    private fun processLocal(data : T){
        Log.i("repo_${this::class.qualifiedName}", "load from local successfully")
        callback.onSuccess(data)
    }

    private fun onGetFailure(t : Throwable){
        if(t is NoNetworkException || t is SocketTimeoutException){
            loadLocal()
        }else{
            Log.i("repo_${this::class.qualifiedName}", "failed to load...")
            callback.onFailure(t)
        }
    }
}

