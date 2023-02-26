package an.opensauce.armourweight;

import an.opensauce.armourweight.api.armourType;
import an.opensauce.armourweight.commands.CalculateWeightCommand;
import an.opensauce.armourweight.util.Config;
import an.opensauce.armourweight.util.defaultdefs.VanillaDefs;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

import static net.minecraft.server.command.CommandManager.literal;

public class Armourweight implements ModInitializer {

    public static final String ModId = "armourweight";

    public static Logger MainLogger = LoggerFactory.getLogger(ModId);
    @Override
    public void onInitialize() {
        MainLogger.info("Armour Weight has loaded!");
        VanillaDefs.Register();
        AutoConfig.register(Config.class, JanksonConfigSerializer::new);
        CalculateWeightCommand command = new CalculateWeightCommand();
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> literal("CalculateWeight")
                        .executes(new CalculateWeightCommand()));
    }
}
