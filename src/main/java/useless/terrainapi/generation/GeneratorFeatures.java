package useless.terrainapi.generation;

import net.minecraft.core.world.generate.feature.WorldFeature;
import org.jetbrains.annotations.ApiStatus;
import useless.terrainapi.TerrainMain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GeneratorFeatures {
	@ApiStatus.Internal
	public List<Function<Parameters, WorldFeature>> featureFunctionsList = new ArrayList<>();
	@ApiStatus.Internal
	public List<Object[]> featureParametersList = new ArrayList<>();
	@ApiStatus.Internal
	public List<Function<Parameters, Integer>> densityFunctionsList = new ArrayList<>();
	@ApiStatus.Internal
	public List<Object[]> densityParametersList = new ArrayList<>();

	/**Adds a world feature entry
	 * @param featureFunction Function that takes a Parameters object and returns a WorldFeature
	 * @param featureParameters Object[] of additional parameters that will be included with the Parameters object passed into the feature function
	 * @param densityFunction Function that takes a Parameters object and returns an Integer representing the number of attempts per chunk
	 * @param densityParameters Object[] of additional parameters that will be included with the Parameters object passed into the density function
	 */
	public void addFeature(Function<Parameters, WorldFeature> featureFunction, Object[] featureParameters, Function<Parameters, Integer> densityFunction, Object[] densityParameters){
		if (TerrainMain.LOCK_API){
			throw new RuntimeException("Illegal use of Terrain Initialization outside of the main terrain-api entrypoint loop!!!");
		}
		featureFunctionsList.add(featureFunction);
		featureParametersList.add(featureParameters);
		densityFunctionsList.add(densityFunction);
		densityParametersList.add(densityParameters);
	}
}
