package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class SpeedDating implements Screen {

    Texture cat1;
    Texture cat2;
    Texture olive;
    Texture background;
    Texture cloud;
    BitmapFont font;
    BitmapFont msg1;
    BitmapFont msg2;
    BitmapFont msg3;
    SimpleButton cat11;
    SimpleButton cat22;
    SimpleButton oliveOlive;
    SpriteBatch batch;
    Screen nextScreen;
    Stage stage;

    Game game;

    Boolean msg11 = false;

    Boolean msg22 = false;

    Boolean msg33 = false;
    private int x;
    private int y;

    Texture startbtn;

    public SpeedDating(Game game) {
        this.game = game;
        batch = new SpriteBatch();
        nextScreen = new FirstPuzzleScreen(game);
        stage = new Stage();

        cat1 = new Texture("oliveCat.png");
        cat2 = new Texture("oliveCat.png");
        olive = new Texture("oliveCat.png");
        background = new Texture("heart.jpg");
        cloud = new Texture("cloud.png");
        font = new BitmapFont();
        msg1 = new BitmapFont();
        msg2 = new BitmapFont();
        msg3 = new BitmapFont();


        cat11 = new SimpleButton(cat1, 50, 0, game);
        cat22 = new SimpleButton(cat2, 350, 0, game);
        oliveOlive = new SimpleButton(olive, 650, 0, game);


        cat11.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("HELLO!!!");
                msg11 = true;
                //msg1.draw(batch, "It's not true love :(", 95, 420);
            }
        });

        cat22.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                msg22 = true;
            }
        });

        oliveOlive.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                msg33 = true;
            }
        });

        stage.addActor(cat11);
        stage.addActor(cat22);
        stage.addActor(oliveOlive);

        Gdx.input.setInputProcessor(stage);

    }

    public void startTimer() {
        float delay = 5; // Delay in seconds

        // Schedule a task to be executed after the specified delay
        Timer.schedule(new Task() {
            @Override
            public void run() {
                // Code to be executed after the delay
                System.out.println("Timer finished!");
            }
        }, delay);

        game.setScreen(nextScreen);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        
        Gdx.input.setInputProcessor(stage);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));

        batch.begin();

            batch.draw(background, 0, 0);
            batch.draw(cloud, 0, 200);
            font.draw(batch, "Speed Dating! Find your love!", 63, 420);
            font.draw(batch, "Try not to get your heart broken", 58, 398);

            if (msg11) {
                msg1.draw(batch, "It's not true love :(", 95, 420);
                font.dispose();
            }

            if (msg22) {
                msg2.draw(batch, "She dumped you </3", 95, 420);
                font.dispose();
            }

            if (msg33) {
                msg2.draw(batch, "She dumped you </3", 95, 420);
                startTimer();
                font.dispose();
            }

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
        cat1.dispose();
        cat2.dispose();
        olive.dispose();
        background.dispose();
        cloud.dispose();
        font.dispose();
    }
}
