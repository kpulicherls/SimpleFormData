import java.util.*;
import java.sql.*;

public class InfoDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Info e){
		int status=0;
		try{
			Connection con=InfoDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into data123(name,phno,email) values (?,?,?)");
			ps.setString(1,e.getName());
			ps.setString(2,e.getPhno());
			ps.setString(3,e.getEmail());
	
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
}
