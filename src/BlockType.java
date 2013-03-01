public enum BlockType {
    EMPTY, STONE, GRASS, DIRT, SAND, WATER,
        STAIRS;

    public boolean isSolid() {
        return this != EMPTY;
    }
}
