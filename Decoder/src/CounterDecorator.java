class CounterDecorator implements CheckStrategy {

	private int count = 0;
	private CheckStrategy checker;
	
	public CounterDecorator(CheckStrategy check) {	
		checker = check;
	}

	public boolean check(String s) {	
		boolean result =  checker.check(s);
		if (result) {
			count++;
		}
		return result;
	}

	public int count() {
		return count;
	}

	public void reset() {
		count = 0;
	}


}
