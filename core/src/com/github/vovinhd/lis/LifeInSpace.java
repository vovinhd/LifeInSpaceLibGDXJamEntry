package com.github.vovinhd.lis;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.vovinhd.lis.Screens.GameScreen;

public class LifeInSpace extends Game {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		this.setScreen(new GameScreen());
	}

}
