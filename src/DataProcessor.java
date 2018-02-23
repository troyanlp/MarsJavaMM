import java.util.LinkedList;

public class DataProcessor {
	
	private LinkedList<String> data = new LinkedList<>();
	private RoverManager manager = new RoverManager();
	private int gridX = 0;
	private int gridY = 0;
	
	public DataProcessor() {
	}
	
	public void loadData(LinkedList<String> input, int x, int y) {
		this.data = input;
		this.gridX = x;
		this.gridY = y;
		manager.setGrid(x, y);
	}
	
	public boolean processData() {
		if (data.size() == 0) {
			System.out.print("No valid data!");
		} else {
			//Create Rovers
			boolean roverPos = true;
			boolean invalidPos = false;
			int invalidRovers = 0;
			for (int i=0; i<data.size(); i++) {
				if (roverPos) {
					//Initial position of a Rover
					invalidPos = false;
					String line = data.get(i);
					int j = 0;
					int posX = 0;
					while (!Character.isWhitespace(line.charAt(j))) {
						if (!Character.isDigit(line.charAt(j))) {
							return false;
						}
						posX *= 10;
						posX += Character.getNumericValue(line.charAt(j));
						j++;
					}
					j++;
					int posY = 0;
					while (!Character.isWhitespace(line.charAt(j))) {
						if (!Character.isDigit(line.charAt(j))) {
							return false;
						}
						posY *= 10;
						posY += Character.getNumericValue(line.charAt(j));
						j++;
					}
					j++;
					char direction = line.charAt(j);
					if (!checkDirection(direction)) {
						return false;
					}
					
					//Check if the position is inside the grid
					if ((posX >= 0 && posX <= gridX) && (posY >= 0 && posY <= gridY)) {
						//Create the Rover
						manager.addRover(posX, posY, direction);
					} else {
						//Invalid rover position
						invalidPos = true;
						System.out.println("The Rover number " + (manager.getNumRovers()+invalidRovers+1) 
								+ " has an invalid initial position and was not created.");
						invalidRovers++;
					}
					
					
				} else {
					//Orders for the rover
					if (!invalidPos) {
						String line = data.get(i);
						for (int j=0; j<line.length(); j++) {
							manager.moveRover(line.charAt(j));
						}
						manager.printOutput();
					}
					
				}
				roverPos = !roverPos;
			}
		}
		return true;
	}
	
	private boolean checkDirection(char dir) {
		if ((Character.toLowerCase(dir) != Character.toLowerCase('N')) &&
				(Character.toLowerCase(dir) != Character.toLowerCase('W')) &&
				(Character.toLowerCase(dir) != Character.toLowerCase('S')) &&
				(Character.toLowerCase(dir) != Character.toLowerCase('E'))) {
				return false;
			}
		return true;
	}
	
	public boolean readGridSize(String line) {
		if (line.length() == 0) {
			return false;
		}
		
		int j = 0;
		gridX = 0;
		while (!Character.isWhitespace(line.charAt(j))) {
			if (!Character.isDigit(line.charAt(j))) {
				return false;
			}
			gridX *= 10;
			gridX += Character.getNumericValue(line.charAt(j));
			j++;
		}

		j++;
		gridY = 0;
		while (j < line.length()) {
			if (!Character.isDigit(line.charAt(j))) {
				return false;
			}
			gridY *= 10;
			gridY += Character.getNumericValue(line.charAt(j));
			j++;
		}
		
		if (gridX <= 0 || gridY <= 0) {
			return false;
		}
		
		return true;
	}
	
	public int getGridX() {
		return gridX;
	}
	
	public int getGridY() {
		return gridY;
	}

}
