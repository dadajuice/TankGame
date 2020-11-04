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
        bricks.add(new Brick(500, 132));
        bricks.add(new Brick(484, 148));
        bricks.add(new Brick(500, 164));
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
        if (gamePad.isQuitPressed()) {
            super.stop();
        }
        if (gamePad.isFirePressed() && tank.canFire()) {
            missiles.add(tank.fire());
        }

        ArrayList<StaticEntity> killedElements = new ArrayList<>();
        for (Missile missile : missiles) {
            missile.update();
            for (Brick brick : bricks) {
                if (missile.hitBoxIntersectWith(brick)) {
                    killedElements.add(brick);
                    killedElements.add(missile);
                }
            }
        }
        for (StaticEntity killedElement : killedElements) {
            if (killedElement instanceof Brick) {
                bricks.remove(killedElement);
            } else if (killedElement instanceof Missile) {
                missiles.remove(killedElement);
            }
            CollidableRepository.getInstance().unregisterEntity(killedElement);
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
