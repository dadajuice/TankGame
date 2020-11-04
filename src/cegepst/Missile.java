package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.CollidableRepository;
import cegepst.engine.controls.Direction;
import cegepst.engine.entity.MovableEntity;

import java.awt.*;

public class Missile extends MovableEntity {

    private final Direction tankDirection;

    public Missile(Tank tank) {
        super.setSpeed(5);
        tankDirection = tank.getDirection();
        if (tankDirection == Direction.RIGHT) {
            super.teleport(tank.getX() + tank.getWidth() + 1,
                    tank.getY() + 15 - 2);
            super.setDimension(8, 4);
        } else if (tankDirection == Direction.LEFT) {
            super.teleport(tank.getX() - 9,
                    tank.getY() + 15 - 2);
            super.setDimension(8, 4);
        } else if (tankDirection == Direction.DOWN) {
            super.teleport(tank.getX() + 15 - 2,
                    tank.getY() + tank.getHeight() + 1);
            super.setDimension(4, 8);
        } else if (tankDirection == Direction.UP) {
            super.teleport(tank.getX() + 15 - 2,
                    tank.getY() - 9);
            super.setDimension(4, 8);
        }
        CollidableRepository.getInstance().registerEntity(this);
    }

    @Override
    public void update() {
        super.update();
        super.move(tankDirection);
        /*if (x >= 820) {
            x = -20;
        }
        if (y >= 620) {
            y = -20;
        }*/
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.YELLOW);
    }
}
