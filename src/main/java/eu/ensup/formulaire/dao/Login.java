package eu.ensup.formulaire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import eu.ensup.formulaire.domaine.Conseiller;




public class Login {

	public static List<Conseiller> loginConseiller(String login,String pwd){

		List<Conseiller>listConseiller = new ArrayList();
		//take a list to store the values which are in db
		try{  
			Connection con= AccesBd.seConnecter();  
			PreparedStatement ps=con.prepareStatement("select * from personnelbanque where login=? and pwd=?");  
			ps.setString(1,login);  
			ps.setString(2,pwd);
			ResultSet rs =ps.executeQuery();  
			if(rs.next()){  				
				Conseiller conseiller = new Conseiller(); 
				conseiller.setLogin(rs.getString(1));  
				conseiller.setPwd(rs.getString(2)); 											
				listConseiller.add(conseiller);
			}  
			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return listConseiller;

	}
}
