package edu.ci.scenes;

import edu.ci.Game;
import edu.ci.engine.Engine;
import edu.ci.engine.Renderer;
import edu.ci.gui.ListMenu;

import javax.sound.sampled.Clip;
import java.awt.*;

public class MainMenuScene implements IGameScene
{
    @Override
    public void onStart()
    {
        ListMenu.OptionInfo[] info =
                {new ListMenu.OptionInfo("Play", (Void) -> Game.getSceneManager().changeToScene(new GameplayScene())),
                  new ListMenu.OptionInfo("Leaderboard", (Void) -> Game.getSceneManager().pushScene(new LeaderboardScene())),
                  new ListMenu.OptionInfo("How to play", (Void) -> Game.getSceneManager().pushScene(new HowToPlayScene())),
                  new ListMenu.OptionInfo("Exit", (Void) -> System.exit(0))
                };

        menu = new ListMenu(new Point(165, 300), info);

        background = Engine.getResourceManager().loadImage("menu_background.png");

        Clip music = Engine.getResourceManager().loadSound("gameplay_background.wav");
        Engine.getAudioPlayer().playInBackground(music);
    }

    @Override
    public void onUpdate(double deltaTime)
    {
        menu.update();
    }

    @Override
    public void onRender(Renderer r)
    {
        r.renderSprite(background, new Point(0, 0), new Dimension(1920, 1080));
        menu.render(r);
    }

    @Override
    public void onClose()
    {
        Engine.getResourceManager().freeResource("menu_background.png");
    }

    private Image           background;
    private ListMenu        menu;
}
