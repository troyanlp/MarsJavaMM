import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileReader implements IReader {

	public FileReader() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void Read() {
		// TODO Auto-generated method stub
		System.out.println("File Reader");
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Write the name of the file (Must be inside the \"Test Files\" folder).");
		String filePath = reader.next();
		System.out.println(".\\src\\" + filePath);
		try (Stream<String> stream = Files.lines(Paths.get(".\\Test Files\\" + filePath), Charset.defaultCharset())) {
			String[] lines = stream.toArray(size -> new String[size]);
	        LinkedList<String> inputs = new LinkedList<>();
	        DataProcessor processor = new DataProcessor();
	        processor.ReadGridSize(lines[0]);
	        
	        for(int i=1; i< lines.length; i++) {
	        	inputs.add(lines[i]);
	        }

	        processor.LoadData(inputs, processor.GetGridX(), processor.GetGridY());
			processor.ProcessData();
		}catch (Exception e) {
			System.out.println("File not found!");
		}
	}

}
