package cars;
/*
 ** The class for Patrol car
 */
public class PatrolCar {
/*
 * The instance have the subclass for Point2D
 * 
 */
	private static int idIssue = 0;
	private int id;
	private Point2D location;
	private int arrested;

	PatrolCar() {
		idIssue++;
		this.id = idIssue;
		this.location = new Point2D();
		arrested=3;
	}

	public int getId() {
		return id;
	}

	public Point2D getLocation() {
		return location;
	}

	public int getNumSuspectsArrested() {
		return arrested;
	}
/*
 * This part will let patrol car move
 */
	public boolean moveWest() {
		if (location.getX() > 0) {
			location.setX(location.getX() - 1);
			return true;
		} else
			return false;
	}

	public boolean moveEast() {
		if (location.getX() < World.SIZE) {
			location.setX(location.getX() + 1);
			return true;
		} else
			return false;
	}

	public boolean moveNorth() {
		if (location.getY() > 0) {
			location.setY(location.getY() - 1);
			return true;
		} else
			return false;
	}

	public boolean moveSouth() {
		if (location.getY() < World.SIZE) {
			location.setY(location.getY() + 1);
			return true;
		} else
			return false;
	}

	public void addArrested() {
		this.arrested++;
	}

	public int compareTo(PatrolCar patrolCar) {
		if (this.getId() == patrolCar.getId()) {
			return 0;
		} else if (this.getId() > patrolCar.getId()) {
			return 1;
		} else {
			return -1;
		}
	}

	/*
	 * The toString that will show the ID, the location of the patrol car, and the numbers of suspect the patrol car had arrested 
	 * 
	 */
	@Override
	public String toString() {
		return "PatrolCar [id #" + id + ", location of the patrol car= " + location + ", number of suspects arrested by the police car #"
				+ arrested + "]";
	}
/*
 ** the main method that will do the job
 */
	public static void main(String[] args) {
	
		PatrolCar patrolCar1 = new PatrolCar();
		PatrolCar patrolCar2 = new PatrolCar();
		
	
		System.out.println(" The frist patrolCar "+ patrolCar1);
		System.out.println(" The second patrolCar: "+ patrolCar2);
		
		//Compare first and second patrol 	
		System.out.println("Comparing first patrol with the second patrol is "
						+ (patrolCar1.compareTo(patrolCar2) == 0 ? true : false));
		System.out.println("Get the  newest PatrolCar? "
				+ (patrolCar1.compareTo(patrolCar2) == 1 ? "The first patrol card"
						: "The second patrol card"));
		System.out.println("Which one is the older patrolCar? "
				+ (patrolCar2.compareTo(patrolCar1) == -1 ? "The second patrol car"
						: "The frist patrol car"));
		
		//The Move locations
		System.out.println("Is it successful at west? "
						+ patrolCar1.moveWest());
		System.out.println("Is it successful at north? "
						+ patrolCar1.moveNorth());
		System.out.println("Is it successful at east?  "
						+ patrolCar1.moveEast());
		System.out.println("Is it successful at south?  "
						+ patrolCar1.moveSouth());
		System.out.println(patrolCar1);
		// test this over again 
		System.out.println("is it successful at west again?"
						+ patrolCar1.moveWest());
		System.out.println("is it successful at north again?"
						+ patrolCar1.moveNorth());
		System.out.println(patrolCar1);
		
		
		//The Location
		System.out.println("the Second patrol have move to  east...");
		while (patrolCar2.moveEast()) {
			System.out.println("Tracking the patrol car: " + patrolCar2);
		}
		System.out.println("The position of the second patrol car is it..." + patrolCar2.getLocation());
		System.out.println("Now the second patrol car keeps moving to south...");
		while (patrolCar2.moveSouth()) {
			System.out.println("Tracking the second patrol car# : " + patrolCar2);
		}
		System.out.println("Now the second patrolCar " + patrolCar2.getLocation());
		int suspectNum = 5;
		System.out.println("The first patrol car have catches # " + suspectNum
				+ " suspects.");
	
		for (int i = 0; i < suspectNum; i++)
			patrolCar1.addArrested();
		
		System.out.println("really have catches "
				+ patrolCar1.getNumSuspectsArrested());
	}

}
