package tp1.control.commands;

import tp1.logic.GameInterfaces.GameModel;
import tp1.view.Messages;
import tp1.view.GameView;


public class UpdateCommand extends NoParamsCommand {
	
		private static final String NAME = Messages.COMMAND_UPDATE_NAME;
		private static final String SHORTCUT = Messages.COMMAND_UPDATE_SHORTCUT;
		private static final String DETAILS = Messages.COMMAND_UPDATE_DETAILS;
		private static final String HELP = Messages.COMMAND_UPDATE_HELP;
		
	public UpdateCommand () {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	//métodos update
	
	@Override
	public void execute(GameModel game, GameView view){
		
		 game.update();
		view.showGame();
	
	}
	
	@Override
	public Command parse(String[] commandWords) {
		if(commandWords.length == 1) {
			if(commandWords[0] == "") {//tenemos que tener en cuenta el shortcut "" además de "U"
				return this;
			}
			else if (matchCommandName(commandWords[0])) {
				return this;
			}
		}
		return null;

	}
}