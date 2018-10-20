import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	
	int speed;
	String movingState = "";
	
	void update() {
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
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);

	}
	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 5;
		// TODO Auto-generated constructor stub
	}
	
	void up() {
		y = y - speed;
	}
	
	void down() {
		y = y + speed;
	}
	
	void left() {
		x = x - speed;
	}
	
	void right() {
		x = x + speed;
	}

}
