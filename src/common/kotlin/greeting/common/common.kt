package greeting.common

import com.jetbrains.rhizomedb.Entity
import fleet.kernel.SharedEntity

interface FooEntity: Entity {
    var name : String
}

interface ExampleSharedEntity : SharedEntity {
    var name: String
}