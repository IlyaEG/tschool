package ru.tsystems.ecare.controller;

public class LoginController extends AbstractController {

	@Override
	public void execute() {
		// OptionService optService = new OptionServiceImpl();
		// List<Option> allOptions = optService.getAllOptions();
		// List<String> optionsNames = new ArrayList<String>();
		// for (Option o : allOptions) {
		// optionsNames.add(o.getName());
		// }

		// TODO http://www.java-only.com/LoadTutorial.javaonly?id=13
		String optionsNames = "name1";

		this.setReturnPage("/controlPanel.jsp");

		this.getRequest().setAttribute("allOptions", optionsNames);

	}

}
