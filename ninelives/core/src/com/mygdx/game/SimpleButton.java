package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SimpleButton extends Actor {

    Texture buttonTexture;
    boolean isPressed;
    float posX;
    float posY;

    public SimpleButton(Texture buttonTexture, float x, float y, Game game) {
        this.buttonTexture = buttonTexture;
        this.posX = x;
        this.posY = y;
        setBounds(posX, posY, buttonTexture.getWidth(), buttonTexture.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(buttonTexture, posX, posY, buttonTexture.getWidth(), buttonTexture.getHeight());
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        System.out.println("Button Coordinates: " + x + ", " + y);
        // Define the clickable area
        return touchable && x >= 0 && x < getWidth() && y >= 0 && y < getHeight() ? this : null;

    }

    public boolean isPressed() {
        return isPressed;
    }


}
