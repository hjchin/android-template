# android-template (Work in Progress)
An Android project quick start template

## Objective
Adopting MVVM architecture, architecture component and [Guide to App Architecture](https://developer.android.com/jetpack/docs/guide)
to build a template that solve common issues. 

### Offline data availability
tackle the problem with remote and local data source. User could consume the content with data cache when there is no internet 
connectivity.

...

## Idea to implement 
The idea wish list.

### Navigation
### Solve layout consistency/reuse 



## Snippet
Some copy-and-paste code snippet for common tasks

### Singleton class with getInstance(context: Context) function

    companion object {

        @Volatile private var INSTANCE: SingletonClass? = null

        fun getInstance(context: Context): SingletonClass {
            return INSTANCE ?: synchronized(this) {
                SingletonClass(context).also {
                    INSTANCE = it
                }
            }
        }

    }
