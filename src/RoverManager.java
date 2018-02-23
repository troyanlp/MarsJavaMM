import java.util.LinkedList;

public class RoverManager {
	
	private LinkedList<Rover> rovers =  new LinkedList<>();
	private int width = 0;
	private int height = 0;
	
	public RoverManager() {
		
	}
	
	public int getNumRovers() {
		return rovers.size();
	}
	
	public void addRover(int x, int y, char heading) {
		Rover rover = new Rover(x,y,heading);
		rovers.add(rover);
	}
	
	public void moveRover(char order) {
		if (order == 'M' || order == 'm') {
			Rover aux = rovers.getLast();
			if (canMove()) {
				aux.move();
			}
		} else {
			if (order == 'R' || order == 'r' || order == 'L' || order == 'l') {
				rovers.getLast().turn(order == 'R' || order == 'r');
			}
		}
	}
	
	public boolean canMove() {
		//Check if is inside the grid and if the next square is free (no other rover)
		Rover aux = rovers.getLast();
		switch (aux.getHeading()) {
		case 'N':
			if ((aux.getY() + 1) <= height) {
				if(rovers.size() == 1) {
					return true;
				} else {
					return checkPosition(aux, 0, 1);
				}
			}
			break;
		case 'S':
			if ((aux.getY() - 1) >= 0) {
				if (rovers.size() == 1) {
					return true;
				} else {
					return checkPosition(aux, 0, -1);
				}
			}
			break;
		case 'E':
			if ((aux.getX() + 1) <= width) {
				if (rovers.size() == 1) {
					return true;
				} else {
					return checkPosition(aux, 1, 0);
				}
			}
			break;
		case 'W':
			if ((aux.getX() - 1) >= 0) {
				if (rovers.size() == 1) {
					return true;
				} else {
					return checkPosition(aux, -1, 0);
				}
			}
			break;
		}
		return false;
	}
	
	private boolean checkPosition(Rover rover, int x, int y) {
		boolean found = false;
		for (int i=0; i<(rovers.size()-1); i++) {
			if (rovers.get(i).getX() == (rover.getX() + x) && 
				rovers.get(i).getY() == rover.getY() + y) {
				found = true; 
			}
		}
		return !found;
	}
	
	public void printOutput() {
		Rover aux = rovers.getLast();
		System.out.println(aux.getX() + " " + aux.getY() + " " + aux.getHeading());
	}
	
	public void setGrid(int x, int y) {
		this.width = x;
		this.height = y;
	}
	
}
