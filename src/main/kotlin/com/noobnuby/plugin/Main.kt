package com.noobnuby.plugin

import com.noobnuby.plugin.commands.FlySpeed
import org.bukkit.plugin.java.JavaPlugin
import xyz.icetang.lib.kommand.kommand

class Main : JavaPlugin() {
    companion object { lateinit var INSTANCE: Main }

    override fun onEnable() {
        INSTANCE = this

        logger.info("Enable Plugin!")

        kommand {
            FlySpeed.register(this)
        }
    }
}