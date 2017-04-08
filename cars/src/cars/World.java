package cars;
import java.util.*;

/*
 *
 ** the World class 
 */

public class World {
	
/*
 * This part have the subclass of patrol car and Point2D
 *  in which can be consider  an inheritance 
 *  Also contains the arrow size and the random variable  
 */
	private Point2D[] suspects;
	private PatrolCar patrolCar;
	public static final int SIZE = 9;
	private Random rand = new Random(new Date().getTime());

	/*
	 * @overload the world program 
	 */
	World() {
		suspects = new Point2D[rand.nextInt(20) + 1];
		for (int i = 0; i < suspects.length; i++) {
			suspects[i] = new Point2D(rand.nextInt(SIZE + 1), rand.nextInt(SIZE + 1));
		}
		patrolCar = new PatrolCar();
	}
	/*
	 * updating the changed of the programs
	 */
	public void update() {
		for (int i = 0; i < this.suspects.length; i++) {
			if (this.suspects[i].compareTo(this.patrolCar.getLocation()) == 0) {
				this.suspects[i].setX(-1);
				this.suspects[i].setY(-1);
				this.patrolCar.addArrested();
			}
		}
	}
	/*
	 * This part will control the patrol car and input the location of the patrol car 
	 */
	public void move() {
		int direct = rand.nextInt(4);
		int cellNumb = rand.nextInt(World.SIZE) + 1;
		switch (direct) {
		case 0:
			for (int i = 0; i < cellNumb; i++) {
				if (this.patrolCar.moveEast()) {
					this.update();
				} else {
					break;
				}
			}
			break;
		case 1:
			for (int i = 0; i < cellNumb; i++) {
				if (this.patrolCar.moveNorth()) {
					this.update();
				} else {
					break;
				}
			}
			break;
		case 2:
			for (int i = 0; i < cellNumb; i++) {
				if (this.patrolCar.moveSouth()) {
					this.update();
				} else {
					break;
				}
			}
			break;
		default:
			for (int i = 0; i < cellNumb; i++) {
				if (this.patrolCar.moveWest()) {
					this.update();
				} else {
					break;
			  }
			}
			
			break;
		}
	}

	/*
	 * the main class for patrol car
	 */
	public static void main(String[] args) {
		/*
		 * the object of the class worlds
		 */
		World World = new World();
		
		/*
		 * this will do the loop for the patrol car's movement and the people his have arrested in each location (the x and y axis)
		 */
		while (World.patrolCar.getNumSuspectsArrested() < World.suspects.length) {
			World.move();
			System.out.println("The new patrol car position is it (x, y) "+World.patrolCar.getLocation()
					+", Susppected arrect #: "+World.patrolCar.getNumSuspectsArrested());
		}
	}

}
