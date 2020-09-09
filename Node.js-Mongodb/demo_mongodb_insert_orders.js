var MongoClient = require('mongodb').MongoClient
var url = "mongodb://localhost/27017";

MongoClient.connect(url, function(err, db){
    if (err) throw err;
    var dbo = db.db("mydb");
    var myobj = [
        { _id : 1, product_id: 154, status: 1},
        { _id : 2, product_id: 154, status: 1},
        { _id : 3, product_id: 156, status: 1}
    ];
    dbo.collection("orders").insertMany(myobj, function(err, res){
        if (err) throw err;
        console.log("Number of documents inserted: " + res.insertedCount);
        db.close();
    });
});