var MongoClient = require("mongodb").MongoClient;
var url = "mongodb://localhost:27017/";

MongoClient.connect(url, function(err, db){
    if (err) throw err;
    dbo = db.db("mydb");
    var myquery = { name: /^C/ };
    var newvalues = { $set: {name: "Strawberry" }};
    dbo.collection("products").updateMany(myquery, newvalues, function(err, res){
        if (err) throw err;
        console.log(res.result.nModified + " document(s) updated");
        db.close();
    });
});