package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SimpleButton extends Actor {

    private Sprite skin;


    public SimpleButton(Texture texture, float x, float y, float width, float height) {
        skin = new Sprite(texture); // your image
        skin.setPosition(x, y);
        skin.setSize(width, height);
    }

    public void draw(SpriteBatch batch) {
        skin.draw(batch); // draw the button
    }

    public void update (SpriteBatch batch, float input_x, float input_y, Game game, Screen screen) {
        checkIfClicked(input_x, input_y, game, screen);
    }

    private void checkIfClicked (float ix, float iy, Game game, Screen screen) {
        if (ix > skin.getX() && ix < skin.getX() + skin.getWidth()) {
            if (iy > skin.getY() && iy < skin.getY() + skin.getHeight()) {
                ((Game) Gdx.app.getApplicationListener()).setScreen((Screen) new FirstPuzzleScreen(game));
                game.setScreen(screen);
                System.out.println("Button Pressed!");
            }
        }
    }

}
