package tw.Aerry.bukkit.Main;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignHandler implements Listener {
	
	//Create Sign
	@EventHandler
	public void onSignCreate(SignChangeEvent event){
	
			if(event.getBlock().getState() instanceof Sign){
				if(event.getLine(0).equalsIgnoreCase("[AWSSign]")){
					if(event.getLine(1).equalsIgnoreCase("Home")){
						if(event.getLine(2).equalsIgnoreCase("Name:")){
						event.setLine(0, ChatColor.translateAlternateColorCodes('&', "&4�i�W�j�Ԫ��ۻs����j"));
						event.setLine(1, ChatColor.translateAlternateColorCodes('&', "&2�I���ǰe��A�a"));
						event.setLine(2, ChatColor.translateAlternateColorCodes('&', "&3�A�a�W�٬�:"));
						event.getPlayer().sendMessage(ChatColor.DARK_GREEN + "�i�W�j�Ԫ��ۻs����j" + ChatColor.YELLOW + "���\�]�m" + ChatColor.AQUA + "{�ǰe�a}" + ChatColor.YELLOW +  "���i�ܵP");
						return;
					}
					}
				}
			}return;
	
		}
		
	

	//Click Signs
	@EventHandler
	public void onClickSign(PlayerInteractEvent event){
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(event.getClickedBlock().getType() == Material.SIGN || event.getClickedBlock().getType() == Material.SIGN_POST){
				Sign sign = (Sign) event.getClickedBlock().getState();
				if(sign.getLine(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&4�i�W�j�Ԫ��ۻs����j")) && sign.getLine(1).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2�I���ǰe��A�a")) && sign.getLine(2).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&3�A�a�W�٬�:"))){
			
					
					event.getPlayer().chat("/home "+sign.getLine(3).toLowerCase());
					return;
				}	
				
			}return;
		}return;
	}
	
	
	
}
