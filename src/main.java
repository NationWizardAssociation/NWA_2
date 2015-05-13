import java.sql.*;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;
public class main {
	
	
	final static Scanner scan = new Scanner(System.in);
	
	  public static void main(String[] args) throws ClassNotFoundException{
		 // JFrame g = new GUI();
		//  g.setTitle("NWA");
		//  g.setVisible(true);
	  //	  g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  
		  NWA_PreparedStatements s = new NWA_PreparedStatements();
		  
		  String m = "name,John Wall,level,5";
		  
		  s.searchWizard(m);
		  
		  
		 // s.findWizardByName();
		  //s.listGuildWizards();
		  //s.guildByMembers();
		  //s.addWizard();
		  //s.findWizardByName();
		  
		  
		  
		  
	  }
	   
}
