package cymru.asheiou.suffixutil

import cymru.asheiou.configmanager.ConfigManager
import cymru.asheiou.configmanager.ReadmeManager
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class SuffixUtil : JavaPlugin() {
  val configManager = ConfigManager(this, true)
  val readmeManager = ReadmeManager(this, "readme.txt")

  override fun onEnable() {
    ReloadHelper.reload(this, Bukkit.getConsoleSender())
    getCommand("suffixreload")?.setExecutor(ReloadExecutor(this))
    server.pluginManager.registerEvents(JoinEventHandler(this), this)
    logger.info("Loaded.")
  }

  override fun onDisable() {
    // Plugin shutdown logic
  }
}
