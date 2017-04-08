
public class ReversingDecorator implements CheckStrategy {
		
	public ReversingDecorator(CheckStrategy check) {
		checker = check;
	}
	
	public boolean check(String s) {
		return !checker.check(s);
	}
	
	private CheckStrategy checker;

}
