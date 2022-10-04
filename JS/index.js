let playerState='jump'
const dropDown=document.getElementById('animations')
dropDown.addEventListener('change',(e)=>{
   playerState=e.target.value
})
const canvas = document.getElementById('canvas1')
const ctx=canvas.getContext('2d');
console.log(ctx)
const CANVAS_WIDTH=canvas.width=600
const CANVAS_HEIGHT=canvas.height=600
const playerImage=new Image();
playerImage.src='https://www.frankslaboratory.co.uk/downloads/shadow_dog.png'

const spreadWidth=575
const spreadHeight=523

let gameFrame=0
const staggerFrames=5
const spriteAnimations=[]
const animationStates=[
    {
        name:'idle',
        frames:7
    },
    {
        name:'jump',
        frames:7,
    },
    {
        name:'fall',
        frames:7
    },
    {
        name:'run',
        frames:9
    },
    {
       name:'dizzy',
       frames:11
    },
    {
        name:'sit',
        frames:5
    },
    {
        name:'roll',
        frames:7
    },
    {
        name:'bite',
        frames:7
    },
    {
        name:'ko',
        frames:12
    },
    {
        name:'getHit',
        frames:4
    }
]
animationStates.forEach((state,index)=>{
     let frames={
        loc:[]
     }
     for(let j=0;j<state.frames;j++)
     {
        let positionX=j*spreadWidth;
        let positionY=index*spreadHeight
        frames.loc.push({x:positionX,y:positionY})
     }
     spriteAnimations[state.name]=frames
})
console.log(spriteAnimations)
function animate(){
    ctx.clearRect(0,0,CANVAS_WIDTH,CANVAS_HEIGHT);
    // ctx.fillRect(50,50,100,100)
    //ctx.drawImage(image,sx,sy,sw,sh,dx,dy,dw,dh)
    let position = Math.floor(gameFrame/staggerFrames)%spriteAnimations[playerState].loc.length;
    let frameX=spreadWidth*position
    let frameY=spriteAnimations[playerState].loc[position].y
    ctx.drawImage(playerImage,frameX,frameY,spreadWidth,spreadHeight,0,0,spreadWidth,spreadHeight)
    gameFrame++
    requestAnimationFrame(animate)    
}
animate()
