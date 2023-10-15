package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PingPong implements Screen {

    int WIDTH, HEIGHT;
    ShapeRenderer sp;
    SpriteBatch batch;
    Rectangle upperLimit, lowerLimit, line;
    BitmapFont font;

    Ball ball;
    Paddle left, right;

    int leftScore;
    final int WINNING_SCORE = 3;
    Texture background;
    Texture pinto;
    Texture olive;

    Game game;
    Screen nextScreen;
    Stage stage;

    public PingPong(Game game) {
        this.game = game;
        nextScreen = new TextScreen3(game);
        stage = new Stage();

        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();

        background = new Texture("background_space.jpg");
        pinto = new Texture("pintoCat.png");
        olive = new Texture("oliveCat.png");

        sp = new ShapeRenderer();
        font = new BitmapFont();
        batch = new SpriteBatch();

        // Coordinates according to WIDTH and HEIGHT
        initializeObjects();

        // Parameters : Ball speed, Stick speed
        initializeSpeed(3, 5);

    }


    public void initializeObjects() {
        left = new Paddle(20, HEIGHT / 2 - 30, 5, 60);
        right = new Paddle(WIDTH - 20, 0, 5, HEIGHT);
        ball = new Ball(WIDTH / 2, HEIGHT / 2, 8, 8);
        upperLimit = new Rectangle(0, HEIGHT - 10, WIDTH, 5);
        lowerLimit = new Rectangle(0, 10, WIDTH, 5);
        line = new Rectangle(WIDTH / 2, 10, 2, HEIGHT - 20);
    }

    public void initializeSpeed(int ballspeed, int stick) {
        ball.initSpeed(ballspeed);
        left.initSpeed(stick);
        right.initSpeed(stick);
    }

    public void handleInput() {
        // Move the left paddle
        if (!left.isOverlappingWith(lowerLimit) && Gdx.input.isKeyPressed(Keys.DOWN))
            left.decreaseY(left.getSpeed());
        if (!left.isOverlappingWith(upperLimit) && Gdx.input.isKeyPressed(Keys.UP))
            left.increaseY(left.getSpeed());

        // Move the right paddle
        if (!right.isOverlappingWith(lowerLimit) && Gdx.input.isKeyPressed(Keys.DOWN))
            right.decreaseY(right.getSpeed());
        if (!right.isOverlappingWith(upperLimit) && Gdx.input.isKeyPressed(Keys.UP))
            right.increaseY(right.getSpeed());
    }


    public void logicUpdate() {
        if (ball.isOverlappingWith(upperLimit) || ball.isOverlappingWith(lowerLimit)) {
            ball.reverseY();
        }

        if (ball.isOverlappingWith(left) || ball.isOverlappingWith(right)) {
            ball.reverseX();
            if (ball.isOverlappingWith(left)) {
                leftScore++;
                if (leftScore >= WINNING_SCORE) {
                    // Left player wins
                    game.setScreen(nextScreen);
                }
            }

        }
        if (ball.getX() > WIDTH) {

            //leftScore++;
            if (leftScore >= WINNING_SCORE) {
                // Left player wins
                Gdx.app.exit(); // Terminate the game
            } else {
                ball.reset(WIDTH, HEIGHT, false);
            }


        }

        ball.logicUpdate(left, right);
    }

    public void draw() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background,0,0);
        batch.draw(olive, 20, 450);
        batch.draw(pinto, 650, 450);
        font.draw(batch, Integer.toString(leftScore), WIDTH / 2 - 50, HEIGHT / 2 + HEIGHT / 3);
        batch.end();

        sp.begin(ShapeType.Filled);
        sp.setColor(Color.LIGHT_GRAY);
        left.draw(sp);
        right.draw(sp);
        ball.draw(sp);
        sp.setColor(Color.WHITE);
        sp.rect(upperLimit.x, upperLimit.y, upperLimit.width, upperLimit.height);
        sp.rect(lowerLimit.x, lowerLimit.y, lowerLimit.width, lowerLimit.height);
        sp.setColor(Color.DARK_GRAY);
        sp.rect(line.x, line.y, line.width, line.height);
        sp.end();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.input.setInputProcessor(stage);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));

        handleInput();
        logicUpdate();
        draw();

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
        pinto.dispose();
        olive.dispose();
        background.dispose();
    }
}
