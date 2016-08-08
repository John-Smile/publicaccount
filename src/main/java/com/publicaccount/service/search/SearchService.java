package com.publicaccount.service.search;

import com.publicaccount.service.search.dto.BookDTO;

/***
 * 检索文档
 *
 */
public interface SearchService {
	
	/***
	 * 检索文档是否存在
	 * @param fileName
	 * @return
	 */
	boolean searchFile(String fileName);
	
	/***
	 * 获取文档
	 * @param fileName
	 * @return
	 */
	BookDTO getFile(String fileName);

}
