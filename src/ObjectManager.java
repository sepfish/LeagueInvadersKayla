import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime;
	
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
	

	public void manageEnemies(){
        if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
                addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));
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
