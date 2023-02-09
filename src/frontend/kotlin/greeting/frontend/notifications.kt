package greeting.frontend

import com.jetbrains.rhizomedb.Entrypoint
import fleet.frontend.actions.ActionsEP
import fleet.frontend.icons.IconKeys
import fleet.frontend.notifications.*
import fleet.frontend.ui.eventlog.NotificationRenderMode
import fleet.frontend.ui.eventlog.RenderNotificationEP
import fleet.frontend.ui.eventlog.renderExpandableMessage
import fleet.kernel.ChangeScope
import fleet.kernel.register
import noria.model.Action
import noria.model.ActionPresentation
import noria.model.Propagate
import noria.model.Trigger
import noria.ui.components.vbox
import noria.ui.core.UIContext
import noria.ui.text.ParagraphStyle
import noria.ui.text.uiText
import noria.ui.theme.TextStyleKeys
import noria.ui.theme.ThemeKeys

@Entrypoint
fun ChangeScope.registerSampleNotificationHarness() {
  this.register {
    RenderNotificationEP.register(SampleNotification::class) { { notification, mode -> sampleNotification(notification as SampleNotification, mode) } }
    NotificationCategoriesEP.register { SampleNotificationCategory }

    ActionsEP.register {
      Action(
        defaultPresentation = ActionPresentation("Show Sample Notification"),
        perform = {
          kernel.changeAsync {
            new(SampleNotification::class) {
              init(NotificationState.new(true), "Sample Caption", SampleNotificationCategory.id)
              message = "Not very long message"
              success = true
            }
          }
          Propagate.STOP
        },
        triggers = setOf(SHOW_SAMPLE_NOTIFICATION)
      )
    }
  }
}

private val SHOW_SAMPLE_NOTIFICATION = Trigger("show-sample-notification")

private const val MAX_COLLAPSED_LINES = 5

fun UIContext.sampleNotification(notification: SampleNotification, renderMode: NotificationRenderMode) {
  val icon = if (notification.success) IconKeys.Success else IconKeys.Warning
  renderExpandableMessage(renderMode, notification, icon, expandableBuilder = { isExpanded ->
    val firstLines = notification.message.lineSequence().take(MAX_COLLAPSED_LINES + 1).toList()
    val message = if (firstLines.size == MAX_COLLAPSED_LINES + 1 && !isExpanded) {
      firstLines.joinToString("\n").plus("\n\u2026")
    } else {
      notification.message
    }
    vbox {
      uiText(text = message,
        color = theme[ThemeKeys.DimmedText],
        textStyleKey = TextStyleKeys.Small,
        paragraphStyle = ParagraphStyle.multiline)
    }
  })
}

interface SampleNotification : NotificationEntity {
  var message: String
  var success: Boolean
}

val SampleNotificationCategory = NotificationCategory(NotificationCategoryId("sample-id"), "Sample")
