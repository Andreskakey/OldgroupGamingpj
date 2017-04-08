
public class StartWithAnyCharacter implements CheckStrategy {
	
	public StartWithAnyCharacter(char x) {
		this.x = x;
	}
	
	public boolean check(String s) {
		if ( s == null || s.length() == 0) {
			return false;
		}
		return s.charAt(0) == x;
	}
	
	private char x;

}
