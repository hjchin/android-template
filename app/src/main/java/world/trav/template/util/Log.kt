package world.trav.template.util

import world.trav.template.BuildConfig

class Log{

    companion object {

        const val LTAG  : String = "trav_info"
        const val DOWNLOAD_PDF : String = "download_pdf"

        @JvmStatic
        fun d(tag : String, msg : String){
            if(BuildConfig.DEBUG){
                android.util.Log.d(tag, msg)
            }
        }

        @JvmStatic
        fun i(tag : String, msg : String){
            if(BuildConfig.DEBUG){
                android.util.Log.i(tag, msg)
            }
        }

        @JvmStatic
        fun i(msg : String){
            if(BuildConfig.DEBUG){
                android.util.Log.i(Log.LTAG, msg)
            }
        }

        @JvmStatic
        fun wtf(tag : String, msg : String){
            if(BuildConfig.DEBUG){
                android.util.Log.wtf(tag, msg)
            }
        }
    }

}