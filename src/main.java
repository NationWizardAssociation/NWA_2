import java.sql.*;
import java.util.Scanner;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;
public class main {
	
	
	final static Scanner scan = new Scanner(System.in);
	
	  public static void main(String[] args) throws ClassNotFoundException{
		  /*GUI g = new GUI();
		  g.setTitle("NWA");
		  g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
		  */
		  
		  NWA_PreparedStatements s = new NWA_PreparedStatements();
		  
		  s.findWizardByName();
		  s.listGuildWizards();
		  s.guildByMembers();
		  s.addWizard();
		  s.findWizardByName();
		  
		  
		  
		  
	  }
	   
}
