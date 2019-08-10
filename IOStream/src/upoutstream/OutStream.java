package upoutstream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutStream {
	public static void main(String[] args) {
		OutputStream  out=null;
		String s="ABCDEFJHIJKLMNOPQRSTUVWXYZ";
		byte[] bs=s.getBytes();//将字符串变成字符数组
          try {
          out = new FileOutputStream("a.txt");
            //out.write(65);//写一个A字母
			  out.write(bs);
			
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
          
	}


}
