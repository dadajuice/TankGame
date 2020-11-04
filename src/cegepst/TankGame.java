package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.CollidableRepository;
import cegepst.engine.Game;
import cegepst.engine.entity.StaticEntity;

import java.util.ArrayList;

public class TankGame extends Game {

    private Tank tank;
    private GamePad gamePad;
    private ArrayList<Brick> bricks;
    private ArrayList<Missile> missiles;

    public TankGame() {
        bricks = new ArrayList<>();
        missiles = new ArrayList<>();
        gamePad = new GamePad();
        tank = new Tank(gamePad);
        bricks.add(new Brick(500, 100));
        bricks.add(new Brick(500, 116));
    }

    @Override
    public void initialize() {

    }

    @Override
    public void conclude() {

    }

    @Override
    public void update() {
        tank.update();
        for (Missile missile : missiles) {
            missile.update();
        }
        if (gamePad.isQuitPressed()) {
            super.stop();
        }
        if (gamePad.isFirePressed() && tank.canFire()) {
            missiles.add(tank.fire());
        }
    }

    @Override
    public void draw(Buffer buffer) {
        for (Brick brick : bricks) {
            brick.draw(buffer);
        }
        for (Missile missile : missiles) {
            missile.draw(buffer);
        }
        tank.draw(buffer);
    }
}
