package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteTouchable extends Sprite {

    public SpriteTouchable(Texture texture) {
        super(texture);
    }

    public SpriteTouchable(Sprite sprite) {
        set(sprite);
    }

    public static float xTrans(float x)
    {
        return x* Gdx.graphics.getWidth()/480;
    }

    public static float yTrans(float y)
    {
        return y*Gdx.graphics.getHeight()/320;
    }

    private boolean isTouched;

    /**
     * Type: Input Listener function
     * listen if this sprite button was pressed (touched)
     * @param marge : the extra touchable space out of sprite
     * @param x     : x position touched by user
     * @param y     : y position touched by user
     *
     * return true  : Sprite touched
     * return false : Sprite not touched
     */
    public boolean isPressing(int marge,int x, int y) {
        if((x>getX() -xTrans(marge))&& x<getX() +getWidth()+xTrans(marge)) {
            if((y>getY() -yTrans(marge))&& y<getY()+getHeight()+yTrans(marge)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTouched() {
        return isTouched;
    }
}
/**
 * Use:
 * Gdx.input.setInputProcessor(new GameInputListener() {
 *
 *             @Override
 *             public boolean touchUp(int screenX, int screenY, int pointer, int button) {
 *
 *                 return false;
 *             }
 *
 *             @Override
 *             public boolean touchDown(int x, int yy, int pointer, int button) {
 *                 int y = Gdx.graphics.getHeight() - yy;
 *                 // if sprite + 10 of px marge is touched
 *                 if(mySpriteTouchable.isPressing(10, x, y)) {
 *                     // sprite is touched down
 *                 }
 *                 return false;
 *             }
 * }
 */
