package com.sulvic.mcf.network.proxy;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.*;

import cpw.mods.fml.relauncher.*;

@Retention(RUNTIME)
@Target({TYPE, FIELD, METHOD, CONSTRUCTOR})
@SideOnly(Side.SERVER)
public @interface ZaranthaServer{

}
