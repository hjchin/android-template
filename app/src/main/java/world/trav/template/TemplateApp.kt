package world.trav.template

import android.app.Application

class TemplateApp : Application(){

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private lateinit var instance : TemplateApp
        fun getInstance() : TemplateApp{
            return instance
        }
    }
}