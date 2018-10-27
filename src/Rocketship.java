import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	
	int speed;
	String movingState = "";
	
	void update() {
		super.update();
		if (movingState.equals("up")){
			up();
		} else
		if (movingState.equals("down")){
			down();
		} else
		if (movingState.equals("left")){
			left();
		} else
		if (movingState.equals("right")){
			right();
		}
	}
	
	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}

	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		// TODO Auto-generated constructor stub
	}
	
	void up() {
		if (y > 0) {
			y = y - speed;
		}
	}
	
	void down() {
		if (y < 750) {
		y = y + speed;
		} else {
			y = 750;
		}
	}
	
	void left() {
		if (x > 0) {
			x = x - speed;
		}
	}
	
	void right() {
		if (x < 450) {
		x = x + speed;
		} else {
			x = 450;
		}
	}

}
