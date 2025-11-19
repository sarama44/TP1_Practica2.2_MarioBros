package tp1.control.commands;

import tp1.logic.GameInterfaces.GameModel;
import tp1.logic.Action;
import tp1.view.GameView;
import tp1.view.Messages;
import java.util.ArrayList;
import java.util.List;

public class ActionCommand extends AbstractCommand {
	//Atributos para llamar a la constructora de la super.
	private static final String name = Messages.COMMAND_ACTION_NAME;
	private static final String shortcut = Messages.COMMAND_ACTION_SHORTCUT;
	private static final String details = Messages.COMMAND_ACTION_DETAILS;
	private static final String help = Messages.COMMAND_ACTION_HELP;
	//añadimos la lista de acciones que tendrá las acciones válidas introducidas por el usuario.
	private List<Action> actions;
	//constructora:
	public ActionCommand () { //constructora sin lista para la lista de CommandGenerator.
		super(name, shortcut, details, help);
		this.actions = new ArrayList<>();
	}
	
	public ActionCommand (List<Action> actions) { //constructora con lista como parámetro
		super(name, shortcut, details, help);
		this.actions = actions;
	}
	
	//métodos implementados de Command:
	@Override
	public void execute(GameModel game, GameView view) {
		if(actions != null && !(actions.isEmpty())) {
			for(Action action : actions)
				game.addAction(action);//añadimos la acción a actionList a través de ga,e.
		}
		game.update();
		view.showGame();
	}
	
	@Override
	public Command parse(String[] commandWords) {
		if(commandWords.length > 1 && matchCommandName(commandWords[0])){
			List<Action> parsedActions = new ArrayList<>();
	        for (int i = 1; i < commandWords.length; i++) {
	            Action action = parseAction(commandWords[i]);
	            if (action != null) {
	                parsedActions.add(action);
	            }
	        }
	        return new ActionCommand(parsedActions);
		}
		return null;
	}
	//método adicional para devolver Strings como acciones (strToAction)
	private Action parseAction (String actionStr) {
		
		String upperAction = actionStr.toUpperCase();
		switch(upperAction) {
		case(Messages.ACTION_LEFT_SHORTCUT):
		case(Messages.ACTION_LEFT):
			return Action.LEFT;
		case(Messages.ACTION_RIGHT_SHORTCUT):
		case(Messages.ACTION_RIGHT):
			return Action.RIGHT;
		case(Messages.ACTION_DOWN_SHORTCUT):
		case(Messages.ACTION_DOWN):
			return Action.DOWN;
		case(Messages.ACTION_STOP_SHORTCUT):
		case(Messages.ACTION_STOP):
			return Action.STOP;
		case(Messages.ACTION_UP_SHORTCUT):
		case(Messages.ACTION_UP):
			return Action.UP;
		default:
			return null;
		}
		
	}
}
