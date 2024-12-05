package com.example.app.domain;

import lombok.Data;

@Data
public class Todo {
	private int id;
	private String task;
	private String executed;
	private String unexecuted;
}
