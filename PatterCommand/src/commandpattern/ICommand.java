package commandpattern;

public interface ICommand {
	public void redo();
	public void execute();
	public void undo();
}