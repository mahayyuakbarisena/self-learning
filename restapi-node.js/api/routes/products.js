const express = require('express');
const router = express.Router();

router.get('/', (req, res, next)=>{
    res.status(200).json({
        message: 'Handling GET request to /products'
    });
});

router.post('/', (req, res, next)=>{
    const product = {
        name: req.body.name, //"body" disini adalah atribute yang bisa diakses karena body-parser di import di app.js
        price: req.body.price
    };
    res.status(201).json({
        message: 'Handling POST request to /products',
        createdProduct: product
    });
});

router.get('/:productId', (req, res, next)=>{
    const id = req.params.productId;
    if (id === 'special'){
        res.status(200).json({
            message: 'you discovered the special ID',
            id: id
        })
    } else{
        res.status(200).json({
            message: 'you passed the id'
        });
    }
});

router.patch('/:productId', (req, res, next)=>{
    res.status(200).json({
        message: 'updated product'
    });
});

router.delete('/:productId', (req, res, next)=>{
    res.status(200).json({
        message: 'deleted product'
    });
});

module.exports = router;