var express = require('express');
var app = express();
 
app.get('/', function (req, res) {
   res.send('Hello World');
})

app.get('/advices/hot', function (req, res) {
   res.send('[{"name":"万科A from nodejs"}]');
})

app.get('/echo', function (req, res) {
   res.send('echo from nodejs advisor ;-)\n');
})


app.get('/echo/provider', function (req, res) {
    var request = require('request');
    request('http://stock-provider:80/echo', function (error, response, body) {
      if (!error && response.statusCode == 200) {
        console.log(body);
        res.send('echo provider from NODEJS ADVISOR:' + body);
      }
    })
})


var server = app.listen(9002, function () {
 
  var host = server.address().address
  var port = server.address().port
 
  console.log("应用实例，访问地址为 http://%s:%s", host, port)
 
})