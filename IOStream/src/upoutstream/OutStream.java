package upoutstream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutStream {
	public static void main(String[] args) {
		OutputStream  out=null;
		String s="ABCDEFJHIJKLMNOPQRSTUVWXYZ";
		byte[] bs=s.getBytes();//���ַ�������ַ�����
          try {
          out = new FileOutputStream("a.txt");
            //out.write(65);//дһ��A��ĸ
			  out.write(bs);
			
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
          
	}


}
