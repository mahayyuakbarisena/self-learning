const express = require('express');
const router = express.Router();
const mongoose = require('mongoose');

const Product = require('../model/product');

//Fungsi untuk mendapatkan semua data di database
router.get('/', (req, res, next)=>{
    Product.find()
    .exec()
    .then(docs => {
        console.log(docs);
        if (docs.length > 0){
            res.status(200).json(docs);
        } else {
            res.status(404).json({
                message: 'No entries found'
            });
        }
        
    })
    .catch(err => {
        console.log(err);
        res.status(500).json({
            error : err
        });
    });
});

//Fungsi create product
router.post('/', (req, res, next)=>{
    // const product = {
    //     name: req.body.name, //"body" disini adalah atribute yang bisa diakses karena body-parser di import di app.js
    //     price: req.body.price
    // };
    //Membuat model product sesuai dengan schema yang telah dibuat di model/product.js
    const product = new Product({
        _id: new mongoose.Types.ObjectId(), //syntax untuk membuat id menggunakan fungsi bawaan mongoose, akan ngegenerate id seperti 5f5a124cba959906dcb82810
        name: req.body.name,
        price: req.body.price
    });
    product
    .save()
    .then(result => {
        console.log(result);
        res.status(201).json({
            message: 'Handling POST request to /products',
            createdProduct: result
        });
    })
    .catch(err => {
        console.log(err)
        res.status(500).json({
            error: err
        });
    });
});

//Fungsi untuk mendapatkan 1 product yang memiliki id productId
router.get('/:productId', (req, res, next)=>{
    const id = req.params.productId;
    // if (id === 'special'){
    //     res.status(200).json({
    //         message: 'you discovered the special ID',
    //         id: id
    //     })
    // } else{
    //     res.status(200).json({
    //         message: 'you passed the id'
    //     });
    // }
    Product.findById(id)
    .exec()
    .then(doc => {
        console.log("From database", doc);
        if (doc) {
            res.status(200).json(doc);
        } else{
            res.status(404).json({message: 'No valid entry found for provided ID'});
        }
    })
    .catch(err => {
        console.log(err);
        res.status(500).json({
            error:err
        });
    });
});

//Fungsi untuk update product
router.patch('/:productId', (req, res, next)=>{
    const id = req.params.productId;
    const updateOps = {};
    for (const ops of req.body){
        updateOps[ops.propName] = ops.value;
    }
    Product.update({ _id: id }, { $set: updateOps })
    .exec()
    .then(result => {
        console.log(result);
        res.status(200).json(result);
    })
    .catch(err=>{
        console.log(err)
        res.status(500).json({
            error: err
        });
    });
});

//Fungsi untuk delete product
router.delete('/:productId', (req, res, next)=>{
    const id = req.params.productId;
    Product.remove({_id: id})
    .exec()
    .then(result => {
        res.status(200).json(result);
    })
    .catch(err => {
        console.log(err);
        res.status(500).json({
            error : err
        });
    });
});

module.exports = router;