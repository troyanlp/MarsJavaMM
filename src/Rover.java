
public class Rover {
	
	private int x;
	private int y;
	private char heading;
	
	public Rover(int x, int y, char heading) {
		super();
		this.x = x;
		this.y = y;
		this.heading = heading;
		//System.out.println("Mars Rover created with position " + x + "," + y+ " and direction " + heading);
	}
	
	public void Move() {
		//Check if it can move to that square
		//Move
		switch(heading) {
		case 'N':
			y +=1;
			break;
		case 'S':
			y -= 1;
			break;
		case 'W':
			x -= 1;
			break;
		case 'E':
			x += 1;
			break;
		}
	}
	
	public void Turn(boolean right) {
		char newDir = ' ';
		switch(heading) {
		case 'N':
			if(right) newDir = 'E';
			else newDir = 'W';
			break;
		case 'S':
			if(right) newDir = 'W';
			else newDir = 'E';
			break;
		case 'W':
			if(right) newDir = 'N';
			else newDir = 'S';
			break;
		case 'E':
			if(right) newDir = 'S';
			else newDir = 'N';
			break;
		}
		if(newDir != ' ') heading = newDir;
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getHeading() {
		return heading;
	}

	public void setHeading(char heading) {
		this.heading = heading;
	}
	
	
	
	

}
