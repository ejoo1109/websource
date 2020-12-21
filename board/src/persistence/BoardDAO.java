package persistence;
import static persistence.JDBCUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDAO(Connection con) {
		this.con=con;
	}
	
	//CRUD
}
