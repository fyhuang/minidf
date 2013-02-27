import java.util.*;

public class WorldMap {
    public enum BlockType {
        EMPTY, STONE, GRASS, DIRT, SAND, WATER,
            STAIRS;

        public boolean isSolid() {
            return this != EMPTY;
        }
    }

    // Map is `nlayers` width*height flat layers
    final int width, height, nlayers;
    final int layer_size;
    public BlockType[] map;

    public WorldMap(int w, int h) {
        this(w, h, 64);
    }

    public WorldMap(int w, int h, int num_l) {
        width = w;
        height = h;
        nlayers = num_l;
        layer_size = width * height;

        // Create the actual map
        map = new BlockType[width * height * nlayers];
    }

    public BlockType getBlock(int x, int y, int l) {
        return map[l*layer_size + y * width + x];
    }

    public BlockType getBlock(Position p) {
        return getBlock(p.x, p.y, p.l);
    }

    public void setBlock(BlockType t, int x, int y, int l) {
        map[l*layer_size + y * width + x] = t;
    }


    // Map generation functions
    public long generate() {
        long seed = new Random().nextLong();
        generate(seed);
        return seed;
    }

    public void generate(long seed) {
        Random rng = new Random(seed);

        for (int l = 0; l < 32; l++) {
            _fillLayer(BlockType.STONE, l);
        }
        for (int l = 32; l < 48; l++) {
            _fillLayer(BlockType.DIRT, l);
        }
        for (int l = 48; l < nlayers; l++) {
            _fillLayer(BlockType.EMPTY, l);
        }
    }

    private void _shiftUp(int x, int y, int n) {
        for (int i = nlayers-1; i >= n; i--) {
            BlockType t = getBlock(x, y, i-n);
            setBlock(t, x, y, i);
        }

        for (int i = 0; i < n; i++) {
            setBlock(BlockType.STONE, x, y, i);
        }
    }

    private void _fillLayer(BlockType t, int l) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                setBlock(t, x, y, l);
            }
        }
    }
}
