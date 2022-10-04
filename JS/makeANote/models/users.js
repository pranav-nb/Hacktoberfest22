const mongoose=require('mongoose')
const passportLocalMongoose=require('passport-local-mongoose')
const passportGoogle=require('passport-google-oauth2')
const userSchema=new mongoose.Schema({
    email:{
        type:String,
        required:true,
        unique:true
    }
})
userSchema.plugin(passportLocalMongoose)
module.exports=new mongoose.model('User',userSchema)