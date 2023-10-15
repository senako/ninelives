package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class EndScreen implements Screen {
    private Game game;
    Stage stage;
    SpriteBatch batch;
    Texture firstScreen;

    public EndScreen(Game game) {
        this.game = game;
        batch = new SpriteBatch();
        firstScreen = new Texture("endScreen.png");
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {

        batch.begin();
        batch.draw(firstScreen, 0, 0);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
