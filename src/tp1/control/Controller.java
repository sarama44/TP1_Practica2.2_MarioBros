package tp1.control;

import tp1.control.commands.Command;
import tp1.control.commands.CommandGenerator;
import tp1.logic.GameInterfaces.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class Controller {

	private GameModel game;
	private GameView view;

	public Controller(GameModel game, GameView view) {
		this.game = game;
		this.view = view;
	}

	public void run() { //bucle principal del juego

		view.showWelcome(); //MarioBross 2.X

		view.showGame();
		
		while (!game.isFinished()) {
			String[] words = view.getPrompt();//guardamos el input del usuario
			Command command = CommandGenerator.parse(words); //llamamos al método parse de cada comando y recibimos
			//el comando que el usuario quiere o null en caso de no haberse encontrado

			if (command != null)
				command.execute(game, view); //En caso de que el comando se encuentre, llamamos a su método execute.
			else 
				view.showError(Messages.UNKNOWN_COMMAND.formatted(String.join(" ", words))); //Si no se encuentra, printeamos error.
		}
		view.showEndMessage();
	}
	
}
