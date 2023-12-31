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
        nextScreen = new SpotObject(game);

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
        text.draw(batch, "Olive, a curious and playful tabby cat, found herself in\n" +
                " a bit of a predicament one sunny afternoon. Somehow, her \n" +
                "favorite treats, cherished mouse toy, and dainty food \n" +
                "bowl had vanished without a trace. Puzzled but undeterred,\n" +
                " Olive enlisted the help of her loyal friend Pinto, a \n" +
                "spunky little kitten with boundless energy and a heart \n" +
                "full of determination. With a sense of purpose, Pinto\n" +
                " embarked on a mission to search every nook and cranny\n" +
                " of their cozy home, determined to reunite Olive with her \n" +
                "beloved possessions. The two feline friends, with tails \n" +
                "held high and eyes gleaming with hope, set out on an\n" +
                " adventure that would surely bring them closer \n" +
                "together and lead them to delightful \n" +
                "discoveries along the way.", 10, 590);
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
