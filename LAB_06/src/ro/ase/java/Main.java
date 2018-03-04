package ro.ase.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	
	public static void main(String[] args) {
		
		Student s = new Student("GIGEL", 25);
		try {
			ObjectOutputStream sout = new ObjectOutputStream(
					new FileOutputStream("test.txt"));
			sout.writeObject(s);
			sout.flush();
			sout.close();
			System.out.println("S-a scris in fisier");
			
			FileInputStream fin = new FileInputStream("test.txt");
			ObjectInputStream sin = new ObjectInputStream(fin);
			
			Student s1 = (Student) sin.readObject();
			System.out.println(s1.toString());
			sin.close();
			fin.close();
			System.out.println("S-a citit din fisier");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
