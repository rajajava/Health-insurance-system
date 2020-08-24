package com.his.utiltemppwd;

import com.his.constance.AppConstants;

public class TempPazzword {
	 
	
	public static String generateTempPazzword(int count) {
		
		StringBuilder builder=new StringBuilder();
		while(count--!=0) {
			int charcter= (int) (Math.random() * AppConstants.ALPHA_NUMERIC_STRING.length());
			builder.append(AppConstants.ALPHA_NUMERIC_STRING.charAt(charcter));
		}
		 return  builder.toString();
	}
}
