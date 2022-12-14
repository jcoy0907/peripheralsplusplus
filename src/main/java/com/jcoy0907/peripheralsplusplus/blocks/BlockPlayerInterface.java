package com.jcoy0907.peripheralsplusplus.blocks;

import com.jcoy0907.peripheralsplusplus.PeripheralsPlusPlus;
import com.jcoy0907.peripheralsplusplus.creativetab.CreativeTabPPP;
import com.jcoy0907.peripheralsplusplus.reference.Reference;
import com.jcoy0907.peripheralsplusplus.tiles.TileEntityPlayerInterface;
import com.google.common.collect.Lists;
import com.jcoy0907.peripheralsplusplus.creativetab.CreativeTabPPP;
import com.jcoy0907.peripheralsplusplus.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BlockPlayerInterface extends BlockContainerPPP {

    public BlockPlayerInterface()
    {
        super(Material.rock);
        this.setBlockName("playerInterface");
        this.setCreativeTab(CreativeTabPPP.PPP_TAB);
        this.setHardness(4f);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_)
    {
        return new TileEntityPlayerInterface();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ)
    {
        TileEntity te = world.getTileEntity(x, y, z);
        if (!world.isRemote)
        {
            if (te != null)
            {
                player.openGui(PeripheralsPlusPlus.instance, Reference.GUIs.PLAYER_INTERFACE.ordinal(), world, x, y, z);
            }
        }
        return true;
    }
}
