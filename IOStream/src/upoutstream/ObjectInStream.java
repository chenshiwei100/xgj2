package upoutstream;

import java.io.*;


public class ObjectInStream {
	
	public static void main(String[] args) throws Exception {
		 Student s1 = new  Student("�칫�", 161164205, 21);
		 Student s2 = new  Student("����", 161164666, 21);
		//FileOutputStream fos = null;
		//ObjectOutputStream  out = null;
		FileInputStream fis = null;
		ObjectInputStream  in = null;
		try {
			
			
		/*
		     //��֪�����ܼ�������ʱ һ��һ������ 
        	 fos = new FileOutputStream("student.dat");
			  out = new ObjectOutputStream(fos);
			out.writeObject(s1);
			out.writeObject(s2); */
			
			/*fis = new FileInputStream("student.dat");
			in = new ObjectInputStream(fis);
			Object o1=in.readObject();
			Object o2=in.readObject();
			System.out.println(o1);
			System.out.println(o2);
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
	
			try {
				in.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}

	}*/
			//��ѭ������  ��Ϊ��֪��Ҫ���ռ������������쳣����
			fis = new FileInputStream("student.dat");
			in = new ObjectInputStream(fis);
			while(true) {
				try {
					Object o1 = in.readObject();
					System.out.println(o1);
				} catch (EOFException e) {
					System.out.println("�������");
					break;
				}
				
			}
	
	

		}finally {
	
			try {
				in.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}

	}

}
class Student implements Serializable{
	String name;
	int id;
	int age;
	public Student(String name, int id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", age=" + age + "]";
	}
	
	
}