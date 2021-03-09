import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class MiniProg_1 {
	public static HashMap<String, String> parseState(File fr, char a1,char a2) throws FileNotFoundException
{
    Scanner sc=new Scanner(fr);
    String s2=String.valueOf(a1);
    String s[]=sc.next().split(s2);
    HashMap<String, String> hs=new HashMap<String, String>();
    String s3=String.valueOf(a2);
    for(int k=0;k<s.length;k++) {
	  String s1[]=s[k].split(s3);
        hs.put(s1[0], s1[1]);
        }
    return hs;
}
public static void main(String a[]) throws FileNotFoundException
{
	Scanner s1=new Scanner(System.in);
	System.out.println("Enter the file name");
	File fr1=new File(s1.next());
	System.out.println("Enter the two symbols");
	char c=s1.next().charAt(0);
	char c1=s1.next().charAt(0);
	 System.out.println("CONTENT OF MAP");
	 HashMap<String, String> hs=parseState(fr1, c1, c);
	 Set l=hs.entrySet();
     Iterator i=l.iterator();
     while(i.hasNext())
     {
    	 Map.Entry m=(Map.Entry)i.next();
    	 System.out.println(m.getKey()+"-"+m.getValue());
     }
}
}

