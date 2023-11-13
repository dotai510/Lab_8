package Lab_8;

import java.io.FileNotFoundException;

public class TestMyWordCount {
	
	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp app = new MyWordCountApp();
		
		app.loadData();
	}
}
