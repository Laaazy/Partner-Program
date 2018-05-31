package wc;

import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		for(String order:args) {
			if(order.equals("-s")) {
				File file=new File("");
				//File file_2=new File(file_1,"src");
				//System.out.println(file.getAbsolutePath()+"\\src");
				Traversal.read(file.getAbsolutePath()+"\\src", args);
				break;
			}
			else if(order.equals("-c")) {
    			//�˴������ַ���ͳ�ƺ���
    			BasicCount.count(args[args.length-1]);
    			System.out.println("�ַ���"+BasicCount.getCharacterNumber());
    		}
    		else if(order.equals("-w")) {
    			//�˴����õ�����ͳ�ƺ���
    			BasicCount.count(args[args.length-1]);
    			System.out.println("������"+BasicCount.getWordNumber());
    		}
    		else if(order.equals("-l")) {
    			//�˴���������ͳ�ƺ���
    			BasicCount.count(args[args.length-1]);
    			System.out.println("����"+BasicCount.getLineNumber());
    		}
    		else if(order.equals("-a")) {
    			//�˴�����Check���checkMore()����
    			Check.checkMore(new File(args[args.length-1]));
    		}
		}
	}
}