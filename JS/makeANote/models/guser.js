const mongoose=require('mongoose')

const passportGoogle=require('passport-google-oauth2')
const GuserSchema=new mongoose.Schema({
   username:String,
   googleId:String
})

module.exports=new mongoose.model('Guser',GuserSchema)