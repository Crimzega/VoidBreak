package com.sulvic.voidbreak.lib;

public class GemstoneData{

	public static enum Type{

		RUBY,
		PINK_PANTHER,
		SAPPHIRE,
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

		public String getTextureName(){ return name().toLowerCase(); }

	}

}
