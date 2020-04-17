package Schaltung;

public class Context {
	
	private IState state;
	
	private boolean gültig;
	private int geschwindigkeit;
	private int leistung;
	private boolean turbo;
	
	public Context(int geschwindigkeit, int leistung, boolean turbo) {
		super();
		this.geschwindigkeit = geschwindigkeit;
		this.leistung = leistung;
		this.turbo = turbo;
	}

	public void setState(IState state) {
		this.state = state;
	}

	public int getGeschwindigkeit() {
		return geschwindigkeit;
	}

	public void setGeschwindigkeit(int geschwindigkeit) {
		this.geschwindigkeit = geschwindigkeit;
	}

	public int getLeistung() {
		return leistung;
	}

	public void setLeistung(int leistung) {
		this.leistung = leistung;
	}

	public boolean isTurbo() {
		return turbo;
	}

	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}

	public boolean isGültig() {
		return gültig;
	}

	public void setGültigkeit(boolean gültig) {
		this.gültig = gültig;
	}

	public void beschleunigung(int neuegeschwindigkeit, int leistung, boolean turbo) {
		if((geschwindigkeit * 2.5) <= neuegeschwindigkeit && turbo){
			gültig = true;
		}
		geschwindigkeit = neuegeschwindigkeit;
		this.turbo = turbo;	
		
		state.Act();
		state.Next((javax.naming.Context) this);
	}
	
	public void abbrechen(int neuegeschwindigkeit, int leistung, boolean turbo) {
		if (geschwindigkeit > (neuegeschwindigkeit * 2.5) && !turbo && leistung < 90) {
			gültig = false;
		}
		
		state.Next((javax.naming.Context) this);
	}
}