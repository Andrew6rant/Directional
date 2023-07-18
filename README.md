# Directional

Minecraft mod that allows certain blocks to be placed relative to the player's direction.

![directional](https://github.com/Andrew6rant/Directional/assets/57331134/12bc0502-4c94-4ec4-941c-8076033fae32)

This project is extremely experimental, it is more of a tech demo than something that should be used in production. It hooks into Minecraft's `ChunkBuilder.BuiltChunk.RebuildTask.class` to translate matrices based on `BlockState`'s that I inject at runtime. This side-steps Minecraft's model loading entirely, but is not performance friendly.

Shaders are only supported if you add `mixin.features.chunk_rendering=false` to your instance's `sodium-mixins.properties` configuration file.

![directional_sodium_iris_compat](https://github.com/Andrew6rant/Directional/assets/57331134/22e5cd72-d423-4a9c-9313-e430d3884ee6)
