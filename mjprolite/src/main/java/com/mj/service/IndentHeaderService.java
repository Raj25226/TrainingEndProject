package com.mj.service;

import java.util.List;

import com.mj.vo.IndentHeaderVO;

public interface IndentHeaderService {
	
	List<IndentHeaderVO> getAllIndentHeader();	
	IndentHeaderVO getIndentHeaderById(Integer id);
	void saveIndentHeader(IndentHeaderVO indentHeaderVO);
	Boolean updateIndentHeader(IndentHeaderVO indentHeaderVO);
	Boolean deleteIndentHeaderById(Integer id);
	IndentHeaderVO getIndentHeaderByDescription(String description);
	Integer editIndentHeaderPrice(Long price,Integer id);
}
