import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer timer;
	Font titleFont;
	Font smallerFont;
	Rocketship rocket;
	GameObject gameObject;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	ObjectManager obj;
	
	GamePanel(){
		timer = new Timer(1000/60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		smallerFont = new Font("Arial", Font.PLAIN, 24);
		rocket = new Rocketship(250, 700, 50, 50);
		obj = new ObjectManager(rocket);
	}

	void startGame() {
		timer.start();
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		obj.draw(g);
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.YELLOW);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 15, 200);
		g.setFont(smallerFont);
		g.drawString("Press ENTER to start", 110, 400);
		g.drawString("Press SPACE for instructions", 75, 575);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 125, 200);
		g.setFont(smallerFont);
		g.drawString("You killed - enemies", 140, 400);
		g.drawString("Press ENTER to restart", 120, 575);
	}
	
	void updateGameState() {
		obj.update();
		obj.manageEnemies();
	}
	
	void updateMenuState() {
		
	}
	
	void updateEndState() {
		
	}
	
	public void paintComponent(Graphics g){
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else
		if (currentState == GAME_STATE) {
			drawGameState(g);
		} else
		if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else
		if (currentState == GAME_STATE) {
			updateGameState();
		} else
		if (currentState == END_STATE) {
			updateEndState();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (currentState == 2) {
					currentState = MENU_STATE;
				} else {
					currentState++;
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				rocket.movingState = "up";
			} else
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				rocket.movingState = "down";
			} else
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				rocket.movingState = "left";
			} else
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				rocket.movingState = "right";
			}
			
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				
				obj.addProjectile(new Projectile(rocket.x + 20, rocket.y + 20, 10, 10));
			}
			
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP || code == KeyEvent.VK_DOWN ||code == KeyEvent.VK_LEFT || code == KeyEvent.VK_RIGHT) {
			rocket.movingState = "";
		}
	}
}
