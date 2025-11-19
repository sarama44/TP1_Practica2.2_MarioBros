package tp1.logic;

public class Position {

	private int col;
	private int row;
	
	//CONSTRUCTORAS
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
	
	public boolean exitsBoard() { //true = la pos está fuera del tablero
		return ((this.col >= Game.DIM_X || this.col < 0)||(this.row >= Game.DIM_Y || this.row < 0));
	}
	
	@Override
	public String toString() {
		return "(" + row + "," + col + ")";
	}
	//Método llamado por el parse de GameObject.
	public static Position parsePos(String[] objDescription) { 
		String posInStr = objDescription[0]; //variable auxiliar coge el string de la posición con formato "(x,y)" de objDescription[0].
		if(posInStr.startsWith("(") && posInStr.endsWith(")")) { //Verificamos si la posición dada por el usuario está entre paréntesis con .startsWith y .endsWith.
			String[] coords = posInStr.substring(1, posInStr.length() - 1).split(","); //Creamos una array de coordenadas
			//creando una substring de la original (ignoramos los paréntesis y cogemos lo de dentro)
			//y la separamos en dos mitades a partir de la coma: coords[0] = x, coords[1] = y.
		    if(coords.length == 2) { //la array coords siempre tiene que ser de longitud dos (tiene coords x e y).
		    	try {
		    		int row = Integer.parseInt(coords[0]);//Utilizamos este método de integer para obtener un número
		    		//de una string
		    		
		    		int col = Integer.parseInt(coords[1]);//Utilizamos este método de integer para obtener un número
		    		//de una string
		    		
		    		Position pos = new Position(row, col);//después creamos la posición con los valores obtenidos.
		    		if(!(pos.exitsBoard())) {//Comprobamos que la posición introducida no está fuera del tablero
		    			return pos; //devolvemos la posición para el parse del objeto.
		    		}
		    	} catch (NumberFormatException e) {
		    		return null;
		    	}
		    }
		}
		return null;
	}
}

/* Explicación del try-catch en position.
 * Sabemos que ya existe un try-catch de NumberFormatException en main. Pero el mensaje de error que este imprime
 * es un "wrong level number", para manejar la excepción al poner un caracter o un número no reconocido
 * como argumento para resetear el nivel.
 * Para que el mensaje sea más concreto, y el error impreso sea el real, es decir, "no podemos crear un objeto en la
 * posición dada porque has metido algo que no es un número, o que no se puede parsear a un número", hemos decidido
 * añadir también este try catch específico para Position.
 * 
 */
		    
