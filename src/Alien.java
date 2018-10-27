import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
	int count = 0;

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	void update(){
		super.update();
				y = y + 5;
				if (count % 8 == 0 && count % 16 != 0) {
					x = x + 10;
				}
				if (count % 16 == 0) {
					x = x - 10;
				}
				count++;
				
	}
	
	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}

}
