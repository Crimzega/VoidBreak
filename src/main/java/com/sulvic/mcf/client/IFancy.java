package com.sulvic.mcf.client;

import com.sulvic.mcf.network.proxy.ZaranthaClient;

public interface IFancy{

	@ZaranthaClient
	void setFancyGraphics(boolean fancy);

}
