package problem2;

import java.io.File;
import java.io.RandomAccessFile;

public class Problem2 {
	public static void parse(File file) throws Exception {//the original problem doesn't have throws/throw statement
		 RandomAccessFile input = null;
		 String line = null;

		 try {
		 input = new RandomAccessFile(file, "r");
		 while ((line = input.readLine()) != null) {
		 System.out.println(line);
		 }
		 return;
		 } finally {
		 if (input != null) {
		 input.close();
		 }
		 }
		 }
	
}
