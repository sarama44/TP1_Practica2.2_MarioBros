package tp1.logic;

import tp1.view.Messages;

public enum Action {
	LEFT(-1,0), RIGHT(1,0), DOWN(0,1), UP(0,-1), STOP(0,0);
	
	private int x;
	private int y;
	
	private Action(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	
	public int getX() {
		return x;
	}
    public int getY() {
		return y;
	}
	
    
	public boolean equals(Action a) {
		return ((x == a.getX())&&(y == a.getY()));
	}
	
	@Override
	public String toString() {
        switch(this) {
            case LEFT: return "LEFT";
            case RIGHT: return "RIGHT";
            case UP: return "UP";
            case DOWN: return "DOWN";
            case STOP: return "STOP";
            default: return "";
        }
    }
	
	public static Action parseAction(String[] objDescription) {
		String strAction = objDescription[2].toUpperCase();
		Action action = strToAction(strAction);
		if(action != null) {
			return action; //devuelve la acción parseada
		}
		else return null; //si la acción es nula se hace la act automática
	}
	
	private static Action strToAction(String action) {
		if(action.equals(Messages.ACTION_LEFT) || action.equals(Messages.ACTION_LEFT_SHORTCUT)) {
			return Action.LEFT;
		}
		else if (action.equals(Messages.ACTION_RIGHT) || action.equals(Messages.ACTION_RIGHT_SHORTCUT)) {
			return Action.RIGHT;
		} 
		else if (action.equals(Messages.ACTION_STOP) || action.equals(Messages.ACTION_STOP_SHORTCUT)) {
			return Action.STOP;
		}
		return null;
	}
}