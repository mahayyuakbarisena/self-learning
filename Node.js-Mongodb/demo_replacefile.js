var fs = require('fs');
fs.writeFile('mynewfile3.txt', 'This file already replaced', function(err){
    if (err) throw err;
    console.log('Replaced!');
});