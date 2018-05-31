package wc;
//��Ӧ-a����
import java.io.*;

public class Check {
	 private static int whiteLines = 0;  //�հ���
	 private static int commentLines = 0;  //ע����
	 private static int normalLines = 0;  //������
	
	 public static void checkMore(File file) {   
	        BufferedReader br = null;   
	        boolean comment = false;  //ע���б�־���� 
	        try {   
	            br = new BufferedReader(new FileReader(file));   
	            String line = "";   
	            try {   
	                while ((line = br.readLine()) != null) {   
	                    line = line.trim();   
	                    if (line.matches("^[\\s&&[^\\n]]*$")) {   //����ƥ��
	                        whiteLines++;   
	                    } else if (line.startsWith("/*") && !line.endsWith("*/")) {   //����ע��
	                        commentLines++;   
	                        comment = true;   
	                    } else if (true == comment) {   
	                        commentLines++;   
	                        if (line.endsWith("*/")) {   
	                            comment = false;   
	                        }   
	                    } else if (line.startsWith("//")||(line.startsWith("/*")&&line.endsWith("*/"))) {  //  //��/**/�ĵ���ע�� 
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
	                    System.out.println("��������"+whiteLines);  
	                    System.out.println("ע��������"+commentLines);  
	                    System.out.println("����������"+normalLines);  
	                    br.close();   
	                    br = null;   
	                } catch (IOException e) {   
	                    e.printStackTrace();   
	                }   
	            }   
	        }   
	    }  
}
