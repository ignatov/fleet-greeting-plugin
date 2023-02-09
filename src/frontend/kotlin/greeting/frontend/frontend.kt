package greeting.frontend

import com.jetbrains.rhizomedb.Entity
import com.jetbrains.rhizomedb.Entrypoint
import com.jetbrains.rhizomedb.byEntityType
import fleet.common.run.DebugSupportEntity
import fleet.frontend.actions.ActionsEP
import fleet.frontend.actions.windowManager
import fleet.kernel.ChangeScope
import fleet.kernel.register
import fleet.protocol.run.TaskType
import greeting.common.ExampleSharedEntity
import greeting.common.FooEntity
import noria.model.Action
import noria.model.ActionPresentation
import noria.model.Propagate
import noria.model.Trigger
import noria.ui.components.hbox
import noria.ui.components.vbox
import noria.ui.core.UIContext
import noria.ui.text.uiText
import noria.windowManagement.extensions.openUrl

val logger = fleet.util.logging.logger<Any>()

@Entrypoint
fun ChangeScope.registerOpenFleetUrlAction() {
    logger.info("Register Open Fleet action")
    register {
        ActionsEP.register {
            Action(
                defaultPresentation = ActionPresentation("Open Fleet"),
                perform = { ac ->
                    ac.windowManager.openUrl("https://jetbrains.com/fleet")
                    val shared = byEntityType(ExampleSharedEntity::class).firstOrNull()
                    logger.info("queried shared entity: " + shared?.name)
                    kernel.changeAsync {
                        val f = new(FooEntity::class) {
                            name = "Foo"
                        }
                        logger.info("new entity name:" + f.name)
                    }
                    Propagate.STOP
                },
                triggers = setOf(OPEN_FLEET_WEBSITE_TRIGGER)
            )
        }


    }
}


private val OPEN_FLEET_WEBSITE_TRIGGER = Trigger("open-fleet-webstite")

interface FrontendEntity : Entity {
    var bar: String
}

fun UIContext.renderFoo(e: FooEntity) {
    vbox {
        hbox {
            uiText("Foo")
        }
    }
}

fun ChangeScope.foo() {
    new(DebugSupportEntity::class) {
        type = TaskType("abvgd")
    }
}

