package hello;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class TodoController {

    private final TodosHandler todosHandler;

    TodoController() {
        todosHandler = new TodosHandler();
    }

    @RequestMapping("/")
    public String index() {
        return "Hello world";
    }

    @RequestMapping("/todos")
    public String todos() {
        return todosHandler.readTodos();
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public void addTodo(@RequestBody String todo) throws ParseException, IOException {
        String todos = todosHandler.readTodos();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(todos);
        JSONArray arr = (JSONArray) json.get("todos");
        JSONObject newTodo = (JSONObject) parser.parse(todo);
        arr.add(newTodo);
        todosHandler.writeTodos(json.toJSONString());
    }
}