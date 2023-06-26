package greeting.frontend

import com.jetbrains.rhizomedb.Entrypoint
import fleet.frontend.actions.ActionsEP
import fleet.frontend.actions.windowManager
import fleet.kernel.ChangeScope
import fleet.kernel.register
import noria.model.*
import noria.windowManagement.extensions.openUrl

val logger = fleet.util.logging.logger<Any>()

@Entrypoint
fun ChangeScope.registerOpenFleetUrlAction() {
  logger.info("Register Open Fleet action")
  register {
    ActionsEP.register {
      Action(
        defaultPresentation = ActionPresentation("Open Fleet Website"),
        perform = { ac ->
          ac.windowManager.openUrl("https://jetbrains.com/fleet")
          Propagate.STOP
        },
        identifier = "Register Open Fleet action",
        triggers = setOf(OPEN_FLEET_WEBSITE_TRIGGER)
      )
    }
  }
}

private val OPEN_FLEET_WEBSITE_TRIGGER = Trigger("open-fleet-webstite")