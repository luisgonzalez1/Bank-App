package com.revature.launcher;

 
import com.revature.prompts.CreateUser;
import com.revature.prompts.Login;
import com.revature.prompts.Prompt;
import com.revature.prompts.mainMenu;

public class Launcher {

	public static void main(String[] args) {
		Prompt currentPromp = (Prompt) new Login();
		while(true) {
			currentPromp = currentPromp.run();
			 //(Prompt) new Login()
		}
	}

}
