var yeuThich = document.getElementById('yeu-thich')
var read = document.getElementById('khung-doc')

window.onscroll = function () {
    myFunction()
};

var navbar = document.getElementById("khung-doc");

var khungBaoDau = document.querySelector("#khung-bao-dau");

const sticky = navbar.offsetTop;

function myFunction() {
    console.log(sticky)
    if (window.pageYOffset + 100 >= sticky) {
        navbar.classList.add("sticky");
    } else {
        navbar.classList.remove("sticky");
    }
}

yeuThich.onclick = ()=>{themVaoYeuThich()}

function themVaoYeuThich() {
    const userName = document.querySelector("#user");
    const thongTin = document.querySelector("#thong-tin");
    const tenTruyen = document.querySelector("#ten-truyen");
    const nxb = document.querySelector("#nxb");
    
    const mess = document.querySelector("#thong-bao");
    

    console.log('Them Truyen Vao Danh Sach Yeu Thich')
    console.log(userName.dataset.username)
    console.log(thongTin.dataset.idtruyen)
    console.log(tenTruyen.dataset.ten)
    console.log(nxb.dataset.nxb)
    
    let options = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(
        {
            name: userName.dataset.username,
            truyen:
            {
                id: thongTin.dataset.idtruyen,
                ten: tenTruyen.dataset.ten,
                nxb: nxb.dataset.nxb
            }
        }
        )
    }
    
    fetch('api-fav', options)
    .then(res => {
        console.log(res)
            return res.json()
        })
        .then(data => {
            mess.innerHTML = data.mess
            console.log(data)
        })
}