FROM gradle:5.2.0-jdk11

USER root

WORKDIR /src/app/

COPY . ./

CMD ["gradle","-t","build", "bootrun"]