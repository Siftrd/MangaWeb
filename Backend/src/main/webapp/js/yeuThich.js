const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
//const ketQua = document.querySelector('#danh-muc-truyen')
const ketQua = document.querySelector('body')


layTruyen()
    
function layTruyen(){
    const userName = document.querySelector("#user");
    console.log('api-fav?name='+userName.dataset.username)
    fetch('api-fav?name='+userName.dataset.username)
            .then(res => {return res.json()})
            .then(json => {display(json)})
}

function display(json){
    
    let list = json.fav;
    
    
    if(list.length == 0){
        ketQua.innerHTML = '<h1>Khong co ket qua</h1>'
        return;
    }
    
    
    for(let i=0; i<list.length;i++){
        const t = document.createElement('a')
        t.classList.add("truyen")
        t.href = 'read?truyenID=' + list[i].id.trim()
        
//        t.innerHTML = anhThumb(list[i].id).outerHTML + tenTruyen(list[i].ten).outerHTML
        t.innerHTML = anhThumb(list[i].id, list[i].ten).outerHTML
//        t.innerHTML = temp.outerHTML
        ketQua.appendChild(t);
    }
    
    function anhThumb(id, ten){
        const k = document.createElement('div');
        k.classList.add('khung-anh')
        const anh = document.createElement('img');
        anh.src = 'img/Thumbnails/'+ id.toLocaleString().trim() +'.jpg'
        k.appendChild(anh)
        k.appendChild(tenTruyen(ten))
        return k
    }
    
    function tenTruyen(ten){
        const t = document.createElement('p');
        
        t.innerHTML = ten
        
        return t
    }
    
}