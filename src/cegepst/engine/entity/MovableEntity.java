package cegepst.engine.entity;

import cegepst.engine.controls.Direction;

import java.awt.*;

public abstract class MovableEntity extends UpdatableEntity {

    private Collision collision;
    private Direction direction = Direction.UP;
    private int speed = 1;
    private boolean moved;
    private int lastX;
    private int lastY;

    public MovableEntity() {
        collision = new Collision(this);
    }

    public boolean hasMoved() {
        return moved;
    }

    public void moveLeft() {
        move(Direction.LEFT);
    }

    public void moveRight() {
        move(Direction.RIGHT);
    }

    public void moveUp() {
        move(Direction.UP);
    }

    public void moveDown() {
        move(Direction.DOWN);
    }

    public void move(Direction direction) {
        this.direction = direction;
        int allowedDistance = collision.getAllowedSpeed(direction);
        x += direction.getVelocityX(allowedDistance);
        y += direction.getVelocityY(allowedDistance);
        if (x != lastX || y != lastY) {
            moved = true;
        }
        lastX = x;
        lastY = y;
    }

    protected Rectangle getHitBox() {
        switch (direction) {
            case UP: return getUpperHitBox();
            case DOWN: return getLowerHitBox();
            case LEFT: return getLeftHitBox();
            case RIGHT: return getRightHitBox();
            default: return getBounds();
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean hitBoxIntersectWith(StaticEntity other) {
        if (other == null) {
            return false;
        }
        return getHitBox().intersects(other.getBounds());
    }

    private Rectangle getUpperHitBox() {
        return new Rectangle(x, y - speed, width, speed);
    }

    private Rectangle getLowerHitBox() {
        return new Rectangle(x, y + height, width, speed);
    }

    private Rectangle getLeftHitBox() {
        return new Rectangle(x - speed, y, speed, height);
    }

    private Rectangle getRightHitBox() {
        return new Rectangle(x + width, y, speed, height);
    }
}
