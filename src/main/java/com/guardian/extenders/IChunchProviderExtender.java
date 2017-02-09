package com.guardian.extenders;

import iblock.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public interface IChunchProviderExtender extends IChunkProvider {
	
	
	public float getBlockPathWeight(BlockPos pos);

	public Chunk provideChunk(BlockPos pos);
	
	
	public EnumDifficulty getDifficulty();

}
