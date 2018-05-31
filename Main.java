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
    			//此处调用字符数统计函数
    			BasicCount.count(args[args.length-1]);
    			System.out.println("字符数"+BasicCount.getCharacterNumber());
    		}
    		else if(order.equals("-w")) {
    			//此处调用单词数统计函数
    			BasicCount.count(args[args.length-1]);
    			System.out.println("单词数"+BasicCount.getWordNumber());
    		}
    		else if(order.equals("-l")) {
    			//此处调用行数统计函数
    			BasicCount.count(args[args.length-1]);
    			System.out.println("行数"+BasicCount.getLineNumber());
    		}
    		else if(order.equals("-a")) {
    			//此处调用Check类的checkMore()方法
    			Check.checkMore(new File(args[args.length-1]));
    		}
		}
	}
}