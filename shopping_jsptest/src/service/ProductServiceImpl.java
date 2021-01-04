package service;

import java.sql.Connection;

import java.util.List;

import domain.ProductVO;
import persistence.ProductDAO;

import static persistence.JDBCUtil.*;

public class ProductServiceImpl implements ProductService {
	Connection con;
	ProductDAO dao;
	
	public ProductServiceImpl() {
		con = getConnection();
		dao = new ProductDAO(con);
	}
	@Override
	public boolean insertProd(ProductVO vo) {
		int result = dao.insertProd(vo);
		boolean insertFlag = false;
		
		if(result>0) {
			insertFlag = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return insertFlag;
	}

	@Override
	public List<ProductVO> getProdList() {
		List<ProductVO> list = dao.getProdList();
		close(con);
		return list;
	}

}
