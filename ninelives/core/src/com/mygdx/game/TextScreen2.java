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

public class TextScreen2 implements Screen {
    Texture nextButton;

    Texture backgroundImg;

    private Stage stage;

    private Game game;

    Screen nextScreen;

    SpriteBatch batch;

    BitmapFont text;

    public TextScreen2(final Game game) {
        this.game = game;
        stage = new Stage();
        batch = new SpriteBatch();
        nextScreen = new PingPong(game);

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
        text.draw(batch, "In the vast expanse of space, Olive and Pinto found \n" +
                "themselves in a mesmerizing world of zero gravity, \n" +
                "surrounded by shimmering stars and celestial wonders. \n" +
                "With the weightlessness of space enhancing their agility, \n" +
                "they frolicked around a soft, unraveled ball of vibrant \n" +
                "yarn, which drifted in the vacuum. Olive expertly batted the \n" +
                "yarn, sending it floating and twirling through the cosmos, \n" +
                "creating beautiful yarn constellations. Pinto's energetic \n" +
                "leaps and twirls added an extra layer of excitement to \n" +
                "their celestial dance, as they chased the yarn through the \n" +
                "starry abyss. In that enchanting moment, Olive and Pinto \n" +
                "discovered that even in the boundless reaches of space, \n" +
                "the simplest of pleasures could lead to \n" +
                "adventures, and their friendship had\n" +
                "transcended the earthly realm.", 10, 590);
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
