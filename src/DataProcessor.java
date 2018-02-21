import java.util.LinkedList;

public class DataProcessor {
	
	private LinkedList<String> data = new LinkedList<>();
	private RoverManager manager = new RoverManager();
	private int gridX = 0;
	private int gridY = 0;
	
	public DataProcessor() {
	}
	
	public void LoadData(LinkedList<String> input, int x, int y) {
		this.data = input;
		this.gridX = x;
		this.gridY = y;
		manager.SetGrid(x, y);
	}
	
	public void ProcessData() {
		if(data.size() == 0) {
			System.out.print("No valid data!");
		}else {
			//Create Rovers
			boolean roverPos = true;
			boolean invalidPos = false;
			int invalidRovers = 0;
			for(int i=0; i<data.size(); i++) {
				if(roverPos) {
					//Initial position of a Rover
					invalidPos = false;
					String line = data.get(i);
					int j = 0;
					int posX = 0;
					while(!Character.isWhitespace(line.charAt(j))) {
						posX *= 10;
						posX += Character.getNumericValue(line.charAt(j));
						j++;
					}
					j++;
					int posY = 0;
					while(!Character.isWhitespace(line.charAt(j))) {
						posY *= 10;
						posY += Character.getNumericValue(line.charAt(j));
						j++;
					}
					j++;
					char direction = line.charAt(j);
					//Check if the position is inside the grid
					if((posX >= 0 && posX <= gridX) && (posY >= 0 && posY <= gridY)) {
						//Create the Rover
						manager.AddRover(posX, posY, direction);
					}else {
						//Invalid rover position
						invalidPos = true;
						System.out.println("The Rover number " + (manager.GetNumRovers()+invalidRovers+1) + " has an invalid initial position and was not created.");
						invalidRovers++;
					}
					
					
				}else {
					//Orders for the rover
					if(!invalidPos) {
						String line = data.get(i);
						for(int j=0; j<line.length(); j++) {
							manager.MoveRover(line.charAt(j));
						}
						manager.PrintOutput();
					}
					
				}
				roverPos = !roverPos;
			}
		}
	}
	
	public void ReadGridSize(String line) {
		int j = 0;
		gridX = 0;
		while(!Character.isWhitespace(line.charAt(j))) {
			gridX *= 10;
			gridX += Character.getNumericValue(line.charAt(j));
			j++;
		}

		j++;
		gridY = 0;
		while(j < line.length()) {
			gridY *= 10;
			gridY += Character.getNumericValue(line.charAt(j));
			j++;
		}
		
	}
	
	public int GetGridX() {
		return gridX;
	}
	
	public int GetGridY() {
		return gridY;
	}

}