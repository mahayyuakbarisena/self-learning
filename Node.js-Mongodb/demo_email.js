var nodemailer = require('nodemailer');

var transporter = nodemailer.createTransport({
    service : 'gmail',
    auth : {
        user: 'email@gmail.com',
        pass: 'password'
    }
});

var mailOptions = {
    from: 'email@gmail.com',
    to: 'emailTujuan@gmail.com',
    subject: 'subjeknya',
    text: "Isi Pesan"
};

transporter.sendMail(mailOptions, function(error,info){
    if (error){
        console.log(error);
    } else {
        console.log('Email sent: ' + info.response);
    }
});