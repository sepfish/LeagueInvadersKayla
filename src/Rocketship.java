import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	
	int speed;
	
	void update() {
		
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

}
