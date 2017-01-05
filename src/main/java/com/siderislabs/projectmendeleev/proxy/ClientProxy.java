package com.siderislabs.projectmendeleev.proxy;

import com.siderislabs.projectmendeleev.init.ModBlocks;
import com.siderislabs.projectmendeleev.init.ModItems;

public class ClientProxy implements CommonProxy {

	@Override
	public void init() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}
}
