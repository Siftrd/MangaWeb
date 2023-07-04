function moMenu() {
    var a = document.getElementById("menu-the-loai");
    a.style.width = "300px";
    // a.style.height = "100%";
  }
  
function dongMenu() {
    var a = document.getElementById("menu-the-loai");
    a.style.width = "0";
    // a.style.height = "0px";
}

function themTruyen() {
  var box = document.createElement('div')
  box.className = 'truyen'
  box.style.height = '340px';
  box.style.width = '300px';
  // box.style.border = '1px solid black';
  
  var ds_truyen = document.getElementById('danh-muc-truyen');
  
  ds_truyen.appendChild(box);
}

nutThemTruyen = ()=>{
  var Truyens = document.getElementsByClassName('truyen');
  Truyens.length
}

// console.log("Bui Minh Duc")


// loadImage = (url, successCallback, errorCallback) =>{
//   var img = new Image();
//   img.onload = () =>{    
//       successCallback();
//   }

//   img.onerror = () =>{
//       errorCallback();
//   }
//   img.src = url;
// } 

// var imgLink = 'https://imageio.forbes.com/specials-images/imageserve/5d35eacaf1176b0008974b54/0x0.jpg?format=jpg&crop=4560,2565,x790,y784,safe&fit=crop';

// loadImage(imgLink,
//   ()=>{
//       console.log('anh load thanh cong');
// },
//   ()=>{
//       console.log(' deo load duoc anh');
//   }
// );
