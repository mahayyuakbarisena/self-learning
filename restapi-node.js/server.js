const http = require('http');
const app = require('./app');
const port =  process.env.PORT || 3000;
const server = http.createServer(app);

server.listen(port);

//use "npm start" on command line to start the server using nodemon