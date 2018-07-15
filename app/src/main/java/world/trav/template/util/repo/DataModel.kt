package world.trav.template.util.repo


abstract class DataModel{
    abstract var id : String
    var last_update : Long = java.util.Date().time/1000L
}
