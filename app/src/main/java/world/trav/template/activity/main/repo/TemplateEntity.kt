package world.trav.template.activity.main.repo

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import world.trav.template.util.repo.DataModel

@Entity
class TemplateEntity(
        @PrimaryKey
        override var id : String = ""
) : DataModel()