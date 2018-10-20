import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	void update() {
		for (int i = 0; i < 100000; i++) {
			if (i % 2 == 0) {
				x -= 1;
				y += 5;
				System.out.println("left");
			}
			if (i % 2 == 1) {
				x += 1;
				y += 5;
				System.out.println("right");
			}
			
		}
		
	}
	
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
	    g.fillRect(x, y, width, height);
	}

}
