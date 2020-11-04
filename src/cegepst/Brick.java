package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.CollidableRepository;
import cegepst.engine.entity.StaticEntity;

import java.awt.*;

public class Brick extends StaticEntity {

    public Brick(int x, int y) {
        super.setDimension(16, 16);
        super.teleport(x, y);
        CollidableRepository.getInstance().registerEntity(this);
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.white);
    }
}
