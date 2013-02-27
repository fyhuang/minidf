public class Dwarf {
    public Position pos;

    // Dwarf statuses
    public String dwarfName;
    public boolean isAlive;

    public int foodNeed;
    public int sleepNeed;
    public int restNeed;


    public Dwarf(String name, Position init_pos) {
        pos = init_pos;
        
        dwarfName = name;
        isAlive = true;

        foodNeed = 0;
        sleepNeed = 0;
        restNeed = 0;
    }

    public void move(int dx, int dy, int dl) {
        pos = pos.add(dx, dy, dl);
    }
}
