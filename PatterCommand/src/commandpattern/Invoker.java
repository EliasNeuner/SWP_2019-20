package commandpattern;

public class Invoker {
	
	ICommand icommand;
	
	public Invoker(ICommand icommand) {
		this.icommand = icommand;
	}
	
	public ICommand geticommand() {
		return icommand;
	}
	
	public void seticommand(ICommand icommand) {
		this.icommand = icommand;
	}
	
	public void run() {
		icommand.execute();
	}
	
	public void redo() {
		icommand.redo();
	}
	
	public void undo() {
		icommand.undo();
	}
}