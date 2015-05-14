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
	
	public void addGuild(String name){
		try {
			String stmt = ("SELECT MAX(GUILDid) FROM GUILD");
			PreparedStatement p = connection.prepareStatement(stmt);
			ResultSet r = p.executeQuery();
			int id = r.getInt("MAX(GUILDid)");
			id++;
		
			String stmt2 = "INSERT INTO guild (GUILDname, GUILDid, GUILDwins, GUILDlosses) VALUES (?, ?, 0, 0)";
			p = connection.prepareStatement(stmt2);
			p.setString(1, name);
			p.setInt(2, id);
			p.executeUpdate();
			
			System.out.print("Guild with name: " + name + "has been created with the id: " + id);
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateWinner(int id){
		try {
		String stmt1 = "UPDATE guild SET GUILDwins = GUILDwins + 1 WHERE GUILDid = " + id;
		
			PreparedStatement p = connection.prepareStatement(stmt1);
			p.executeUpdate();
			
			System.out.println("Wins + 1");
		
		String stmt2 = "UPDAte wizard SET WIZlevel = WIZlevel + 1 WHERE WIZguild = " + id;
		
		p = connection.prepareStatement(stmt2);
		p.executeUpdate();
		System.out.println("All wizards on team go up a level!");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateLoser(int id){
		try {
		String stmt1 = "UPDATE guild SET GUILDlosses = GUILDlosses + 1 WHERE GUILDid = " + id;
		
			PreparedStatement p = connection.prepareStatement(stmt1);
			p.executeUpdate();
			
			System.out.println("Wins -1");
		
		String stmt2 = "UPDAte wizard SET WIZlevel = WIZlevel + 1 WHERE WIZlevel < 3 AND WIZguild = " + id;
		
		p = connection.prepareStatement(stmt2);
		p.executeUpdate();
		System.out.println("Wizards with level less than 3 go up a level");
		
		
		} catch (SQLException e) {
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
	public void listGuildWizards(String s){
		try {
		 
			  
			  String q = "";
				String guildName;
				String guildID;
				
				String[] atr = s.split(",");
				
				boolean and = false;
				for(int i = 0; i < atr.length; i++){
					
					if(atr[i].equals("guildName")){
						q = q + ("GUILDname = " +"'" + atr[++i] +"' AND WIZguild = GUILDid");
						if(i != atr.length-1){
							and = true;
						}
					}
					else if(atr[i].equals("guildID")){
						if(and){
							q = q + " AND ";
						}
						q = q + ("WIZguild = " + atr[++i]);
						if(i != atr.length-1){
							and = true;
						}
					}
		  
		  
		    
			String stm1 = "SELECT WIZname, WIZspellset, WIZlevel FROM wizard, guild WHERE " + q;
		    PreparedStatement p;
			p = connection.prepareStatement(stm1);
		    p.clearParameters();
		    ResultSet r = p.executeQuery();
			while(r.next()) {
				System.out.println("name: " + r.getString("WIZname"));
				System.out.println("Specialty: " + r.getString("WIZspellset"));
				System.out.println("level: " + r.getInt("WIZlevel"));
				System.out.println("-----------------------------");
			}
			
		  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void territoriesByGuild(String s){
		
		try {
			
			String q = "";
			String guildName;
			String guildID;
			
			String[] atr = s.split(",");
			
			boolean and = false;
			for(int i = 0; i < atr.length; i++){
				
				if(atr[i].equals("guildName")){
					q = q + ("GUILDname = " +"'" + atr[++i] +"'");
					if(i != atr.length-1){
						and = true;
					}
				}
				else if(atr[i].equals("guildID")){
					if(and){
						q = q + " AND ";
					}
					q = q + ("GUILDid = "  + atr[++i]);
					if(i != atr.length-1){
						and = true;
					}
				}
			
				String stm1 = "SELECT TERRITORYlocation FROM territory, guild WHERE " + q;
			    PreparedStatement p;
				p = connection.prepareStatement(stm1);
			    p.clearParameters();
			    ResultSet r = p.executeQuery();
				while(r.next()) {
					System.out.println("Territory: " + r.getString("TERRITORYlocation"));
					System.out.println("-----------------------------");
				}
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void lossesByGuild(String s){
		
		try {
			String q = "";
			String guildName;
			String guildID;
			
			String[] atr = s.split(",");
			
			boolean and = false;
			for(int i = 0; i < atr.length; i++){
				
				if(atr[i].equals("guildName")){
					q = q + ("GUILDname = " +"'" + atr[++i] +"'");
					if(i != atr.length-1){
						and = true;
					}
				}
				else if(atr[i].equals("guildID")){
					if(and){
						q = q + " AND ";
					}
					q = q + ("GUILDid = " + atr[++i]);
					if(i != atr.length-1){
						and = true;
					}
				}
			
				String stm1 = "SELECT GUILDlosses FROM guild WHERE " + q;
			    PreparedStatement p;
				p = connection.prepareStatement(stm1);
			    p.clearParameters();
			    ResultSet r = p.executeQuery();
				while(r.next()) {
					System.out.println("Losses: " + r.getInt("GUILDlosses"));
					System.out.println("-----------------------------");
				}
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void winsByGuild(String s){
		
		try {
			String q = "";
			String guildName;
			String guildID;
			
			String[] atr = s.split(",");
			
			boolean and = false;
			for(int i = 0; i < atr.length; i++){
				
				if(atr[i].equals("guildName")){
					q = q + ("GUILDname = " +"'" + atr[++i] +"'");
					if(i != atr.length-1){
						and = true;
					}
				}
				else if(atr[i].equals("guildID")){
					if(and){
						q = q + " AND ";
					}
					q = q + ("GUILDid = " + atr[++i]);
					if(i != atr.length-1){
						and = true;
					}
				}
		}
			
				String stm1 = "SELECT GUILDwins FROM guild WHERE " + q;
			    PreparedStatement p;
				p = connection.prepareStatement(stm1);
			    p.clearParameters();
			    ResultSet r = p.executeQuery();
				while(r.next()) {
					System.out.println("Wins: " + r.getInt("GUILDwins"));
					System.out.println("-----------------------------");
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
	
	public void addWizard(String s){		
		try {
			
			String name;
			int guild;
			int level;
			String SpellSet;
			int health;
			int atk;
			int def;
			
			String[] atr
			
			
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

