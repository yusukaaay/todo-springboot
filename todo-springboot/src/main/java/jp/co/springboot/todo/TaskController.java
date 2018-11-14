package jp.co.springboot.todo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jp.co.springboot.todo.model.TaskDto;
import jp.co.springboot.todo.repository.TaskEntity;
import jp.co.springboot.todo.repository.TaskRepository;

@RestController
@CrossOrigin
public class TaskController {

  @Autowired
  private TaskRepository repo;

  @RequestMapping("/test1")
  public String write1() {
    return "Hello World1";
  }

  /**
   * 全件取得
   *
   * @return
   */
  @RequestMapping("/getTask")
  public List<TaskEntity> getTask() {

    List<TaskEntity> savedEList = repo.findAll();
    return savedEList;

  }

  /**
   * 1件指定取得
   *
   * @param id
   * @return
   */
  @RequestMapping("/getTask/{id}")
  public Optional<TaskEntity> getTask(@PathVariable("id") Integer id) {

    Optional<TaskEntity> e = repo.findById(id);
    return e;

  }

  /**
   * 1件登録
   *
   * @param taskDto
   * @return
   */
  @RequestMapping(value = "/newTask", consumes = MediaType.APPLICATION_JSON_VALUE)
  public TaskEntity newTask(@RequestBody TaskDto taskDto) {
    TaskEntity taskEntity = new TaskEntity();
    taskEntity.setLabel(taskDto.getLabel());
    repo.save(taskEntity);
    return taskEntity;
  }


}
