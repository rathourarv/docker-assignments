FROM gradle:jre-alpine

WORKDIR /src/app/

COPY build/libs/todo-0.0.1-SNAPSHOT.jar todo.jar

CMD ["java","-jar","./todo.jar"]
