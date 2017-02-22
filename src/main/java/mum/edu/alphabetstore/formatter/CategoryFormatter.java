package mum.edu.alphabetstore.formatter;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import mum.edu.alphabetstore.domain.Category;
import mum.edu.alphabetstore.service.CategoryService;


public class CategoryFormatter implements Formatter<Category> {

	@Autowired
	CategoryService categoryService;
	
	@Override
	public String print(Category object, Locale locale) {
		
		return object.getName();
	}

	@Override
	public Category parse(String text, Locale locale) throws java.text.ParseException {
		
		return categoryService.getCategoryByName(text);
	}

	 
}