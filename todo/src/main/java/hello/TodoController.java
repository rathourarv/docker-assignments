package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TodoController {

    @RequestMapping("/")
    public String index() {
        return "Hello!";
    }

    @RequestMapping("/todos")
    public String todos() {
        return "{todo1:'new todo',todo2:'new todo 2'}";
    }

}