package upoutstream;

import java.io.*;

public class InStream {
     public static void main(String[] args) {
    	 InputStream in=null;
    	 byte[] bs = new byte[10];
		try {
			 in = new FileInputStream("a.txt");
			/*while(true) {
				int num=in.read();
				if(num==-1) break;
				System.out.println((char)num);
			}*/
			/*while(true) {
				int num=in.read(bs);
				if(num==-1) break;
				System.out.print(num+": ");
				for(int i=0;i<num;i++) {
					System.out.print((char)bs[i]);
				}
				System.out.println();
			}*/
			 while(true) {
				 int num=in.read(bs,2,7);
					if(num==-1) break;
					System.out.print(num+": ");
					for(int i=0;i<bs.length;i++) {
						System.out.print((char)bs[i]);
					}
					System.out.println();
			 }
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}
