import java.util.*;

public class GameState {
    public WorldMap map;
    public ArrayList<Dwarf> dwarves;

    public Path findPathDwarf(Position start, Position end) {
        // TODO
    }

    public boolean moveDwarf(Dwarf d, int dx, int dy, int dl) {
        Position targetPos = d.pos().add(dx, dy, dl);
        BlockType targetBlock = map.getBlock(targetPos);
        targetPos.l -= 1;
        BlockType floorBlock = map.getBlock(targetPos);

        if (targetBlock.isSolid()) {
            return false;
        }
    }
}
