package cymru.asheiou.suffixutil

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin
import xyz.aeolia.lib.manager.PermissionManager

class JoinEventHandler(val plugin: JavaPlugin) : Listener {
  @EventHandler(priority = EventPriority.LOW)
  fun onJoin(event: PlayerJoinEvent) {
    if (!plugin.config.getBoolean("enabled", false))
      return
    @Suppress("unchecked_cast")
    (plugin.config.getStringList("suffixes"))
      .filterNot { event.player.hasPermission("group.$it") }
      .forEach { suffix ->
        PermissionManager.permissionUpdate(event.player.uniqueId, "group.$suffix", true)
      }
  }
}