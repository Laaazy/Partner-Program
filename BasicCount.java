package wc;
import java.io.*;
public class BasicCount {

	private static int characterNumber=1;//字符数
	private static int wordNumber=1;//单词数
	private static int lineNumber=0;//行数

	public static void count(String fileName)throws IOException
	{
		int c=0;
		boolean lastNotWhite=false;
		String WhiteSpace="\t\n\r";
		File file=new File(fileName);
		Reader reader=new InputStreamReader(new FileInputStream(file));
		while((c=reader.read())!=-1)
		{
			characterNumber++;
			if(c=='\n') {
				lineNumber++;
			}
			if(WhiteSpace.indexOf(c)!=-1)
			{
				if(lastNotWhite)
				{
					wordNumber++;
				}
			}
			else {
					lastNotWhite=true;
				}
		}
		return;
	}
   public static int getCharacterNumber()
   {
	   return characterNumber;
   }
   public static int getWordNumber()

   {
	   return wordNumber;
   }
   public static int getLineNumber()
   {
	   return lineNumber;
   }
}