package greeting.workspace

import com.jetbrains.rhizomedb.Entrypoint
import fleet.kernel.ChangeScope
import fleet.kernel.saga
import greeting.common.ExampleSharedEntity
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

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

    kernel.saga {
        HttpClient(CIO).use { client ->
            val response: HttpResponse = client.get("https://ktor.io/")
            println("KTOR response: " + response.status)
        }
    }
}

