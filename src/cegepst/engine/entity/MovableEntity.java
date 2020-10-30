package cegepst.engine.entity;

import cegepst.engine.controls.Direction;

public abstract class MovableEntity extends UpdatableEntity {

    private Direction direction = Direction.UP;
    private int speed = 1;

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
        x += direction.getVelocityX(speed);
        y += direction.getVelocityY(speed);
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
}
