package com.siderislabs.projectmendeleev;

import java.io.File;

import com.siderislabs.projectmendeleev.init.ModBlocks;
import com.siderislabs.projectmendeleev.init.ModItems;
import com.siderislabs.projectmendeleev.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = "[1.10.2]")
public class Starter {
	@Instance
	public static Starter instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static File modConfigDir;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModItems.init();
		ModItems.register();
		ModBlocks.init();
		ModBlocks.register();
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		modConfigDir = event.getModConfigurationDirectory();
		
	}
	public void init(FMLInitializationEvent event)
	{
		proxy.init();
	}
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	public static File getModConfigDir() {
		return modConfigDir;
	}
}
