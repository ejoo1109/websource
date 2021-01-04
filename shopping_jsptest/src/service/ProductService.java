package service;

import java.util.List;

import domain.ProductVO;

public interface ProductService {
	public boolean insertProd(ProductVO vo);
	public List<ProductVO> getProdList();
}
