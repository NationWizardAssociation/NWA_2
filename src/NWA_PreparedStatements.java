import java.sql.*;

import org.sqlite.JDBC;

import java.util.Scanner;

public class NWA_PreparedStatements {

	
	static Scanner scan = new Scanner(System.in);
	Connection connection;
    
	
	public NWA_PreparedStatements(){
		
		
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:NWA.db");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	
	public String genericStatement(String s){
		String[] statement = s.split(" ");
		if(statement[0].equals("SELECT")){
			return genericSelect(statement); 
		}
		else if(statement[0].equals("INSERT"))
			return genericInsert(statement);
		else if(statement[0].equals("UPDATE"))
			return genericUpdate(statement);
		else return "Invalid Query";
	}
	
	public String genericSelect(String[] statement){
		
	}
	public String genericInsert(String[] statement){
		
	}
	public String genericUpdate(String[] statement){
		
	}
	public void executeGenericStatement(String s){
		
	}
	
	
    
	public void findWizardByName(){
	try {
		while(true){
		
	  String name = " ";
	  
	  System.out.println("Enter Wizard Name");
	    name = scan.nextLine();
	    System.out.println(name);
		String stm1 = "SELECT WIZname, WIZguild, WIZspellset, WIZlevel FROM wizard WHERE WIZname = ?"; //???? does not return price values if price == ?, ORDER BY does not do anything
	    PreparedStatement p;
		
		p = connection.prepareStatement(stm1);
		//System.out.print(price + " " + order);
	    p.clearParameters();
	    p.setString(1, name);
	    ResultSet r = p.executeQuery();
		while(r.next()) {
			System.out.println("name: " + r.getString("WIZname"));
			System.out.println("Guild: " + r.getInt("WIZGuild"));
			System.out.println("Specialty: " + r.getString("WIZspellset"));
			System.out.println("level: " + r.getInt("WIZlevel"));
			System.out.println("-----------------------------");
		}
		
	    System.out.println("Enter another value?(y/n): ");
	    String exit = scan.next();
	    if(exit.equals("n")){
	       break;
	    }
	  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
    
	public void listGuildWizards(){
		try {
		  while(true){
				
		  int id = 0;
		  
		  System.out.println("Enter guild ID");
		    id = scan.nextInt();
			String stm1 = "SELECT WIZname, WIZspellset, WIZlevel FROM wizard WHERE WIZguild = ? ";
		    PreparedStatement p;
			p = connection.prepareStatement(stm1);
		    p.clearParameters();
		    p.setInt(1, id);
		    ResultSet r = p.executeQuery();
			while(r.next()) {
				System.out.println("name: " + r.getString("WIZname"));
				System.out.println("Specialty: " + r.getString("WIZspellset"));
				System.out.println("level: " + r.getInt("WIZlevel"));
				System.out.println("-----------------------------");
			}
			
		    System.out.println("Enter another value?(y/n): ");
		    String exit = scan.next();
		    if(exit.equals("n")){
		       break;
		    }
		  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void guildByMembers(){
		
		try {
					
				String stm1 = "SELECT GUILDname, GUILDid, COUNT(*) FROM guild, wizard WHERE WIZguild = guildID GROUP BY GUILDid ORDER BY COUNT(*)";
			    PreparedStatement p;
				p = connection.prepareStatement(stm1);
			    p.clearParameters();
			    ResultSet r = p.executeQuery();
				while(r.next()) {
					System.out.println("name: " + r.getString("GUILDname"));
					System.out.println("# of members: " + r.getInt("COUNT(*)"));
					System.out.println("-----------------------------");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void MVP(){
		
		try {
			int guildID = 0;
			System.out.println("Find the most valuable player from which guild?");
			guildID = scan.nextInt();
			
			String stm1 = "SELECT WIZname, MAX(WIZlevel) FROM guild, wizard WHERE WIZguild = ? AND WIZlevel = "
					+ "(SELECT MAX(WIZlevel) FROM guild, wizard WHERE WIZguild = ?)";
		    PreparedStatement p;
			p = connection.prepareStatement(stm1);
		    p.clearParameters();
		    p.setInt(1, guildID);
		    p.setInt(2, guildID);
		    ResultSet r = p.executeQuery();
			while(r.next()) {
				System.out.println("name: " + r.getString("WIZname"));
				System.out.println("level: " + r.getInt("MAX(WIZlevel)"));
				System.out.println("-----------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addWizard(){		
		try {
			
			String name;
			int guild;
			int level;
			String SpellSet;
			int health;
			int atk;
			int def;
			
			System.out.println("What is your name");
			name = scan.next();
			System.out.println("What Guild are you a member of (Enter ID)?");
			guild = scan.nextInt();
			System.out.println("What is your level?");
			level = scan.nextInt();
			System.out.println("What is your Spell set?");
			SpellSet = scan.next();
			System.out.println("What is you health");
			health = scan.nextInt();
			System.out.println("What is your attackk");
			atk = scan.nextInt();
			System.out.println("What is your defense");
			def = scan.nextInt();
			
			
			
			
			String stm1 = "INSERT INTO wizard (WIZname, WIZlevel, WIZspellset, WIZhealth, WIZatk, WIZdef, WIZGuild) VALUES (?, ?, ?, ?, ?, ?, ?)";
					
		    PreparedStatement p;
			p = connection.prepareStatement(stm1);
		    p.clearParameters();
		    p.setString(1, name);
		    p.setInt(2, level);
		    p.setString(3, SpellSet);
		    p.setInt(4, health);
		    p.setInt(5, atk);
		    p.setInt(6, def);
		    p.setInt(7, guild);
		    p.executeUpdate();
			
		    System.out.println("You have been added to the NWA");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

