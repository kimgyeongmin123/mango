package Ch22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class C02ReadLineEx {
	
	public static void main(String[] args) throws Exception{
		
//		Writer out = new FileWriter("c:\\iotest\\test.txt");
//		BufferedWriter bout = new BufferedWriter(out);
		
		Reader in = new FileReader("c:\\iotest\\test.txt");
		BufferedReader bin = new BufferedReader(in);
		
		while(true)
		{
			String str = bin.readLine();
			if(str==null) break;
			System.out.println(str);
		}
		
		
		
		
		
	}

}
