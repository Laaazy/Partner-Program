package wc;
//��Ӧ-s����
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Traversal {
	public static void read(String fileDir,String[] orders) throws IOException {
		List<File> fileList=new ArrayList<File>();
		//System.out.println(file1.getName());
		//System.out.println(file1.getPath());
		File file2 =new File(fileDir);
        File[] files = file2.listFiles();// ��ȡĿ¼�µ������ļ����ļ���  
        if (files == null) {// ���Ŀ¼Ϊ�գ�ֱ���˳�  
            return;  
        }  
        // ������Ŀ¼�µ������ļ�  
        for (File f : files) {  
            if (f.isFile()) {  
                fileList.add(f);  
            } else if (f.isDirectory()) {  
                //System.out.println(f.getAbsolutePath());  
                read(f.getAbsolutePath(),orders);  
            }  
        }  
        for (File f1 : fileList) {  
        	for(String order:orders) {
        		if(order.equals("-s")){
        		}
        		else if(order.equals("-c")) {
        			//�˴������ַ���ͳ�ƺ���
        			BasicCount.count(f1.getName());
        			System.out.println("�ļ���"+f1.getName());
        			System.out.println("�ַ���"+BasicCount.getCharacterNumber());
        		}
        		else if(order.equals("-w")) {
        			//�˴����õ�����ͳ�ƺ���
        			BasicCount.count(f1.getName());
        			System.out.println("������"+BasicCount.getWordNumber());
        		}
        		else if(order.equals("-l")) {
        			//�˴���������ͳ�ƺ���
        			BasicCount.count(f1.getName());
        			System.out.println("����"+BasicCount.getLineNumber());
        		}
        		else if(order.equals("-a")) {
        			//�˴�����Check���checkMore()����
        			Check.checkMore(f1);
        		}
        	}
           // System.out.println(f1.getName());//�ӿڵ���ʱ����Ϊͳ�Ʒ���  
        }  
	}
}
