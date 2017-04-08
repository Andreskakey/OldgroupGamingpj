import java.util.Vector;

public class SavingDecorator implements CheckStrategy {
	
	public SavingDecorator(CheckStrategy check) {
		checker = check;
		trueVector = new Vector<String>();
		falseVector = new Vector<String>();
	}
	
	public boolean check(String s) {
		boolean result = checker.check(s);
		if(result)
			trueVector.addElement(s);
		else
			falseVector.addElement(s);
		return result;
	}
	
	public Vector<String> getTrueVector() {
		return trueVector;
	}
	
	public Vector<String> getFalseVector() {
		return falseVector;
	}

	private CheckStrategy checker;
	private Vector<String> trueVector;
	private Vector<String> falseVector;
	
}
