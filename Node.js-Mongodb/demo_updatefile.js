var fs = require('fs');

fs.appendFile('mynewfile1.txt', 'This is updated text.', function(err){
    if (err) throw err;
    console.log('Saved!');
});