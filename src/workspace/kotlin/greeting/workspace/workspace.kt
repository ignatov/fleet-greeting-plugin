package greeting.workspace

import com.jetbrains.rhizomedb.Entrypoint
import fleet.kernel.ChangeScope
import fleet.kernel.saga
import fleet.util.logging.logger
import greeting.common.ExampleSharedEntity
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

val logger = logger<HttpClient>()

@Entrypoint
fun ChangeScope.entry() {
    logger.info(
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
            logger.info("KTOR response: " + response.status)
        }
    }
}

