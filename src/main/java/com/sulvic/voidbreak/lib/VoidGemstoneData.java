package com.sulvic.voidbreak.lib;

public class VoidGemstoneData{

	public static enum Type{

		DIAMOND,
		RUBY,
		PINK_PANTHER,
		SAPPHIRE,
		EMERALD,
		CASSITERITE,
		ENSTATITE,
		MOONSTONE;

		public static int size(){ return values().length; }

		public static Type byMetadata(int metadata){
			for(Type type: values()) if(type.getMetadata() == metadata) return type;
			return null;
		}

		public int getMetadata(){ return ordinal(); }

		public String getUnlocalizedName(){
			switch(this){
				case PINK_PANTHER:
					return "pinkPanther";
				default:
					return name().toLowerCase();
			}
		}

		public String getTextureName(){
			switch(this){
				case PINK_PANTHER:
					return "pink_panther";
				default:
					return name().toLowerCase();
			}
		}

	}

}
