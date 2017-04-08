package edu.ci.scenes;

import edu.ci.Game;
import edu.ci.engine.LeaderboardManager;
import edu.ci.engine.Engine;
import edu.ci.engine.Renderer;
import java.awt.*;
import java.awt.event.KeyEvent;

public class LeaderboardScene implements IGameScene
{
    @Override
    public void onStart() {
        background = Engine.getResourceManager().loadImage("leaderboard_background.png");
        leaderboardManager = new LeaderboardManager();
    }

    @Override
    public void onUpdate(double deltaTime) {
        if(Engine.getInputHandler().isKeyPressedOnce(KeyEvent.VK_ESCAPE))
            Game.getSceneManager().popScene();
    }

    @Override
    public void onRender(Renderer r)
    {
        r.renderSprite(background, new Point(0, 0));

        int y = 400, pos = 1;
        for(LeaderboardManager.Entry entry : leaderboardManager.getEntries()) {
            r.renderText(String.valueOf(pos) + ". " + entry.getName(), new Point(550, y), 64, Color.white);
            r.renderText(String.valueOf(entry.getScore()), new Point(1200, y), 64, Color.white);
            y += 100;
            pos++;
        }
    }

    @Override
    public void onClose() {

    }

    private Image background;
    private LeaderboardManager leaderboardManager;
}
