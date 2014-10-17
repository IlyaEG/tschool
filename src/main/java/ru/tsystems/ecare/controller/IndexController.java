package ru.tsystems.ecare.controller;

import java.util.ArrayList;
import java.util.List;

import ru.tsystems.ecare.persistence.entities.Option;
import ru.tsystems.ecare.services.OptionService;
import ru.tsystems.ecare.services.OptionServiceImpl;

public class IndexController extends AbstractController {

	@Override
	public void execute() {
//		OptionService optService = new OptionServiceImpl();
//		List<Option> allOptions = optService.getAllOptions();
//		List<String> optionsNames = new ArrayList<String>();
//		for (Option o : allOptions) {
//			optionsNames.add(o.getName());
//		}

//TODO		http://www.java-only.com/LoadTutorial.javaonly?id=13
		String optionsNames = "name1";
		
		this.setReturnPage("/index.jsp");
		
		this.getRequest().setAttribute("allOptions", optionsNames);

	}

}
