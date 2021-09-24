package me.NotPlatzer.Infinity.ui;

import java.awt.Color;

public class Rainbow {

	public static int rainbow(String opacaty) {
		
		// a for loop that loops until all the colors have been shown
		
		int r = 0;
		int g = 0;
		int b = 0;
				
		int i = 0;
		while(i < 765) {
			
			 if(r > 0 && b == 0){
				    r--;
				    g++;
				  }
				  if(g > 0 && r == 0){
				    g--;
				    b++;
				  }
				  if(b > 0 && g == 0){
				    r++;
				    b--;
				  }
				  
				  Color your_color = new Color(r,g,b);

				  String hex = "0x"+ opacaty + Integer.toHexString(your_color.getRGB()).substring(2);
				  i++;
			return Integer.parseInt(hex);
			
		}
		
		return -1;
	}
}
