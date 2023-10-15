package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    private int x;
    private int y;

    public SpeedDating() {
        batch = new SpriteBatch();
        cat1 = new Texture("bowl.png");
        cat2 = new Texture("MouseSprite.png");
        olive = new Texture("oliveCat.png");
        background = new Texture("heart.png");
        cloud = new Texture("cloud.png");
        font = new BitmapFont();
        msg1 = new BitmapFont();
        msg2 = new BitmapFont();
        msg3 = new BitmapFont();


        cat11 = new SimpleButton(cat1, 0, 0, 80, 80);
        cat22 = new SimpleButton(cat2, 200, 0, 80, 80);
        oliveOlive = new SimpleButton(olive, 400, 0, 80, 80);
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
    }

    public void chooseLove(int x, int y) {
        if (cat11.isClicked(x,y)) {
            msg1.draw(batch, "It's not true love :(", 95, 420);
        } else if (cat22.isClicked(x,y)) {
            msg2.draw(batch, "She dumped you </3", 95, 420);
        } else if (oliveOlive.isClicked(x,y)) {
            msg3.draw(batch, "It's true love!! :3 <3", 95, 420);
            startTimer();

            // PUT SWITCH TO NEXT SCREEN HERE
        }

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            x = Gdx.input.getX();
            y = Gdx.input.getY();
        }

        batch.begin();

        chooseLove(x, y);

        batch.draw(background, 0, 0);
        batch.draw(cloud, 0, 200);
        font.draw(batch, "Speed Dating! Find your love!", 63, 420);
        font.draw(batch, "Try not to get your heart broken", 58, 398);
        cat11.draw(batch);
        cat22.draw(batch);
        oliveOlive.draw(batch);
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
        cat1.dispose();
        cat2.dispose();
        olive.dispose();
        background.dispose();
        cloud.dispose();
        font.dispose();
    }
}
