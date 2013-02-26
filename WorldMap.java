public class WorldMap {
    public enum BlockType {
        EMPTY, STONE, GRASS, SAND
    }

    // Map is `layers` width*height flat layers
    final int width, height, layers;
    final int layer_size;
    public BlockType[] map;

    public WorldMap(int w, int h, int num_l) {
        width = w;
        height = h;
        layers = num_l;
        layer_size = width * height;

        // Create the actual map
        map = new BlockType[width * height * layers];
    }

    public BlockType getBlock(int x, int y, int l) {
        return map[l*layer_size + y * width + x];
    }

    public setBlock(BlockType t, int x, int y, int l) {
        map[l*layer_size + y * width + x] = t;
    }
}
