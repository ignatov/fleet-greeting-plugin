package greeting.common

import com.jetbrains.rhizomedb.Entity
import fleet.common.run.DebugSupportEntity
import fleet.kernel.ChangeScope
import fleet.kernel.SharedEntity
import fleet.protocol.run.TaskType

interface FooEntity: Entity {
    var name : String
}

interface ExampleSharedEntity : SharedEntity {
    var name: String
}

fun ChangeScope.foo() {
    new(DebugSupportEntity::class) {
        type = TaskType("abvgd")
    }
}