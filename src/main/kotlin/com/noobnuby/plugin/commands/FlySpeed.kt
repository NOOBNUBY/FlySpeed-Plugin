package com.noobnuby.plugin.commands

import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.entity.Player
import xyz.icetang.lib.kommand.PluginKommand
import xyz.icetang.lib.kommand.getValue

object FlySpeed {
    fun register(kommand: PluginKommand) {
        kommand.register("flyspeed","fs") {
            requires { isPlayer&&isOp }
            executes {
                val p = sender as Player
                p.sendMessage(MiniMessage.miniMessage().deserialize("<green>현재 속도는 <yellow>${(p.flySpeed*10).toInt()}<green>입니다. <yellow>기본값은 1입니다."))
                p.sendMessage(MiniMessage.miniMessage().deserialize("<green>사용방법 : <yellow>/flyspeed <number> <green>or <yellow>/fs <number>"))
            }
            then("speed" to int()) {
                executes {
                    val speed:Int by it
                    val p = sender as Player
                    if (speed <= 1 || 10 >= speed ) {
                        p.flySpeed = speed.toFloat() / 10
                        p.sendMessage(MiniMessage.miniMessage().deserialize("<green>속도를 <yellow>${speed}<green>으로 설정하였습니다."))
                    }
                    else {
                        p.sendMessage(MiniMessage.miniMessage().deserialize("<yellow>1 ~ 10 <green>사이의 숫자를 입력해주세요!"))
                    }
                }
            }
        }
    }
}