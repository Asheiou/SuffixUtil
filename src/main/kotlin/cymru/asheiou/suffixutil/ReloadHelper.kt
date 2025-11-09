package cymru.asheiou.suffixutil

import net.kyori.adventure.audience.Audience
import xyz.aeolia.lib.sender.MessageSender

object ReloadHelper {
  fun reload(util: SuffixUtil, recipient: Audience) {
    val (added, removed) = util.configManager.loadConfig()
    if (added == -1) {
      MessageSender.sendMessage(
        recipient,
        "Config was unreadable or missing! Generated a new one - please check your defaults, or console for more information."
      )
    } else {
      MessageSender.sendMessage(
        recipient,
        "Config reloaded. $added lines added, $removed lines removed."
      )
    }
    if (util.readmeManager.init()) {
      MessageSender.sendMessage(
        recipient,
        "README.txt reloaded. Check console for more details."
      )
    }
  }
}