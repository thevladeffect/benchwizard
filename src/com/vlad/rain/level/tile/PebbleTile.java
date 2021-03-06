package com.vlad.rain.level.tile;

import com.vlad.rain.graphics.Screen;
import com.vlad.rain.graphics.Sprite;

public class PebbleTile extends Tile {

	public PebbleTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

	public boolean solid() {
		return true;
	}
}
