import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime = 400;
	int score = 0;
	
	ObjectManager(Rocketship r){
		this.rocket = r;
	}
	
	void update() {
		rocket.update();
		for (Projectile p: projectiles) {
			p.update();
		}
		for (Alien a: aliens) {
			a.update();
		}
	}
	
	int getScore() {
		return score;
	}
	
	void draw(Graphics g) {
		rocket.draw(g);
		for (Projectile p: projectiles) {
			p.draw(g);
		}
		for (Alien a: aliens) {
			a.draw(g);
		}
	}
	
	void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	
	void addAlien(Alien a) {
		aliens.add(a);
	}
	
	void checkCollision() {
		for (Alien a : aliens) {
			if (rocket.collisionBox.intersects(a.collisionBox)){
                rocket.isAlive = false;
			}
		for (int i = 0; i < projectiles.size(); i++) {
				if(a.collisionBox.intersects(projectiles.get(i).collisionBox)) {
					projectiles.get(i).isAlive = false;
					a.isAlive = false;
					score++;
				}
			}
		}
	}



	public void manageEnemies(){
        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
                addAlien(new Alien(new Random().nextInt(LeagueInvaders.width - 50), 0, 50, 50));
                enemyTimer = System.currentTimeMillis();
        	}
	}
	
	void purgeObjects() {
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isAlive == false) {
				projectiles.remove(projectiles.get(i));
			}
		}
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isAlive == false) {
				aliens.remove(aliens.get(i));
			}
		}

	}
}
