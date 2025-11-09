package cymru.asheiou.suffixutil

import net.kyori.adventure.audience.Audience
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class ReloadExecutor(val util: SuffixUtil) : CommandExecutor {
  override fun onCommand(
    sender: CommandSender,
    command: Command,
    label: String,
    args: Array<out String>?
  ): Boolean {
    ReloadHelper.reload(util, sender as Audience)
    return true
  }
}