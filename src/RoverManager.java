import java.util.LinkedList;

public class RoverManager {
	
	private LinkedList<Rover> rovers =  new LinkedList<>();;
	
	public RoverManager() {
		
	}
	
	public void AddRover(int x, int y, char heading) {
		Rover rover = new Rover(x,y,heading);
		rovers.add(rover);
	}
	
	public void MoveRover(char order) {
		if(order == 'M' || order == 'm') {
			rovers.getLast().Move();
		}else {
			rovers.getLast().Turn(order == 'R' || order == 'r');
		}
	}
	
	public void PrintOutput() {
		Rover aux = rovers.getLast();
		System.out.println(aux.getX() + " " + aux.getY() + " " + aux.getHeading());
	}

}
