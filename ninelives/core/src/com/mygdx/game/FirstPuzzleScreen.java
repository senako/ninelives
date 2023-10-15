package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
public class FirstPuzzleScreen extends ScreenAdapter {
    private Game game;
    Stage stage;
    SpriteBatch batch;
    Texture firstScreen;

    public FirstPuzzleScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        System.out.println("HIIII!!");
        stage = new Stage();
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
        firstScreen = new Texture("firstScreen.png");
    }

    @Override
    public void render(float delta) {
        System.out.println("HERE WE ARE!!!");
        stage.act();


        batch.begin();
            batch.draw(firstScreen, 20, 20);
            System.out.println("Here we are!");
        batch.end();

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        firstScreen.dispose();
    }
}
