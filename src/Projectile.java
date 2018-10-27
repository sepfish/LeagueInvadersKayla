import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	int speed = 10;

	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	void draw(Graphics g) {
		g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
		}
	
	void update() {
		super.update();
		if (y < 0) {
			isAlive = false;
		}
		y = y - speed;
	}
	
	
}


