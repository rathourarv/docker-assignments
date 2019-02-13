const express = require('express');
const app = express();
const http = require('http');
const bodyParser = require("body-parser");
const server = process.env.server;

app.use(bodyParser.json());

app.get('/', (req, res) => {
  res.send("hello");
})

app.get('/todos', (req, response) => {
  http.get(`${server}/todos`, (res) => {
    let rawData = '';
    res.on('data', (chunk) => { rawData += chunk; });
    res.on('end', () => {
      try {
        response.send(rawData);
      } catch (e) {
        console.error(e.message);
        response.send(e.message);

      }
    });
  }).on('error', (e) => {
    response.send(e.message);
    console.error(`Got error: ${e.message}`);
  });
});

app.put("/add", (req, res) => {
  const bodyString = JSON.stringify(req.body);
  const headers = {
    'Content-Type': 'application/json',
    'Content-Length': bodyString.length
  };
  const options = {
    host: 'todoapp',
    path: '/add',
    port: 8080,
    method: 'PUT',
    headers: headers
  };
  http.request(options, (response) => {
    if (response.statusCode === 200) {
      console.log("successful");
    } else {
      console.log("request failed", response.statusCode);
    }
    res.end();
  }).write(bodyString);
})

app.listen(3000);
