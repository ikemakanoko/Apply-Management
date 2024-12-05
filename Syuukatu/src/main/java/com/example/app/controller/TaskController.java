package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Todo;
import com.example.app.mapper.ToDoMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class TaskController {

	private final ToDoMapper toDoMapper;

	//一覧
	@GetMapping("/toDolist")
	public String list(Model model) {
		// "top" は src/main/resources/templates/top.html に対応
		List<Todo> todoLists = toDoMapper.selectAll();
		model.addAttribute("Todo", todoLists);
		//System.out.println(appliedCompanies);
		return "toDolist";
	}

	//ToDoList新規登録
	@GetMapping("/add")
	public String addGet(Model model) {
		model.addAttribute("todo", new Todo());
		return "/add";
	}

	//	// 編集処理
	//	@GetMapping("/toDolist/update")
	//	public String updateGet(@PathVariable("id") Integer id, Model model) {
	//		Todo todo = toDoMapper.selectById(id);
	//		model.addAttribute("todo", todo);
	//		return "update"; // ビュー名
	//
	//	}

}
