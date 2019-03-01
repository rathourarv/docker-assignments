package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping("/")
    public String index() {
        return "Hello world";
    }

    @RequestMapping("/todos")
    public String todos() {
        return todoRepository.findAll().toString();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Todo todo) {
        System.out.println(todo+"------------");
        todoRepository.save(todo);
    }
}