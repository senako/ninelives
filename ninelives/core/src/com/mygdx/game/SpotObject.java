package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class SpotObject extends ApplicationAdapter {

    SpriteBatch batch;
    Texture mouse;
    Texture treat;
    Texture bowl;

    @Override
    public void create () {
        batch = new SpriteBatch();
        mouse = new Texture("MouseSprite.png");
        treat = new Texture("treat.png");
        bowl = new Texture("bowl.png");

    }

    @Override
    public void render () {
        ScreenUtils.clear(0, 0, 0, 1);
        batch.begin();
        batch.draw(mouse, 0, 0);
        batch.draw(treat, 300, 300);
        batch.draw(bowl, 150, 150);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        mouse.dispose();
        treat.dispose();
        bowl.dispose();
    }
}
