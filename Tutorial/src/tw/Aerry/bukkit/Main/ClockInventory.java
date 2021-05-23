package tw.Aerry.bukkit.Main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClockInventory implements Listener{
	
	HashMap<Player, String> Players = new HashMap<Player, String>();
	
	static Inventory inv = null;
	
	//Invtar erstellen
	@SuppressWarnings("deprecation")
	static public void onLoad(){
		String InvtarName = ChatColor.translateAlternateColorCodes('&', "&2Hammer-geiles-Inventar");
		int inventoryLines = 1*9; //Max 6*9
		Inventory inventory = Bukkit.getServer().createInventory(null, inventoryLines, InvtarName);
		
		//Items
		ItemStack item = new ItemStack(355);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2Dein Home Bed"));
		item.setItemMeta(meta);
		item.setDurability((short) 0);
		
		inventory.setItem(1, item);
		
		ItemStack item1 = new ItemStack(355);
		ItemMeta meta1 = item1.getItemMeta();
		meta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2Dein Home Home"));
		item1.setItemMeta(meta1);
		item1.setDurability((short) 0);
		
		inventory.setItem(2, item1);
		
		inv=inventory;
	}


	@SuppressWarnings("deprecation")
	public void onInventoryClick(InventoryClickEvent event)
	{
		if(Players.containsKey(event.getWhoClicked()))
		{
	        if (event.getInventory().getHolder() == null)
	        {
	            if (event.getWhoClicked() instanceof Player)
	            {
	            	if (event.getCurrentItem() != null)
	                {
		                if (event.getCurrentItem().getTypeId() != 0)
		                { 	
		                	if (inv.contains(event.getCurrentItem()))
		                	{
			                    // Get the player
			                    Player player = (Player) event.getWhoClicked();
			                    
			                    ItemStack item = event.getCurrentItem();
			                    if(item.getTypeId() == 355 && item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2Dein Home Bed"))){
			                    	player.chat("/home Bed");			                 
			                    }
			                    if(item.getTypeId() == 355 && item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2Dein Home Home"))){
			                    	player.chat("/home Home");
			                    }
			                    Players.remove(player);
			                    player.closeInventory();
			                }
		                }
		            }
	            }
	        }
		}
	    event.setCancelled(true);
	}

	}



