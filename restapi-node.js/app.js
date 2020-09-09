//Import module
const express = require('express');
const app = express();
const morgan = require('morgan'); //Buat ngasih tau route mana yang di request
const bodyParser = require('body-parser'); //Untuk ngeparse isi/body dari request yang masuk

//Import Routes from api\routes
const productRoutes = require('./api/routes/products');
const orderRoutes = require('./api/routes/orders');

//Manggil fungsi morgan
app.use(morgan('dev')); 

//Manggil fungsi body parser
app.use(bodyParser.urlencoded({extended: false})); //Untuk ngeparse urlenccoded
app.use(bodyParser.json()); //untuk ngeparse json

//Handling CORS Error
app.use((req, res, next) => {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", 
               "Origin, X-Requested-With, Content-Type, Accept, Authorization"
    );
    if (req.method === 'OPTIONS'){
        res.header('Access-Control-Allow-Methods', 'PUT, POST, PATCH, DELETE, GET');
        return res.status(200).json({});
    }
    next();
});

//Routes yang menangani request
app.use('/products', productRoutes);
app.use('/orders', orderRoutes);

//Handling error
app.use((req, res, next) => {
    const error = new Error('Not Found');
    error.status= 404;
    next(error);
});

app.use((error, req, res, next)=>{
    res.status(error.status || 500);
    res.json({
        error: {
            message: error.message
        }
    });
});

module.exports = app;