package tp1.logic;

public class Position {

	private int col;
	private int row;
	
	//CONTSTRUCTORAS
	public Position() {
		col = 0;
		row = 0;
	}
	public Position(int r, int c) {
		this.col = c;
		this.row = r;
	}
	
	
	//MÉTODOS
	public boolean equals(Position pos) { //compara dos posiciones no la dir de memoria
		return (pos.col == this.col && pos.row == this.row);
	}
	
	public Position movePos(Action act) { //devuelve la posición adyacente según una dirección dada
		return new Position(this.row + act.getY(), this.col + act.getX());
	}
	
	public boolean exitsBoard() { //true = la pos exitea el tablero
		return ((this.col >= Game.DIM_X || this.col < 0)||(this.row >= Game.DIM_Y || this.row < 0));
	}
	
	@Override
	public String toString() {
		return "(" + row + "," + col + ")";
	}
	
	public static Position parsePos(String[] objDescription) {
		String posInStr = objDescription[0]; //string de la posicion "(x,y)"
		if(posInStr.startsWith("(") && posInStr.endsWith(")")) { 
			String[] coords = posInStr.substring(1, posInStr.length() - 1).split(","); //MIRAR SI EL FINAL ESTÁ EXCLUIDO.
		    if(coords.length == 2) { // coord x e y
		    	try {
		    		int row = Integer.parseInt(coords[0]);
		    		
		    		int col = Integer.parseInt(coords[1]);
		    		
		    		Position pos = new Position(row, col);
		    		if(!(pos.exitsBoard())) {
		    			return pos;
		    		}
		    	} catch (NumberFormatException e) {
		    		return null;
		    	}
		    }
		}
		return null;
	}
}
		    
