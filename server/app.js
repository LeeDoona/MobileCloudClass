var Leaderboard = require('leaderboard');
var board = new Leaderboard('board');

var express = require('express');
var app = express();

var crossdomain = require('crossdomain');
var xml = crossdomain({domain:'*'});

app.get('/new', function (req, res) {
  console.log(req.body.id);

  board.add(req.body.id, req.body.score, function(err) {
    board.rank(req.body.id, function (err,rank) {
      board.total(function(err, number) {
        console.log('total numbers : '+number);
      var row = 
        {"rank":rank+1,
        "total":number};
        res.json(row);
      });
    });
  });
});

app.listen(3000, function () {
  console.log('Example app listening on port 3000!');
});
