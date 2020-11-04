package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.controls.MovementController;
import cegepst.engine.entity.ControllableEntity;

import java.awt.*;

public class Tank extends ControllableEntity {

    private int cooldown = 0;

    public Tank(MovementController controller) {
        super(controller);
        super.setDimension(30, 30);
        super.setSpeed(2);
        super.teleport(100, 100);
    }

    public Missile fire() {
        cooldown = 50;
        return new Missile(this);
    }

    public boolean canFire() {
        return cooldown == 0;
    }

    @Override
    public void update() {
        super.update();
        moveAccordingToHandler();
        cooldown--;
        if (cooldown <= 0) {
            cooldown = 0;
        }
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.GREEN);
        if (hasMoved()) {
            drawHitBox(buffer);
        }
    }
}
