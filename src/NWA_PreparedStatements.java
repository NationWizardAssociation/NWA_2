import java.sql.*;

import org.sqlite.JDBC;

import java.util.Scanner;

public class NWA_PreparedStatements {

	
	static Scanner scan = new Scanner(System.in);
	Connection connection;
	String genS = "";
    String genADD = "";
	
	public NWA_PreparedStatements(){
		
		
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:NWA.db");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void searchWizard(String s){
		try {
		String q = "";
		String name;
		String spellset;
		String level;
		
		String[] atr = s.split(",");
		
		boolean and = false;
		for(int i = 0; i < atr.length; i++){
			
			if(atr[i].equals("name")){
				q = q + ("WIZname = " +"'" + atr[++i] +"'");
				if(i != atr.length-1){
					and = true;
				}
			}
			else if(atr[i].equals("spellset")){
				if(and){
					q = q + " AND ";
				}
				q = q + ("WIZspellset = " + "'" + atr[++i] + "'");
				if(i != atr.length-1){
					and = true;
				}
			}
			else if(atr[i].equals("level")){
				if(and){
					q = q + " AND ";
				}
				q = q + ("WIZlevel = " + atr[++i]);
				if(i != atr.length-1){
					and = true;
				}
			}
			
		}
		
		System.out.println(q);
		String stmt = "SELECT WIZname, WIZguild, WIZlevel, WIZspellset, WIZhealth, WIZatk, WIZdef FROM wizard WHERE " + q;
		PreparedStatement p = connection.prepareStatement(stmt);
	
		ResultSet r = p.executeQuery();
		
		while(r.next()) {
			System.out.println("name: " + r.getString("WIZname"));
			System.out.println("Guild: " + r.getInt("WIZguild"));
			System.out.println("level: " + r.getInt("WIZlevel"));
			System.out.println("Specialty: " + r.getString("WIZspellset"));
			System.out.println("health: " + r.getInt("WIZhealth"));
			System.out.println("attack: " + r.getInt("WIZatk"));
			System.out.println("defense: " + r.getInt("WIZdef"));
			System.out.println("-----------------------------");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(q);
		

		
		
		
		
		
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

