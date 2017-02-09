package com.guardian.main;

import com.guardian.entity.EntityGuardian;
import com.guardian.entity.RenderGuardian;
import com.guardian.entity.models.ModelGuardian;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.item.Item;


@Mod(modid = "TemogAesthetics", name = "Temog Aesthetics", version = "1.0")

public class Guardian {
	
	public static Item prismaItem;
	
	public static final String modid = "TemogAesthetics";
	public static final String version = "Alpha v1";
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//Item/Block init and registering
		//config handling
		
			EntityRegistry.registerGlobalEntityID(EntityGuardian.class, "Guardian", EntityRegistry.findGlobalUniqueEntityId(), 0x5A7A6C, 0xE57E3E);
			RenderingRegistry.registerEntityRenderingHandler(EntityGuardian.class, new RenderGuardian(new ModelGuardian()));



	}	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		//proxy, TileEntry, Entity, GUI, and Packet rego
			
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	
	}
		
	};

