package PPJ.FirstSemester.Cwiczenia26;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FilesTest
{
    public static void main(String []args)
    {
        try{

            //open the file
            FileInputStream fstream=new FileInputStream("/Users/michallejza/Downloads/PJWSTK/src/Cwiczenia/Cwiczenia26/FilesTest.java");//here pass the own java file name with full path

            // use DataInputStream to read binary NOT text
            // DataInputStream in=new DataInputStream(fstream);

            //
            BufferedReader br=new BufferedReader(new InputStreamReader(fstream));
            //read data line by line from the file
            String s;
            while((s = br.readLine() ) != null)
            {
                System.out.println(s);
            }
            br.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
