package ru.tsystems.ecare.controller;

public class ControllerFactory {
	
	public static final Controller getControllerByClass(Class actionCLass) {
		try {
			Controller controller = (Controller) actionCLass.newInstance();
			return controller;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static final Controller getControllerByFullClassName(String className) {
		try {
			String name = "ru.tsystems.ecare.controller." + className + "Controller";
			Class actionClass = Class.forName(name);
			return getControllerByClass(actionClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
