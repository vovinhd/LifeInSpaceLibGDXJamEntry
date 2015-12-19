package com.github.vovinhd.lis.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.github.vovinhd.lis.Controller.CameraController;

/**
 * Created by vovin on 19/12/2015.
 */
public class GameScreen implements Screen {

    TiledMap tiledMap;
    IsometricTiledMapRenderer mapRenderer;

    OrthographicCamera camera;


    @Override
    public void show() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1280, 720);
        camera.update();
        tiledMap = new TmxMapLoader().load("an_excellent_test.tmx");
        mapRenderer = new IsometricTiledMapRenderer(tiledMap, 1f);
        CameraInputController cameraController = new CameraInputController(camera);
        cameraController.rotateButton = 666;
        cameraController.translateButton = Input.Buttons.LEFT;
        cameraController.translateUnits = 1000;
        Gdx.input.setInputProcessor(cameraController);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        mapRenderer.setView(camera);
        mapRenderer.render();
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
        tiledMap.dispose();
        mapRenderer.dispose();
    }
}
