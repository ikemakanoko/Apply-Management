package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Todo;
import com.example.app.mapper.ToDoMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class TaskController {

	private final ToDoMapper toDoMapper;

	//一覧
	@GetMapping("/toDolist")
	public String list(Model model) {
		List<Todo> todoLists = toDoMapper.selectAll();
		model.addAttribute("Todo", todoLists);
		return "toDolist";
	}

	//ToDoList新規登録
	@GetMapping("/add")
	public String addGet(Model model) {
		//タスクの追加を押したら新規登録できる仕様にしたい
		//新規登録したオブジェクトを、HTMLの未実行タスクのところに移動させる
		model.addAttribute("todo", new Todo());
		return "add";
	}

	//エラーハンドリング、バリデーション(新規追加)
	@PostMapping("/add")
	public String addPost(
			@Valid Todo todo,
			Errors errors,
			Model model) {
		System.out.println("エラー数:　" + errors.getErrorCount());

		// エラーの詳細を調べる
		errors.getAllErrors().forEach(System.out::println);

		// エラーがある場合、元のフォームに戻す
		if (errors.hasErrors()) {
			model.addAttribute("todo", todo); // 入力された値を維持
			return "add";
		}
		//System.out.println(appliedCompanyList);
		// バリデーションが通った場合はデータを保存
		toDoMapper.add(todo);
		return "redirect:/adddone"; // 完了ページに遷移
	}
	
	@GetMapping("/adddone")
	public String addDone() {
	    return "adddone";  // adddone.htmlページに遷移
	}

	//	// 編集処理
	//	@GetMapping("/update")
	//	public String updateGet(@PathVariable("id") Integer id, Model model) {
	//		Todo todo = toDoMapper.selectById(id);
	//		model.addAttribute("todo", todo);
	//		return "update"; // ビュー名
	//
	//	}

}
