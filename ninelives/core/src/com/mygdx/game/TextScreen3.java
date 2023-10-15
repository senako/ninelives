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

public class TextScreen3 implements Screen {
    Texture nextButton;

    Texture backgroundImg;

    private Stage stage;

    private Game game;

    Screen nextScreen;

    SpriteBatch batch;

    BitmapFont text;

    public TextScreen3(final Game game) {
        this.game = game;
        stage = new Stage();
        batch = new SpriteBatch();
        nextScreen = new SpeedDating(game);

        nextButton = new Texture("nextButton.png"); //REPLACE WITH NEXT BUTTON
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
        text.draw(batch, "Pinto, ever the adventurous spirit, found himself\n" +
                "in a rather peculiar situation one afternoon. \n" +
                "Intrigued by tales of feline speed dating, he decided \n" +
                "to give it a try, hoping to find a companion who \n" +
                "matched his boundless enthusiasm. The event featured \n" +
                "two lovely cats, each with their own charm, but as \n" +
                "Pinto engaged in conversation, he couldn't help but \n" +
                "feel that something was missing. None could \n" +
                "capture his heart like Olive. With her playful \n" +
                "spirit, intelligence, and shared love for life's \n" +
                "little wonders, Olive was the one who truly understood \n" +
                "him. As the event drew to a close, Pinto's eyes met \n" +
                "Olive's, and in that moment, they knew \n" +
                "they were meant to be. stronger \n" +
                "with each passing day.", 10, 590);
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
