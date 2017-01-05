package com.siderislabs.projectmendeleev;

public class Reference {
	public static final String MOD_ID = "projectm";
	public static final String NAME = "Project Mendeleev";
	public static final String VERSION = "0.01";
	public static final String CLIENT_PROXY_CLASS = "com.siderislabs.projectmendeleev.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.siderislabs.projectmendeleev.proxy.ServerProxy";
	public static enum ModdedItems {
		ATOM("Atom", "ItemAtom"),
		VIAL("Vial", "ItemVial"),
		MEDALGOLD("Medal", "ItemMedalGold"),
		MEDALDIAMOND("Medal", "ItemMedalDiamond");
		private String unlocalizedName;
		private String registryName;
		ModdedItems(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
		public String getRegistryName() {
			return registryName;
		}
	}
	public static enum ModdedBlocks {
		STABILIZEDATOMS("Stabilized Atoms", "BlockStabilizedAtoms"),
		CHEMICALDECOMPOSER("ChemicalDecomposer", "BlockChemicalDecomposer");
		private String unlocalizedName;
		private String registryName;
		ModdedBlocks(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
		public String getRegistryName() {
			return registryName;
		}
	}
}
