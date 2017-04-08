
public class IsOddStrategy implements CheckIntStrategy {
	
	public boolean check(int n) {
		if (n % 2 != 0)
			return true;
		else
			return false;
	}

}
