package tp1.control.commands;

import tp1.logic.GameInterfaces.GameModel;
import tp1.view.GameView;

public interface Command { //métodos que todos los comandos deben de implementar

	public void execute(GameModel game, GameView view);//cada comando debe de ejecutarse. 
	public Command parse(String[] commandWords);//cada comando tiene que saber parsearse

	public String helpText();//a la hora de mostrar la ayuda de cada comando, cada comando
	//debe de devolver la suya.
}
