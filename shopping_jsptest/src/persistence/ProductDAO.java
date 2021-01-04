package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.ProductVO;
import static persistence.JDBCUtil.*;

public class ProductDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ProductDAO(Connection con) {
		this.con = con;
	}
	
	//product insert
	
	public int insertProd(ProductVO vo) {
		int result =0;
		String sql="insert into productTBL(num,category,name,content,psize,color,amount,price) values(prod_seq.nextval,?,?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getPsize());
			pstmt.setString(5, vo.getColor());
			pstmt.setInt(6, vo.getAmount());
			pstmt.setInt(7, vo.getPrice());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//product 상품조회
	
	public List<ProductVO> getProdList(){
		
		List<ProductVO> list = new ArrayList<ProductVO>();
		try {
			if(con!=null) {
				String sql = "select * from productTBL order by num desc";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					ProductVO vo = new ProductVO();
					vo.setNum(rs.getInt(1));
					vo.setCategory(rs.getString(2));
					vo.setName(rs.getString(3));
					vo.setContent(rs.getString(4));
					vo.setPsize(rs.getString(5));
					vo.setColor(rs.getString(6));
					vo.setAmount(rs.getInt(7));
					vo.setPrice(rs.getInt(8));
					vo.setDate(rs.getDate(9));
					list.add(vo);		
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}return list;

	}
}


