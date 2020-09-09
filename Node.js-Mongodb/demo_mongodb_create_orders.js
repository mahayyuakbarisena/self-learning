var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/";

MongoClient.connect(url, function(err, db){
    if (err) throw err;
    dbo = db.db("mydb");
    dbo.createCollection("orders", function(err, res){
        if (err) throw err;
        console.log("orders collection created");
        db.close();
    });
});