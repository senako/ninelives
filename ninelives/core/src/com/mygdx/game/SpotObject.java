package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpotObject implements Screen {

    public Game game;

    SpriteBatch batch;
    Sprite cat;
    Sprite treat, bowl, mouse;
    List<Sprite> sprites = new ArrayList<Sprite>();
    Texture wallpaper;
    Texture cloud;
    BitmapFont font;
    float charPosX;
    float charPosY;
    float charSpeed = 100.0f;
    int count = 0;
    Screen nextScreen;

    public SpotObject(Game game) {
        this.game = game;
        batch = new SpriteBatch();
        nextScreen = new SpeedDating(game);

        wallpaper = new Texture("wallpaper.png");
        cloud = new Texture("cloud.png");

        Texture mouseTmp = new Texture("MouseSprite.png");
        Texture treatTmp = new Texture("treat.png");
        Texture bowlTmp = new Texture("bowl.png");
        Texture tmp = new Texture("pintoCat.png");

        cat = new Sprite(tmp);
        mouse = new Sprite(mouseTmp);
        mouse.setPosition(310, 40);
        treat = new Sprite(treatTmp);
        treat.setPosition(220, 155);
        bowl = new Sprite(bowlTmp);
        bowl.setPosition(430, 120);

        sprites.add(mouse);
        sprites.add(treat);
        sprites.add(bowl);

        font = new BitmapFont();
    }

    public void spriteCollision(Sprite player, List<Sprite> spriteList) {
        Rectangle playerRectangle = new Rectangle(charPosX, charPosY, 10, 10);

        Iterator<Sprite> iterator = spriteList.iterator();
        while (iterator.hasNext()) {
            Sprite sprite = iterator.next();
            Rectangle objectRectangle = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

            if (objectRectangle.overlaps(playerRectangle)) {
                sprite.getTexture().dispose();
                iterator.remove();
                sprites.remove(sprite);
                spriteList.remove(sprite);
                count++;
            }
        }
    }

    public void movePlayer() {
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
            charPosX -= Gdx.graphics.getDeltaTime() * charSpeed;
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
            charPosX += Gdx.graphics.getDeltaTime() * charSpeed;
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP))
            charPosY += Gdx.graphics.getDeltaTime() * charSpeed;
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN))
            charPosY -= Gdx.graphics.getDeltaTime() * charSpeed;
    }

    public void drawSprites(List<Sprite> sprites) {
        for (Sprite sprite : sprites) {
            sprite.draw(batch);
        }
    }

    public void detectEndGame() {
        if (sprites.isEmpty()) {
            game.setScreen(nextScreen);
        }
    }

    @Override
    public void render (float delta) {

        movePlayer();

        spriteCollision(cat, sprites);

        batch.begin();
        batch.draw(wallpaper, 0, 0);
        batch.draw(cloud, 0, 200);
        font.draw(batch, "Help us find Kitty's", 95, 420);
        font.draw(batch, " missing items!", 105, 398);
        batch.draw(cat, charPosX, charPosY);
        drawSprites(sprites);
        batch.end();

        detectEndGame();
    }

    @Override
    public void show() {

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
    public void dispose () {
        batch.dispose();
        cloud.dispose();
        cat.getTexture().dispose();
        wallpaper.dispose();
        font.dispose();
    }

}
