var http = require('http');
var formidable = require('formidable');
var fs = require('fs');

http.createServer(function(req, res){

    if(req.url == '/fileupload'){
        var form = new formidable.IncomingForm();
        form.parse(req, function(err, fields, files){
            
            var oldpath = files.filetoupload.path;
            var newpath = "D:/WORK/Tutorial Sendiri/Node js/" + files.filetoupload.name;
            var name = files.filetoupload.name;
            fs.readFile(oldpath, function (err, files) {
                if (err) throw err;
                console.log(name + ' uploaded!');
    
                // Write the file
                fs.writeFile(newpath, files, function (err) {
                    if (err) throw err;
                    res.write(name + ' uploaded :)')
                    res.end();
                });
    
                // Delete the file
                fs.unlink(oldpath, function (err) {
                    if (err) throw err;
                    
                });
            });
        });
    } else {
        res.writeHead(200,{'Content-Type' : 'text/html'});
        res.write('<form action="fileupload" method="post" enctype="multipart/form-data">');
        res.write('<input type = "file" name="filetoupload"><br>');
        res.write('<input type = "submit">');
        res.write('</form>');
        return res.end();
    }
}).listen(8080);