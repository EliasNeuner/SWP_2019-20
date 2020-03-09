package simaystatemaschine;

public class Context{
	private boolean valid = true;
	private IState istate;
	
	public Context() {
		istate = new AufnahmeState();
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public void setValidFalse(boolean a) {
		a = valid;
	}

	public IState getIstate() {
		return istate;
	}

	public void setIstate(IState istate) {
		this.istate = istate;
	}
}