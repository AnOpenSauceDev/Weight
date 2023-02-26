package an.opensauce.armourweight.commands;

import an.opensauce.armourweight.util.WeightUtil;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.GiveCommand;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.TeleportCommand;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Collection;

public class CalculateWeightCommand implements Command<ServerCommandSource> /*implements Command<ServerCommandSource> */{

    public void register(){

    }

    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerCommandSource source = context.getSource();

        if(source.getPlayer() != null){ // if our sender exists
            PlayerEntity player = source.getPlayer();
            float value = WeightUtil.CalculateWeight(player);
            //player.sendMessage(Text.of("DEBUG: weight = " + value));
            return (int) (value * 10); // a weight of "3.5" will return as "35"
        }else { // if the player doesn't exist (like this being run from the console without "execute as <Player>")
            return 0;
        }
    }

}
