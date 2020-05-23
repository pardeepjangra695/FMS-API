package com.trainer.FMS_API.Enum;

public enum UserType {

	SUPER_ADMIN("SUPER_ADMIN"), ADMIN("ADMIN");
	
	private String name;

	UserType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static UserType getActionNames(String name) {
		for (UserType names : UserType.values()) {
			if (name.equals(names.toString()))
				return names;
		}

		return null;
	}
	
	
}
