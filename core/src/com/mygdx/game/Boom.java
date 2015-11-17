package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Ariana on 11/14/2015.
 */

public class Boom extends ApplicationAdapter {
	SpriteBatch batch;
	TextureAtlas taBoom;
	Sprite[] sprBomb;
	int i = 0;
	Animation animBoom;
	TextureRegion currentFrame;
	TextureRegion[] atrBoom;
	Sprite sprBoom, spExp;
	float stateTime;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		taBoom = new TextureAtlas(Gdx.files.internal("Explosion.txt"));
		sprBomb = new Sprite[11];
		atrBoom = new TextureRegion[11];

		for (int j = 0; j < 11; j++) {
			atrBoom[j] = taBoom.findRegion("EXP" + (j+1));
		}
		animBoom = new Animation(0.05f, atrBoom);
	}

	@Override
	public void render () {
//		spExp = new Sprite(currentFrame);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = animBoom.getKeyFrame(stateTime, true);
//		spExp.setX(Gdx.graphics.getWidth() / 2);
		batch.begin();
		batch.draw(currentFrame, 100, 100);
		batch.end();

	}
}
