package commandpattern;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SystemParams implements ICommand{

	DateFormat datumformat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
	Date datumobjekt = new Date();

	@Override
	public void redo() {
		System.konfigdaten.stack_push(System.konfigdaten.stack_peek());
	}
	
	@Override
	public void execute() {
		System.konfigdaten.stack_push("Datum: "+ datumformat.format(datumobjekt));
	}

	@Override
	public void undo() {
		System.konfigdaten.stack_pop();
	}
}