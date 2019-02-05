FROM node:alpine

WORKDIR /src/app

COPY package*.json .

RUN npm install

COPY . .

EXPOSE 3000/tcp

ENTRYPOINT ["node", "app.js"]
