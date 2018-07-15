package world.trav.template.activity.main.repo

import io.reactivex.Single
import world.trav.template.TemplateApp
import world.trav.template.database.TemplateDatabase
import world.trav.template.util.repo.RepoBase
import world.trav.template.util.repo.DataSourceBase
import world.trav.util.executor.AppExecutors

class TemplateRepo private constructor(
        local : DataSourceBase<TemplateEntity>,
        remote : DataSourceBase<TemplateEntity>
) : RepoBase<TemplateEntity>(local, remote){

    companion object {

        private lateinit var instance : TemplateRepo

        fun init(){
            instance = TemplateRepo(
                    LocalDataSource.instance,
                    RemoteDataSource.getInstance()
                    )
        }

        fun getInstance() : TemplateRepo{
            return instance
        }
    }

    private class LocalDataSource private constructor(
            private var dao: TemplateDao,
            private var appExecutors: AppExecutors
    ) : DataSourceBase<TemplateEntity> {
        override fun load(id: String): Single<TemplateEntity> {
            TODO()
        }

        override fun save(data: TemplateEntity) {
            appExecutors.diskIO().execute {
                TODO()
            }
        }

        companion object {
            val instance by lazy {
                LocalDataSource(
                        TemplateDatabase.instance.templateDao(),
                        AppExecutors.instance
                )
            }
        }
    }

    private class RemoteDataSource : DataSourceBase<TemplateEntity> {

        override fun load(id: String): Single<TemplateEntity> {
            TODO()
        }

        override fun save(data: TemplateEntity) {
            TODO()
        }

        companion object {

            private lateinit var instance: RemoteDataSource

            fun init(): RemoteDataSource {
                instance = RemoteDataSource()
                return instance
            }

            fun getInstance(): RemoteDataSource {
                return instance
            }
        }

    }
}
