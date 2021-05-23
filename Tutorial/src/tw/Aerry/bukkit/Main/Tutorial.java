package tw.Aerry.bukkit.Main;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;




public class Tutorial extends JavaPlugin{
	
	Logger log = Logger.getLogger("Tutorial");


	
	
	
	
	
	
	
	
	@Override
	public void onEnable(){
		//Config



		ClockInventory.onLoad();
		
		log.info("[Tutorial]: Das Plugin ist fertig geladen.");
		log.info("[Tutorial]: Das Plugin wird geladen.");
		
		Bukkit.getPluginManager().registerEvents(new PlayerJoinEventClass(), this);
		Bukkit.getPluginManager().registerEvents(new SignHandler(), this);
		Bukkit.getPluginManager().registerEvents(new ClockInventory(), this);



	
	}

	
	
	
	
	
	@Override
	public void onDisable(){
		
		log.info("[Tutorial]: Das Plugin wurde ausgeschaltet.");
	
	}
	


	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("home")){
			if(sender instanceof Player){
				Player p = (Player) sender;

				File PFile = new File("plugins/Tutorial/Players", p.getName()+".yml");
				FileConfiguration PConf = YamlConfiguration.loadConfiguration(PFile);
				
				if(args.length >= 2){
					p.sendMessage(ChatColor.DARK_GREEN + "�i�W�j�Ԫ��ۻs����j" + ChatColor.AQUA + "/home [�a�W��]");
					return true;
				}else if(args.length <= 0){
					StringBuilder sb = new StringBuilder();
					sb.append(ChatColor.DARK_GREEN + "�i�W�j�Ԫ��ۻs����j" + ChatColor.AQUA + "�ثe�Фl��: ");
					if(PConf.contains("Homes")){
					for(String home : PConf.getConfigurationSection("Homes").getKeys(false)){
						sb.append(home+", ");
					}}
					p.sendMessage(sb.toString());		
					return true;
				}else{
					String Name = args[0].toLowerCase();
					if(PConf.contains("Homes."+Name)){
					int x = PConf.getInt("Homes."+Name+".x");
					int y = PConf.getInt("Homes."+Name+".y");
					int z = PConf.getInt("Homes."+Name+".z");
					int yaw = PConf.getInt("Homes."+Name+".yaw");
					int pitch = PConf.getInt("Homes."+Name+".pitch");
					String w = PConf.getString("Homes."+Name+".world");
					
					Location loc = new Location(Bukkit.getWorld(w), x, y, z, yaw, pitch);
					
					p.teleport(loc);
					p.sendMessage(ChatColor.DARK_GREEN + "�i�W�j�Ԫ��ۻs����j" + ChatColor.YELLOW + "���\�ǰe��a!!!");
					return true;
					}else{
						p.sendMessage(ChatColor.DARK_GREEN + "�i�W�j�Ԫ��ۻs����j" + ChatColor.RED + "�A�èS���o�Ӯa!");
						return true;
					}
				}
			}else{
				sender.sendMessage(ChatColor.DARK_GREEN + "�i�W�j�Ԫ��ۻs����j" + ChatColor.BLUE + "�өR�O�u�൹���a�ϥ�!!!");
				return true;
			}
		}
		if(cmd.getName().equalsIgnoreCase("sethome")){
			if(sender instanceof Player){
				Player p = (Player) sender;

				File PFile = new File("plugins/Tutorial/Players", p.getName()+".yml");
				FileConfiguration PConf = YamlConfiguration.loadConfiguration(PFile);
				
				if(args.length != 1){
					p.sendMessage(ChatColor.DARK_GREEN + "�i�W�j�Ԫ��ۻs����j" + ChatColor.AQUA + "/sethome [�A�n���Фl�W��]");
					return true;
				}else{
					String Name = args[0].toLowerCase();
				
					Location loc = p.getLocation();
					
					PConf.set("Homes."+Name+".x", loc.getX());
					PConf.set("Homes."+Name+".y", loc.getY());
					PConf.set("Homes."+Name+".z", loc.getZ());
					PConf.set("Homes."+Name+".yaw", loc.getYaw());
					PConf.set("Homes."+Name+".pitch", loc.getPitch());
					PConf.set("Homes."+Name+".world", loc.getWorld().getName());
					
						try {
							PConf.save(PFile);
						} catch (IOException e) {
						
							e.printStackTrace();
						}
						
				
		
					
					p.sendMessage(ChatColor.DARK_GREEN + "�i�W�j�Ԫ��ۻs����j" + ChatColor.YELLOW + "���\�]�m�a!!!");
					return true;
				}
			}else{
				sender.sendMessage(ChatColor.DARK_GREEN + "�i�W�j�Ԫ��ۻs����j" + ChatColor.BLUE + "�өR�O�u�൹���a�ϥ�!!!");
				return true;
			}
		}
		if(cmd.getName().equalsIgnoreCase("delhome")){
			if(sender instanceof Player){
				Player p = (Player) sender;

				File PFile = new File("plugins/Tutorial/Players", p.getName()+".yml");
				FileConfiguration PConf = YamlConfiguration.loadConfiguration(PFile);
				
				if(args.length != 1){
					p.sendMessage(ChatColor.DARK_GREEN + "�i�W�j�Ԫ��ۻs����j" + ChatColor.AQUA + "/delhome [�Фl�W��]");
					return true;
				}else{
					String Name = args[0].toLowerCase();
					
					PConf.set("Homes."+Name, null);
					
					try {
						PConf.save(PFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					p.sendMessage(ChatColor.DARK_GREEN + "�i�W�j�Ԫ��ۻs����j" + ChatColor.GRAY + "���\�R���a!!!");
					return true;
				}
			}else{
				sender.sendMessage(ChatColor.DARK_GREEN + "�i�W�j�Ԫ��ۻs����j" + ChatColor.BLUE + "�өR�O�u�൹���a�ϥ�!!!");
				return true;
			}
		}
		return false;
	}

}
