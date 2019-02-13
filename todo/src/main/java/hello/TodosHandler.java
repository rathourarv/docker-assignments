package hello;

import java.io.*;

public class TodosHandler {

    private String filePath;

    TodosHandler() {
        filePath = "./data.json";
    }

    public String readTodos() {
        BufferedReader br = null;
        FileReader fr = null;
        String str;
        StringBuilder todos = new StringBuilder();
        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            while ((str = br.readLine()) != null) {
                todos.append(str);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return todos.toString();
    }

    public void writeTodos(String json) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(json);
        writer.close();
    }
}
