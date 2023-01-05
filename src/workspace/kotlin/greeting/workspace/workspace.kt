package greeting.workspace

import com.jetbrains.rhizomedb.Entrypoint
import fleet.kernel.ChangeScope
import greeting.common.ExampleSharedEntity

@Entrypoint
fun ChangeScope.entry() {
    println(
        "=".repeat(50) + "\n" +
                "transacting ${ExampleSharedEntity::class}...\n" +
                "=".repeat(50)
    )
    shared {
        new(ExampleSharedEntity::class) {
            name = "example"
        }
    }
}

