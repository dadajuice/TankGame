package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.controls.MovementController;
import cegepst.engine.entity.ControllableEntity;

import java.awt.*;

public class Tank extends ControllableEntity {

    public Tank(MovementController controller) {
        super(controller);
        super.setDimension(30, 30);
        super.setSpeed(2);
        super.teleport(100, 100);
    }

    @Override
    public void update() {
        moveAccordingToHandler();
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.RED);
    }
}
