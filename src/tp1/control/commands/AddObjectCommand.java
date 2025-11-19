package tp1.control.commands;

import tp1.logic.GameInterfaces.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;
import java.util.Arrays;
import tp1.logic.gameobjects.GameObject;

public class AddObjectCommand extends AbstractCommand{
	private static final String NAME = Messages.COMMAND_ADDOBJECT_NAME;
	private static final String SHORTCUT = Messages.COMMAND_ADDOBJECT_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_ADDOBJECT_DETAILS;
	private static final String HELP = Messages.COMMAND_ADDOBJECT_HELP;
	private String[] objectDescription;
	
	public AddObjectCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	public void execute(GameModel game, GameView view) {
	    // GameModel (que es Game) tiene el método parse que usa GameObjectFactory internamente
	    GameObject gameObject = game.parse(this.objectDescription);
	    if (gameObject != null) {
	        game.addGameObject(gameObject);
	        view.showGame();
	    } else {
	        view.showError("Invalid game object: " + String.join(" ", objectDescription));
	    }
	}
	
	public Command parse(String[] objWords) {
		if(objWords.length >= 3 && matchCommandName(objWords[0])) {
			this.objectDescription = Arrays.copyOfRange(objWords, 1, objWords.length);
			return this;
			}
		
		return null;
	}
	
	@Override
	public String helpText(){
		return super.helpText() + (Messages.LINE_2TABS).formatted(Messages.COMMAND_ADDOBJECT_EXECUTION_EXAMPLE);
	}
	
}
