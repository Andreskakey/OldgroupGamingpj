package edu.ci.ecs.systems;

import edu.ci.ecs.*;
import edu.ci.ecs.components.MovementComponent;
import edu.ci.ecs.components.SpriteComponent;
import edu.ci.ecs.components.TransformComponent;
import edu.ci.engine.Engine;
import edu.ci.engine.InputHandler;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;

public class InputSystem implements System
{
    public InputSystem(Spawner spawner)
    {
        this.shootInterval = 0.5;
        this.timer = 5.0;
        this.spawner = spawner;
        this.shootSound = Engine.getResourceManager().loadSound("shoot.wav");
    }

    @Override
    public void update(double dt, GameObject object)
    {
        TransformComponent tc = object.getComponent(TransformComponent.class);
        MovementComponent mc = object.getComponent(MovementComponent.class);
        SpriteComponent sc = object.getComponent(SpriteComponent.class);

        if(tc != null && mc != null && object.getType() == GameObjectType.Player)
        {
            timer += dt;

            InputHandler input = Engine.getInputHandler();

            if(input.isKeyPressedOnce(KeyEvent.VK_RIGHT))
                mc.changeVelocity(new Point(400, 0));

            if(input.isKeyPressedOnce(KeyEvent.VK_LEFT))
                mc.changeVelocity(new Point(-400, 0));

            if(input.isKeyReleased(KeyEvent.VK_LEFT) || input.isKeyReleased(KeyEvent.VK_RIGHT))
                mc.changeVelocity(new Point(0, 0));

            if(input.isKeyPressedOnce(KeyEvent.VK_UP) && timer >= shootInterval) {
                spawner.spawnBullet(object, new Point(0, -800));
                Engine.getAudioPlayer().playOnce(shootSound);
                timer = 0.0;
            }
        }
    }

    double      shootInterval;
    double      timer;
    Spawner     spawner;
    Clip        shootSound;
}
