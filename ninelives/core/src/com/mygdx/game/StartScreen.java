package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import sun.java2d.pipe.SpanShapeRenderer;

public class StartScreen implements Screen {

    Texture startbtn;
    Texture backgroundImg;
    private Stage stage;
    private Game game;
    Screen nextScreen;
    SpriteBatch batch;

    public StartScreen(final Game game) {
        this.game = game;
        stage = new Stage();
        batch = new SpriteBatch();

        //making the start button
        startbtn = new Texture("startButton.png");
        nextScreen = new TextScreen1(game);
        SimpleButton startButton = new SimpleButton(startbtn, 300, 320, game);

        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(nextScreen);
            }
        });

        stage.addActor(startButton);

        backgroundImg = new Texture("startScreen.png");

        Gdx.input.setInputProcessor(stage);

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
        backgroundImg.dispose();
        stage.dispose();
        batch.dispose();
    }
}