import java.util.LinkedList;

public class RoverManager {
	
	private LinkedList<Rover> rovers =  new LinkedList<>();
	private int width = 0;
	private int height = 0;
	
	public RoverManager() {
		
	}
	
	public void AddRover(int x, int y, char heading) {
		Rover rover = new Rover(x,y,heading);
		rovers.add(rover);
	}
	
	public void MoveRover(char order) {
		if(order == 'M' || order == 'm') {
			Rover aux = rovers.getLast();
			if(CanMove()) aux.Move();
		}else {
			rovers.getLast().Turn(order == 'R' || order == 'r');
		}
	}
	
	public boolean CanMove() {
		//Check if is inside the grid
		Rover aux = rovers.getLast();
		switch(aux.getHeading()) {
		case 'N':
			if((aux.getY() + 1) <= height) return true;
			break;
		case 'S':
			if((aux.getY() - 1) > 0) return true;
			break;
		case 'E':
			if((aux.getX() + 1) <= width) return true;
			break;
		case 'W':
			if((aux.getX() - 1) > 0) return true;
			break;
		}
		return false;
	}
	
	public void PrintOutput() {
		Rover aux = rovers.getLast();
		System.out.println(aux.getX() + " " + aux.getY() + " " + aux.getHeading());
	}
	
	public void SetGrid(int x, int y) {
		this.width = x;
		this.height = y;
	}

}
