package jp.co.springboot.todo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jp.co.springboot.todo.model.Task;

@RestController
public class TaskController {
  @RequestMapping("/test1")
  public String write1() {
    return "Hello World1";
  }

  @RequestMapping("/getTask")
  public Task getTask() {
    Task task = new Task();
    task.setId(1L);
    task.setLabel("ラベル");
    return task;
  }

  // public List<Task> getAllTasks() {
  // return
  // }
}
