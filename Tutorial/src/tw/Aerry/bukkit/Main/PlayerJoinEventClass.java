package tw.Aerry.bukkit.Main;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEventClass implements Listener{
		
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoin(PlayerJoinEvent event){
		if(event.getPlayer().hasPermission("Tutorial.Join.Heal")){
			event.getPlayer().setHealth(event.getPlayer().getMaxHealth());
			event.getPlayer().setFoodLevel(20);
			event.getPlayer().sendMessage("[Tutorial]: Dein Essen und dein Leben wurden voll gesetzt.");
		}return;
	}





	@EventHandler(priority = EventPriority.LOW)
	public void onPlayerJoinConfig(PlayerJoinEvent event){
		
		Player p = event.getPlayer();
		File PFile = new File("plugins/SmallCheBukkitPower/Players", p.getName()+".yml");
		FileConfiguration PConf = YamlConfiguration.loadConfiguration(PFile);
	
		PConf.options().copyDefaults(true);
		try {
			PConf.save(PFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}


	@EventHandler
	public void onPlayerJointoConfig(PlayerJoinEvent event){
		
		Player p = event.getPlayer();
		File PFile = new File("plugins/SmallCheBukkitPower/Players", p.getName()+".yml");
		FileConfiguration PConf = YamlConfiguration.loadConfiguration(PFile);
        String uuid = p.getPlayer().getUniqueId().toString();
	
	
		
		PConf.set("Player."+"PlayerUUID"+".uuid", uuid);
		
     		try {
				PConf.save(PFile);
			} catch (IOException e) {
			
				e.printStackTrace();
			}
	}
	}
	












