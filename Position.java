public class Position {
    public int x, y, l;

    public Position(int x, int y, int l) {
        this.x = x;
        this.y = y;
        this.l = l;
    }

    public Position add(int dx, int dy, int dl) {
        return new Position(x + dx, y + dy, l + dl);
    }

    public Position operator_add(Position other) {
        return new Position(x + other.x, y + other.y, l + other.l);
    }
}
