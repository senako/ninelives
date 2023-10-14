package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import sun.java2d.pipe.SpanShapeRenderer;

public class MyGame extends Game {
	SpriteBatch batch;
	Texture backgroundImg;
	Texture buttonImg;
	Stage stage;
	private Game game;
	float inputX;
	float inputY;

	Screen nextScreen;

	SimpleButton button;

	public MyGame() {
		game = this;
	}

	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		batch = new SpriteBatch();
		Gdx.input.setInputProcessor(stage);

		backgroundImg = new Texture("startScreen.png");
		buttonImg = new Texture("startButton.png");
		nextScreen = new FirstPuzzleScreen(game);

		button = new SimpleButton(buttonImg, 400, 400, 200, 80);
		stage.addActor(button);
	}

	@Override
	public void render () {

		super.render();
		stage.act(Gdx.graphics.getDeltaTime());

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(backgroundImg, 20, 20);
		button.draw(batch);
		batch.end();

		stage.draw();


		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			inputX = Gdx.input.getX();
			inputY = Gdx.input.getY();
			button.update(batch, inputX, inputY, game, nextScreen);
			dispose();
			super.setScreen(nextScreen);

		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		backgroundImg.dispose();
		buttonImg.dispose();
		stage.dispose();
	}
}
