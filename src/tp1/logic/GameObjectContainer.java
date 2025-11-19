package tp1.logic;

import java.util.ArrayList;
import java.util.List;

import tp1.logic.gameobjects.GameItem;
import tp1.logic.gameobjects.GameObject;

public class GameObjectContainer {
	private List<GameObject> objects;
	private List<GameObject> newObjects;

	//CONSTRUCTORA
	public GameObjectContainer() {
		objects = new ArrayList<GameObject>();
		newObjects = new ArrayList<GameObject>();
	}
	
	
	public void add(GameObject object) {
		this.objects.add(object);
	}
	
	//AÑADE UN OBJETO A LA LISTA DE OBJETOS PENDIENTES
	public void toAdd(GameObject gameobject) {
		this.newObjects.add(gameobject);
	}
	
	
	//UPDATE
	public void update() {
		
		for(int i = 0; i < objects.size(); i++) {
			objects.get(i).update(); //updatea la posición del personaje
		}
		for(GameObject obj: objects) {
			doInteraction(obj);
		}
		//LISTA DE OBJETOS A AÑADIR
		for(GameObject obj : newObjects) {
		    this.objects.add(obj);
		}
		newObjects.clear();
		
		clean();
	}
	private void clean() {
		for(int i = 0; i < objects.size(); i++) {
			if (!(objects.get(i).isAlive())) {
				objects.remove(i);
				i--; //como se hace un resize() automaticamente y los elementos se desplazan, hay que volver a chequear la pos i
			}
		}
	}
	public void remove(GameObject object) {
		for(int i = 0; i < objects.size(); i++) {
			if (objects.get(i).equals(object)) {
				objects.remove(i);
				i--; //como se hace un resize() automaticamente y los elementos se desplazan, hay que volver a chequear la pos i
			}
		}
	}
	
	public void doInteraction(GameItem other) {
		for (GameObject obj: objects) {
			if (obj.isAlive() && other.isAlive()) {
				obj.doInteraction(other);
			}
		}
	}
	
	
	//POSICIONES
	public boolean isPosSolid(Position pos) {
		for(GameObject obj : objects) { //si el obj es mario, se chequea la posición de arriba y la de abajo
			if (obj.isInPos(pos) && obj.isSolid()) {
				return true;
			}
		}
		return false;
	}
	
	public String positionToString(Position pos) {
		StringBuilder posToStr = new StringBuilder();
		//boolean hasObject = false;
		for (GameObject obj : objects) {
			if (obj != null && obj.isInPos(pos)) {
				posToStr.append(obj.getIcon());
				//hasObject = true;
			}
		}
		
		/*if(!(hasObject)) {
			posToStr.append(".");
		}*/
		
		return posToStr.toString();
	}
}
