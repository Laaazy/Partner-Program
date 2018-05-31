package wc;
//对应-a参数
import java.io.*;

public class Check {
	 private static int whiteLines = 0;  //空白行
	 private static int commentLines = 0;  //注释行
	 private static int normalLines = 0;  //代码行
	
	 public static void checkMore(File file) {   
	        BufferedReader br = null;   
	        boolean comment = false;  //注释行标志变量 
	        try {   
	            br = new BufferedReader(new FileReader(file));   
	            String line = "";   
	            try {   
	                while ((line = br.readLine()) != null) {   
	                    line = line.trim();   
	                    if (line.matches("^[\\s&&[^\\n]]*$")) {   //正则匹配
	                        whiteLines++;   
	                    } else if (line.startsWith("/*") && !line.endsWith("*/")) {   //多行注释
	                        commentLines++;   
	                        comment = true;   
	                    } else if (true == comment) {   
	                        commentLines++;   
	                        if (line.endsWith("*/")) {   
	                            comment = false;   
	                        }   
	                    } else if (line.startsWith("//")||(line.startsWith("/*")&&line.endsWith("*/"))) {  //  //和/**/的单行注释 
	                            commentLines++;   
	                    } else {   
	                        normalLines++;   
	                    }   
	                }   
	            } catch (IOException e) {   
	                    e.printStackTrace();   
	            }   
	        } catch (FileNotFoundException e) {   
	                e.printStackTrace();   
	        } finally {   
	            if (br != null) {   
	                try {   
	                    System.out.println("空行数："+whiteLines);  
	                    System.out.println("注释行数："+commentLines);  
	                    System.out.println("代码行数："+normalLines);  
	                    br.close();   
	                    br = null;   
	                } catch (IOException e) {   
	                    e.printStackTrace();   
	                }   
	            }   
	        }   
	    }  
}
