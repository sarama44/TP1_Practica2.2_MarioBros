package tp1.logic;

import java.util.ArrayList;
import java.util.List;

public class ActionList {
	//guardar atributos
	private Action horizontal;
	private Action vertical;
	private int contH;
	private int contV;
	private int contS;
	private List<Action> actList;
	
	private static final int MAX_HORIZONTAL = 4;
	private static final int MAX_VERTICAL = 4;
	private static final int MAX_STOP = 1;
	
	
	
	//CONSTRUCTORA
	public ActionList(){
		actList = new ArrayList<>();
		horizontal = null;
		vertical = null;
		contH = 0;
		contV = 0;
	}
	
	
	
	public boolean isListEmpty() {
		return (actList.size() == 0);
	}
	public Action getAction(int idx) {
	    if (idx >= 0 && idx < actList.size()) {
	        return actList.get(idx);
	    } else {
	        return null;
	    }
	}
	public int getSize() {
		return actList.size();
	}
	public void clearList() {
		actList.clear();
		horizontal = null;
		vertical = null;
		contH = 0;
		contV = 0;
	}
	
	
	
	//ADD ACTION
	public void add(Action action) {
		if (checkAction(action) && actList.size() < (MAX_HORIZONTAL+MAX_VERTICAL+MAX_STOP)){
			//actList.add(action);	
			checkMaxMoves(action);
		}
	}
	
	private boolean checkAction(Action a){
		boolean ok = true; 
		if (a == Action.LEFT || a == Action.RIGHT) { 
			if (horizontal == null) { 
				horizontal = a; 
			} 
			else if (horizontal != a) { 
				ok = false; 
			} 
		}
		if (a == Action.UP || a == Action.DOWN) { 
			if(vertical == null) { 
				vertical = a; 
			} else if(vertical != a){ 
				ok = false; 
			}
		} 
		return ok;
	}
	
	private void checkMaxMoves(Action action) {
		if ((action == Action.RIGHT || action == Action.LEFT) && contH < MAX_HORIZONTAL) { // contH < MAX_HORIZONTAL permite valores 0, 1, 2, 3 de una array
			actList.add(action); 
			contH++; 
		} 
		else if ((action == Action.UP || action == Action.DOWN) && contV < MAX_VERTICAL) { 
			actList.add(action); 
			contV++; 
		} else if (action == Action.STOP && contS <= MAX_STOP) { 
			actList.add(action); 
			contS++; 
		} //else: no se añade
		// si se añade se incrementa el size() automaticamente;
	}
}