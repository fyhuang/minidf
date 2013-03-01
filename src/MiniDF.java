import org.newdawn.slick.*;

public class MiniDF extends BasicGame {
    public static void main(String[] args) throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new MiniDF());

        app.setDisplayMode(640, 480, false);
        app.start();
    }

    public MiniDF()
    {
        super("Mini Dwarf Fortress");
    }

    @Override
    public void init(GameContainer gc) throws SlickException
    {
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException
    {
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
    }
}
