public class LongerThanN implements CheckStrategy {

	private int n; 

	public LongerThanN(int n) {
		this.n = n;
	}

	public boolean check(String s) {
		if (s == null) {
			return false;
		}
		return s.length() > n;
	}
} 
