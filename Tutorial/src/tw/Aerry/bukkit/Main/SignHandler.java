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
						event.setLine(0, ChatColor.translateAlternateColorCodes('&', "&4【上古戰爭自製插件】"));
						event.setLine(1, ChatColor.translateAlternateColorCodes('&', "&2點此傳送到你家"));
						event.setLine(2, ChatColor.translateAlternateColorCodes('&', "&3你家名稱為:"));
						event.getPlayer().sendMessage(ChatColor.DARK_GREEN + "【上古戰爭自製插件】" + ChatColor.YELLOW + "成功設置" + ChatColor.AQUA + "{傳送家}" + ChatColor.YELLOW +  "的告示牌");
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
				if(sign.getLine(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&4【上古戰爭自製插件】")) && sign.getLine(1).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2點此傳送到你家")) && sign.getLine(2).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&3你家名稱為:"))){
			
					
					event.getPlayer().chat("/home "+sign.getLine(3).toLowerCase());
					return;
				}	
				
			}return;
		}return;
	}
	
	
	
}
