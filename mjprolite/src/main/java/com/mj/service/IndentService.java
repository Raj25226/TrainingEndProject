package com.mj.service;

import java.util.List;

import com.mj.vo.IndentVO;


public interface IndentService {
	
	List<IndentVO> getAllIndent();	
	IndentVO getIndentById(Integer id);
	void saveIndent(IndentVO indentVO);
	Boolean updateIndent(IndentVO indentVO);
	Boolean deleteIndentById(Integer id);
	Integer deleteallIndentById(Integer id);
//	IndentVO getIndentByheaderId(Integer id);
	List<IndentVO> getIndentByheaderIdAll(Integer id);

	
}
