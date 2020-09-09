var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/";

MongoClient.connect(url, function(err, db){
    if (err) throw err;
    var dbo = db.db("mydb");
    dbo.listCollections().toArray(function(err,collInfos){
        if (err) throw err;
        console.log(collInfos);
        db.close();
    });
});