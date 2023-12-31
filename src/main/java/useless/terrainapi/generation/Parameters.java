package useless.terrainapi.generation;

import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.chunk.Chunk;

import java.util.Random;

/**
 * Container for references to chunk decorator info
 */
public class Parameters {
	public Biome biome;
	public Random random;
	public Chunk chunk;
	public ChunkDecoratorAPI decorator;
	public Object[] customParameters = new Object[0];
	public Parameters(Biome biome, Random random, Chunk chunk, ChunkDecoratorAPI chunkDecorator, Object[] customParameters){
		this(biome, random, chunk, chunkDecorator);
		this.customParameters = customParameters;
	}
	public Parameters(Biome biome, Random random, Chunk chunk, ChunkDecoratorAPI chunkDecorator){
		this.biome = biome;
		this.random = random;
		this.chunk = chunk;
		this.decorator = chunkDecorator;
	}
	public Parameters(Parameters baseParameter, Object[] customParameters){
		this(baseParameter.biome, baseParameter.random, baseParameter.chunk, baseParameter.decorator);
		this.customParameters = customParameters;
	}
}
