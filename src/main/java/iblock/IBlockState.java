package iblock;

import java.util.Collection;

import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import node.extenders.IProperty;

public interface IBlockState {
    Collection<IProperty> getPropertyNames();

    <T extends Comparable<T>> T getValue(IProperty<T> property);

    <T extends Comparable<T>, V extends T> IBlockState withProperty(IProperty<T> property, V value);

    <T extends Comparable<T>> IBlockState cycleProperty(IProperty<T> property);

    ImmutableMap<IProperty, Comparable> getProperties();

    Block getBlock();
}
