//Model disini adalah sebagai skema atau blueprint untuk dipanggil saat membuat objek produk yang ingin dimasukan ke database
const mongoose = require('mongoose'); //Panggil library mongoose

//Penulisan atribute model seperti berikut
const productSchema = mongoose.Schema({
    _id: mongoose.Schema.Types.ObjectId,
    name: String,
    price: Number
});

//export model menggunakan syntax berikut
module.exports = mongoose.model('Product', productSchema); //tulis nama model pada argumen pertama, contoh: 'Product'