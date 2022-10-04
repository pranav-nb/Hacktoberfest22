if(process.env.NODE_ENV!=='production')
{
    require('dotenv').config()
}

const express=require('express')
const app=express()  
const mongoose=require('mongoose')
const ejsmate=require('ejs-mate')
const passport=require('passport')
const path=require('path')
const method_override=require('method-override')
const session=require('express-session')
const mongo_Sanitize=require('express-mongo-sanitize')
const localStrategy=require('passport-local')
const flash=require('connect-flash')
const Note=require('./models/notes')
const user1=require('./models/users')
const user2=require('./models/guser')
const db_url=process.env.DB_URL //||'mongodb://localhost:27017/make-note'
mongoose.connect(db_url,{useNewUrlparser:true,useUnifiedTopology:true})
const db=mongoose.connection
db.on('error',console.error.bind('Error occurred'))
db.once('open',()=>{
    console.log('Databse connected')
})
const secret=process.env.SECRET||'thisissecret'
const MongoDbStore=require('connect-mongo')
const {truncateSync}=require('fs')
const {request}=require('http')
app.engine('ejs',ejsmate)
app.use(express.static(__dirname+'/public'))
app.use(express.json())
app.set('view engine','ejs')
app.set('views',path.join(__dirname,'views'))
app.use(express.urlencoded())
app.use(method_override('_method'))
app.use(mongo_Sanitize())
const cookieSession=require('cookie-session')
const {parse}=require('path')
const store=new MongoDbStore({
   mongoUrl:db_url,
   secret,
   touchAfter:24*60*60
})
store.on('error',(e)=>{
  console.log(e)
})
const sessionConfig={
    store,
    name: 'session',
    secret,
    resave: false,
    saveUninitialized: true,
    cookie: {
        httpOnly: true,
        expires: Date.now() + 1000 * 60 * 60 * 24 * 7,
        maxAge: 1000 * 60 * 60 * 24 * 7
    }
}

const GoogleStrategy = require('passport-google-oauth2').Strategy;
  
passport.serializeUser((user , done) => {
    done(null , user);
})
passport.deserializeUser(function(user, done) {
    done(null, user);
});
  
passport.use(new GoogleStrategy({
    clientID:"670049018080-0rn95hog9n5oacc8lkk9ks4c2svln6r6.apps.googleusercontent.com",
    clientSecret:"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", 
    callbackURL:"http://localhost:3000/auth/callback",
    passReqToCallback:true
  },
 async function(request, accessToken, refreshToken, profile,done) {
   
    const isThere=await user2.findOne({googleId:profile.id})
    if(!isThere){
         const username=profile.displayName
    const googleId=profile.id
    const newUser=new user2({username,googleId})
    await newUser.save()
    }
    return done(null, profile);
  }
));
app.use(cookieSession({
    name: 'google-auth-session',
    keys: ['key1', 'key2']
}));
app.use(session(sessionConfig))
app.use(flash())
app.use(passport.initialize());
app.use(passport.session());
passport.use(new localStrategy(user1.authenticate()))
passport.serializeUser(user1.serializeUser())
passport.deserializeUser(user1.deserializeUser())
app.use((req, res, next) => {
    res.locals.currentUser = req.user
    res.locals.success = req.flash('success')
    res.locals.error = req.flash('error')
    next()
})
   
    app.get('/register',(req,res)=>{
        res.render('register')
    })
    app.post('/register',async(req,res,next)=>{
        try{
        const {email,username,password}=req.body
       const user= new user1({email,username})
       const registeredUser=await user1.register(user,password)
      
       req.logIn(registeredUser,err=>{
           if(err)
           {
               return next(err)
           }
       })
       res.redirect('/allNotes')
        }
        catch(error){
            res.redirect('/register')
        }
    })
    app.get('/login',(req,res)=>{
        res.render('login')
    })
    app.post('/login',passport.authenticate('local',{failureFlash:true,failureRedirect:'/login'}),(req,res)=>{
        req.flash('success','Welcome back to make-note')
        res.redirect('/allNotes')
    })
    app.get('/logout',(req,res)=>{
        req.logOut()
        res.redirect('/')
    })

app.get('/auth' , passport.authenticate('google', {scope:
    [ 'email', 'profile' ]
}));
app.get( '/auth/callback',
    passport.authenticate( 'google', {
        successRedirect: '/allNotes',
        failureRedirect: '/auth'
}));
app.get('/',(req,res)=>{
    res.render('login')
})
app.get('/allNotes',async(req,res)=>{
    if(!req.isAuthenticated())
    {
     return  res.redirect('/login')
    }
   if(req.user._id)
   {
    const allNotes=await Note.find({user:req.user._id})
   return res.render('Home',{allNotes})
   }
    const guser=await user2.findOne({googleId:req.user.id})
    const allNotes=await Note.find({user:guser._id})
    res.render('Home',{allNotes})
})
app.get('/new',(req,res)=>{
    if(!req.isAuthenticated())
    {
       res.redirect('/login')
    }
    res.render('new')
})
app.post('/new',async(req,res)=>{
    if(!req.isAuthenticated())
    {
       res.redirect('/login')
    }
    const body=req.body
   const tags=body.tags.split(',')
     const {heading,content}=req.body
     if(req.user._id){
    const newNote=new Note({heading,tags,content,user:req.user._id})
    await newNote.save()
     }
     else{
     const guser=await user2.findOne({googleId:req.user.id})
    const newNote=await Note({heading,tags,content,user:guser._id})
    newNote.save()
     }
    res.redirect('/allNotes')
})

app.get('/edit/:id',async(req,res)=>{
    if(!req.isAuthenticated())
    {
       res.redirect('/login')
    }
    if(req.user._id)
    {
    const note=await Note.findById(req.params.id)
     return res.render('edit',{note})
    }
    const note=await Note.findById(req.params.id)
    res.render('edit',{note})
})
app.put('/edit/:id',async(req,res)=>{
    if(!req.isAuthenticated())
    {
       res.redirect('/login')
    }
    const body=req.body
   const tags=body.tags.split(',')
     const {heading,content}=req.body
    const note=await Note.findByIdAndUpdate(req.params.id,{heading,tags,content})
    note.save()
   res.redirect('/allNotes')
})
app.delete('/delete/:id',async(req,res)=>{
    if(!req.isAuthenticated())
    {
       res.redirect('/login')
    }
   
    const deleteNote=await Note.findByIdAndDelete(req.params.id)
    res.redirect('/allNotes')
})
const port=process.env.PORT||3000
app.listen(port,()=>{
    console.log(`Listening to port ${port}`)
})
