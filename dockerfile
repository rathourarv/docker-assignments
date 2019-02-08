FROM node:alpine

WORKDIR /src/app

COPY package*.json ./

RUN npm install \
  && npm install nodemon -g

COPY . .

EXPOSE 3000/tcp

ENTRYPOINT ["nodemon", "app.js"]
