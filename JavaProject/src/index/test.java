package index;

import java.util.Random;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random ran = new Random();
		String str1 = System.getProperty("user.dir") + "\\image\\surfacelayerfloor";
		String str2 = ".jpg";
		
		System.out.println(ran.nextInt(3)+1);
		System.out.println(str1+ran.nextInt(3)+1+str2);
		System.out.println(str1+ran.nextInt(3)+1+str2);
		System.out.println(str1+ran.nextInt(3)+1+str2);
		
	}

}
