const mongoose=require('mongoose')
const notesSchema=new mongoose.Schema({
    heading:{
        type:String,
        required:true
    },
    tags:[{
        type:String,
    }],
    content:{
        type:String,
        required:true
    },
    user:{
        type:mongoose.Schema.Types.ObjectId,
        ref:'User'
    }
})
module.exports=new mongoose.model('Note',notesSchema)