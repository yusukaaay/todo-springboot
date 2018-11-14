package jp.co.springboot.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import jp.co.springboot.todo.model.TaskDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TaskControllerTest {

  @Autowired
  private TaskController controller;

  @Test
  public void test() {
    TaskDto taskDto = new TaskDto();
    taskDto.setLabel("aiueo");
    controller.newTask(taskDto);

    TaskDto taskDto2 = new TaskDto();
    taskDto2.setLabel("kakikuk");
    controller.newTask(taskDto2);

    controller.getTask();
  }

}
