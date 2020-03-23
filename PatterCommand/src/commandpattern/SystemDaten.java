package commandpattern;

public class SystemDaten implements ICommand{

	@Override
	public void redo() {
		System.commanddaten.stack_push(System.commanddaten.stack_peek());
	}
	
	@Override
	public void execute() {
		System.commanddaten.stack_push(System.currentTimeMillis());
	}

	@Override
	public void undo() {
		System.commanddaten.stack_pop();
	}
}