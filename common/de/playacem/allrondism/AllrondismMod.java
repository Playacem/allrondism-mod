package de.playacem.allrondism;

// inspired by Pahimar's EE3 
// (https://github.com/pahimar/Equivalent-Exchange-3/tree/master/ee3_common/com/pahimar/ee3)

//java imports
import java.io.File;

import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

import de.playacem.allrondism.block.ModBlocks;
import de.playacem.allrondism.configuration.ConfigurationHandler;
import de.playacem.allrondism.core.helper.LogHelper;
import de.playacem.allrondism.core.proxy.CommonProxy;
import de.playacem.allrondism.creativetab.CreativeTabAM;
import de.playacem.allrondism.item.ModItems;
import de.playacem.allrondism.lib.Reference;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
/**
 * Allrondism-Mod
 * 
 * AllrondismMod
 * 
 * Main class for the Minecraft mod "Allrondism"
 * @author Playacem
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AllrondismMod {

    @Instance(Reference.MOD_ID)
    public static AllrondismMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static CreativeTabs tabsAM = new CreativeTabAM(
            CreativeTabs.getNextID(), Reference.MOD_ID);

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        // Here goes stuff like reading config files

        // Initialize the log helper
        LogHelper.init();

        // Initialize the configuration
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.MOD_ID + ".cfg"));

        //adding a name for the Custom Tab
        LanguageRegistry.instance().addStringLocalization("itemGroup." + Reference.MOD_ID, "en_US", Reference.MOD_NAME);
        // Initialize mod items
        ModItems.init();

        // Initialize mod blocks
        ModBlocks.init();

    }

    @Init
    public void load(FMLInitializationEvent event) {
        proxy.registerRenderers();
    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
    }

}

// TODO UPDATE TEXTURE CODE