package world.trav.template.util.repo

import io.reactivex.Single

interface DataSourceBase<T>{

    interface GetDataCallback<T>{
        fun onSuccess(data : T)
        fun onFailure(throwable: Throwable)
    }

    fun load(id : String) : Single<T>
    fun save(data : T)
}