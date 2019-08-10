package upoutstream;

import java.io.File;

public class TestFile {
   public static void main(String[] args)throws Exception {
	 File  f = new File("xu");
	// f.createNewFile();
	 if(f.mkdir()) {
		 System.out.println("success");
	 }
	 f.delete();
}
}
