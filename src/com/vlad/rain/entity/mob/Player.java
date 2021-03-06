package com.vlad.rain.entity.mob;

import com.vlad.rain.graphics.Screen;
import com.vlad.rain.graphics.Sprite;
import com.vlad.rain.input.Key;

public class Player extends Mob{

	private Key input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	
	
	public Player(Key input) {
		this.input = input;
	}
	
	public Player(int x, int y, Key input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public int getXPosition(){
		return this.x;
	}
	
	public int getYPosition(){
		return this.y;
	}
	
	public void update() {
		int xa = 0, ya = 0;
		
		if (anim < 7500) anim++; 
			else anim = 0;
		
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		}
		else walking = false;
	}
	
	public void render(Screen screen) {
		if(dir == 0) {
			sprite = Sprite.player_forward;
			if (walking)
				if (anim % 20 > 10)
					sprite = Sprite.player_forward1;
				else sprite = Sprite.player_forward2;
		}
		
		if(dir == 1) {
			sprite = Sprite.player_right;
			if (walking)
				if (anim % 20 > 10)
					sprite = Sprite.player_right1;
				else sprite = Sprite.player_right2;
		}
		
		if(dir == 2) {
			sprite = Sprite.player_back;
			if (walking)
				if (anim % 20 > 10)
					sprite = Sprite.player_back1;
				else sprite = Sprite.player_back2;
		}
		
		if(dir == 3) {
			sprite = Sprite.player_left;
			if (walking)
				if (anim % 20 > 10)
					sprite = Sprite.player_left1;
				else sprite = Sprite.player_left2;
		}
		
		screen.renderPlayer(x, y, sprite);
	}
	
	
}
