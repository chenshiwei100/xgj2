package upoutstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

public class FileCopy {
	public static void main(String[] args)throws Exception {
		//fileCopy1("a.mp3","b.mp3");
        fileCopy2("a.dll","c.dll");
        fileCopy3("a.dll","d.dll");
		fileCopy4("a.dll","e.dll");
		fileCopy5("a.dll","f.dll");
		fileCopy6("a.dll","g.dll");
	}
	 static  void  fileCopy1(String srcName,String desName) {
		 try {
			FileInputStream fis = new FileInputStream(srcName);
			FileOutputStream fos = new FileOutputStream(desName);
			while(true) {
				int num=fis.read();
				if(num==-1) break;
				fos.write(num);
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	 }
	
	 static  void  fileCopy2(String srcName,String desName) {
		 long t1=System.nanoTime();
		 FileInputStream fis = null;
		 FileOutputStream fos = null;
		 try {
		      fis = new FileInputStream(srcName);
			  fos = new FileOutputStream(desName);
			byte[] bs = new byte[1024];
			while(true) {
				int num=fis.read(bs);
				if(num==-1) break;
				fos.write(bs,0,num);
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
       long t2=System.nanoTime();
		 System.out.println((t2-t1)/1E9);
		 
	 }
	 //利用BufferedInputStream/ BufferedOutputStream过滤流 进行copy 
	 static  void  fileCopy3(String srcName,String desName) {
		 long t1=System.nanoTime();
		 FileInputStream fis = null;
		 FileOutputStream fos = null;
		 BufferedInputStream in = null;
		 BufferedOutputStream  out = null;
		 try {
		      fis = new FileInputStream(srcName);
		      in = new BufferedInputStream(fis);
			  fos = new FileOutputStream(desName);
			  out = new BufferedOutputStream(fos);
			byte[] bs = new byte[1024];
			while(true) {
				int num=fis.read(bs);
				if(num==-1) break;
				fos.write(bs,0,num);
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				out.flush();
				out.close();
				in.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
       long t2=System.nanoTime();
		 System.out.println((t2-t1)/1E9);
		 
	 }
	
      //利用nio包中的 ByteBuffer
	 static  void  fileCopy4(String srcName,String desName)throws Exception {
		 long t1=System.nanoTime();
		 ByteBuffer buffer =   ByteBuffer.allocate(1024);
		 FileInputStream fis = new FileInputStream(srcName);
		 FileOutputStream fos = new FileOutputStream(desName);
		 FileChannel channel1 = fis.getChannel();
		 FileChannel channel2 = fos.getChannel();
		 while(true) {
			 int num=channel1.read(buffer);
			 if(num==-1) break;
			 buffer.flip();
			 channel2.write(buffer);
			 buffer.clear();
		 }
		 channel1.close();
		 channel2.close();
		 long t2=System.nanoTime();
		 System.out.println((t2-t1)/1E9);
	 }
	 
	//利用nio包中的MappedByteBuffer
	 static  void  fileCopy5(String srcName,String desName)throws Exception {
		 long t1=System.nanoTime();
		 FileInputStream fis = new FileInputStream(srcName);
		 FileOutputStream fos = new FileOutputStream(desName);
		 FileChannel channel1 = fis.getChannel();
		 FileChannel channel2 = fos.getChannel();
		 MappedByteBuffer  buffer = channel1.map(FileChannel.MapMode.READ_ONLY, 0, channel1.size());  
		 channel1.close();
		 channel2.close();
		 long t2=System.nanoTime();
		 System.out.println((t2-t1)/1E9);
	 }
	 
	 //利用nio包      所有拷贝中最快的方法
	 static  void  fileCopy6(String srcName,String desName)throws Exception {
		 long t1=System.nanoTime();
		 FileInputStream fis = new FileInputStream(srcName);
		 FileOutputStream fos = new FileOutputStream(desName);
		 FileChannel channel1 = fis.getChannel();
		 FileChannel channel2 = fos.getChannel();
		 
		 channel1.transferTo(0, channel1.size(), channel2);
		 channel1.close();
		 channel2.close();
		 long t2=System.nanoTime();
		 System.out.println((t2-t1)/1E9);
		 
	 }
}
