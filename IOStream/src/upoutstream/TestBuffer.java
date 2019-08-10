package upoutstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestBuffer {
public static void main(String[] args)throws Exception {
	FileOutputStream fos = new FileOutputStream("f.txt");
	FileChannel channel = fos.getChannel();//创建管道
	String s = "Hello Word123";
	ByteBuffer  b = ByteBuffer.wrap(s.getBytes());//创建  ByteBuffer
	channel.write(b);
	channel.close();

	FileInputStream  fis = new FileInputStream("f.txt");
	FileChannel channel1 =  fis.getChannel();//创建管道
	ByteBuffer  b1 = ByteBuffer.allocate(10);
	
	while(true) {
		int num=channel1.read(b1);
		if(num == -1) break;
		b1.flip();//从写模式到读模式
		while(b1.hasRemaining()) {
			System.out.print((char)b1.get());
		}
		b1.clear();//从读模式到写模式
		System.out.println();
	}
	channel1.close();
}
}
