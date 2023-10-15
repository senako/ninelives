package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class TextScreen1 implements Screen {
    Texture nextButton;

    Texture backgroundImg;

    private Stage stage;

    private Game game;

    Screen nextScreen;

    SpriteBatch batch;

    BitmapFont text;

    public TextScreen1(final Game game) {
        this.game = game;
        stage = new Stage();
        batch = new SpriteBatch();
        nextScreen = new EndScreen(game);

        nextButton = new Texture("startButton.png"); //REPLACE WITH NEXT BUTTON
        SimpleButton nxtButton = new SimpleButton(nextButton, 50, 50, game);
        text = new BitmapFont();
        nxtButton.addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent event, float x, float y) {
               game.setScreen(nextScreen);
           }
        });

        stage.addActor(nxtButton);

        backgroundImg = new Texture("startScreen.png"); //REPLACE IMAGE WITH BACKGROUND !!
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));

        batch.begin();
        batch.draw(backgroundImg, 0, 0);
        text.draw(batch, "TEXT HERE!!!", 400, 400);
        batch.end();

        stage.draw();
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
        backgroundImg.dispose();
        stage.dispose();
        batch.dispose();
    }

}
