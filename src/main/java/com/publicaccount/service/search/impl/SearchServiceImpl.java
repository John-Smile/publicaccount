package com.publicaccount.service.search.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.publicaccount.dao.entity.Book;
import com.publicaccount.dao.entity.BookContent;
import com.publicaccount.dao.entity.BookExample;
import com.publicaccount.dao.mapper.BookContentMapper;
import com.publicaccount.dao.mapper.BookMapper;
import com.publicaccount.service.search.SearchService;
import com.publicaccount.service.search.dto.BookDTO;

@Service
public class SearchServiceImpl implements SearchService {
	@Resource
	private BookMapper bookMapper;
	@Resource
	private BookContentMapper bookContentMapper;
	

	@Override
	public boolean searchFile(String fileName) {
		List<Book> books = getBooksByName(fileName);
		boolean res = !books.isEmpty();
		return res;
	}

	@Override
	public BookDTO getFile(String fileName) {
		Book book = getBooksByName(fileName).get(0);
		BookContent bookContent = getBookContent(book.getContentId());
		if (bookContent == null) {
			String msg = String.format("获取《%s》失败", fileName);
			throw new RuntimeException(msg);
		} else {
			return new BookDTO(book.getTitle(), book.getContentType(), bookContent.getContent());
		}
	}
	
	private BookContent getBookContent(Long contentId) {
		BookContent bookContent = bookContentMapper.selectByPrimaryKey(contentId);
		return bookContent;
	}

	private List<Book> getBooksByName(String fileName) {
		BookExample example = new BookExample();
		BookExample.Criteria criteria = example.createCriteria();
		criteria.andTitleLike("%" + fileName +"%");
		List<Book> books = bookMapper.selectByExample(example);
		return books;
	}

}
