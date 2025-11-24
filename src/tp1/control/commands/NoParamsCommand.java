package tp1.control.commands;

public abstract class NoParamsCommand extends ParamsCommand {

	public NoParamsCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	@Override
	//métodos
	public Command parse(String[] commandWords) {
		if(commandWords.length == 1 && matchCommandName(commandWords[0])) {
			return this; //cada método se tiene que saber parsear a sí mismo.
		}
			
		return null;
	}
}
