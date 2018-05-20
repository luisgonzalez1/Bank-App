package com.revature.launcher;

 
import com.revature.prompts.Login;
import com.revature.prompts.Prompt;
import com.revature.prompts.mainMenu;

public class Launcher {

	public static void main(String[] args) {
		Prompt currentPromp = new Login();
		while(true) {
			currentPromp = currentPromp.run();
		}
	}

}
