package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class User {
	@Getter @Setter
	private int userId;

	@Getter @Setter
	private String userName;

	@Getter @Setter
	private String password;

	@Getter @Setter
	private String email;

}
