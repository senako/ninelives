package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class TextScreen4 implements Screen {
    Texture nextButton;

    Texture backgroundImg;

    private Stage stage;

    private Game game;

    Screen nextScreen;

    SpriteBatch batch;

    BitmapFont text;

    public TextScreen4(final Game game) {
        this.game = game;
        stage = new Stage();
        batch = new SpriteBatch();
        nextScreen = new EndScreen(game);

        nextButton = new Texture("nextButton.png");
        SimpleButton nxtButton = new SimpleButton(nextButton, 500, 50, game);
        text = new BitmapFont();
        text.setColor(Color.BLACK);
        text.getData().setScale(2,2);
        nxtButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(nextScreen);
            }
        });

        Gdx.input.setInputProcessor(stage);

        stage.addActor(nxtButton);

        backgroundImg = new Texture("textWallpaper.png"); //REPLACE IMAGE WITH BACKGROUND !!
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.input.setInputProcessor(stage);

        Gdx.gl.glClearColor(0, 0, 0, 1);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));

        batch.begin();
        batch.draw(backgroundImg, 0, 0);
        text.draw(batch, "As the years passed, Pinto and Olive explored the \n" +
                "world together, finding joy in every sunbeam and \n" +
                "secret hideaway. Yet, fate can be both beautiful \n" +
                "and cruel. One fateful day, an unfortunate \n" +
                "accident took Olive away, leaving Pinto heartbroken. \n" +
                "Pinto found himself drawn to a dusty old box tucked \n" +
                "away in a corner. Inside, he uncovered a letter, \n" +
                "penned in Olive's elegant script.  They were her \n" +
                "unspoken wedding vows, a treasure she had secretly \n" +
                "held onto, hoping for a day when they could be spoken \n" +
                "aloud. She declared her eternal love for Pinto, \n" +
                "promising to be by his side through every life \n" +
                "she would live. In that moment, he \n" +
                "knew that although Olive was no longer \n" +
                "physically present, her spirit and \n" +
                "love would forever be a part of him.", 10, 590);
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
