
public class OldSchoolIsOddStrategy implements CheckStrategy{
	
	public boolean check(String s) {
		if (Integer.parseInt(s) % 2 != 0) //Parse to Int to check if it is odd with String types
			return true;
		else
			return false;
	}
}
