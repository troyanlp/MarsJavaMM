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
			for(int i=0; i<data.size(); i++) {
				if(roverPos) {
					//Initial position of a Rover
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
					//Create the Rover
					manager.AddRover(posX, posY, direction);
					
				}else {
					//Orders for the rover
					String line = data.get(i);
					for(int j=0; j<line.length(); j++) {
						manager.MoveRover(line.charAt(j));
					}
					manager.PrintOutput();
				}
				roverPos = !roverPos;
			}
		}
	}

}
