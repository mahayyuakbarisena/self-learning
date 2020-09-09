//Define router
const express = require('express');
const router = express.Router();

//Menangani GET request yang datang ke /orders
router.get('/', (req, res, next) => {
    res.status(200).json({
        message: 'orders were fetched'
    });
});

//Menangani POST request yang datang ke /orders
router.post('/', (req, res, next) => {
    const order = {
        productId: req.body.productId,
        quantity: req.body.quantity

    };
    res.status(201).json({
        message: 'orders were fetched',
        order: order
    });
});

//Menangani GET request dengan orderId untuk mengambil detail dari suatu order yang datang ke /orders
router.get('/:orderId', (req, res, next) => {
    res.status(200).json({
        message: 'Order details',
        orderId: req.params.orderId
    });
});

//Menangani DELETE request yang datang ke /orders
router.delete('/:orderId', (req, res, next) => {
    res.status(200).json({
        message: 'Order deleted',
        orderId: req.params.orderId
    });
});

module.exports = router;