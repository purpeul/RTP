package fr.purple.rtp;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Random;

public class RTPCommand implements CommandExecutor {

    private Random random = new Random();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)){
            System.out.println("Error, you must be a player to do that");
            return false;
        }

        Player player = ((Player) commandSender);
        FileConfiguration configuration = RTPPlugin.inst().getConfig();

        int min = configuration.getInt("max");
        int max = configuration.getInt("min");

        int x = random.nextInt(max-min)+max;
        int z = random.nextInt(max-min)+max;

        if(configuration.getBoolean("negative")){
            switch(random.nextInt(4)){
                case 0:
                    x=x*-1;
                    break;
                case 1:
                    x=x*-1;
                case 2:
                    z=z*-1;
            }
        }

        player.sendMessage(configuration.getString("message").replace("&", "§"));
        player.teleport(new Location(player.getWorld(), x, player.getWorld().getHighestBlockYAt(x, z), z));
        return true;
    }
}
