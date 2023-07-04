
const them = document.querySelector("#them");
const sua = document.querySelector("#sua");
const xoa = document.querySelector("#xoa");
const xoaFile = document.querySelector("#xoa-truyen #xoa-file");
const xoaThumb = document.querySelector("#xoa-truyen #xoa-thumb");

// con quay loading
//const loaderUploadTruyen = document.querySelector('#them-truyen #tai-file-truyen #mess2 .loader');
const loaderUploadTruyen = document.querySelector('#loader-file');
//const loaderUploadThumb = document.querySelector('#them-truyen #tai-thumb-truyen #mess4 .loader');
const loaderUploadThumb = document.querySelector('#loader-thumb');

them.onclick = () => {
    let themXong = themTruyen();

    themXong
            .then(() => {
                if (truyenFiles.files.length != 0){
                    loaderUploadTruyen.style.display = 'block';
                    taiTruyenLen(truyenFiles.files[0]);
                }
            })
            .then(() => {
                if (anhFiles.files.length != 0){
                    loaderUploadThumb.style.display = 'block';
                    taiAnhLen(anhFiles.files[0]);
                }
            })
};
sua.onclick = () => {
    suaTruyen()
};

xoa.onclick = () => {
    xoaTruyen()
};
xoaFile.onclick = () => {
    xoaFileTruyen()
};
xoaThumb.onclick = () => {
    xoaAnhThumbTruyen()
};

function themTruyen() {
    const id = document.getElementById("id");
    const ten = document.getElementById("ten");
    const nxb = document.getElementById("nxb");
    const mess = document.querySelector("#thong-bao");
    const theLoai = document.querySelector("#them-the-loai");

    let idTheLoai = theLoai.options[theLoai.selectedIndex].value;


    console.log('pressed');
    console.log(idTheLoai);

    let options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: id.value,
            ten: ten.value,
            nxb: nxb.value,
            theLoai: idTheLoai
        })
    };

    return fetch('api-truyen', options)
            .then(res => {
                return res.json();
            })
            .then(data => {
                mess.innerHTML = data.mess;
                console.log(data);
            })
}

function suaTruyen() {
    const id = document.getElementById("id-sua");
    const ten = document.getElementById("ten-sua");
    const nxb = document.getElementById("nxb-sua");
    const mess = document.querySelector("#thong-bao2");
    const theLoai = document.querySelector("#sua-the-loai");

    let idTheLoai = theLoai.options[theLoai.selectedIndex].value;

    console.log('pressed');
    console.log(idTheLoai);

    let options = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: id.value,
            ten: ten.value,
            nxb: nxb.value,
            theLoai: idTheLoai
        })
    }

    fetch('api-truyen', options)
            .then(res => {
                return res.json()
            })
            .then(data => {
                mess.innerHTML = data.mess;
                console.log(data);
            })
}

function xoaTruyen() {
    const id = document.getElementById("id-xoa");
    const mess = document.querySelector("#thong-bao3");

    let options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: id.value
        })
    }

    console.log('pressed')
    fetch('api-truyen', options)
            .then(res => {
                return res.json()
            })
            .then(data => {
                mess.innerHTML = data.mess
                console.log(data)
            })
}

function xoaFileTruyen() {
    const id = document.querySelector("#xoa-truyen #id-xoa-file");
    const mess = document.querySelector("#xoa-truyen :nth-child(8)");

    let options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: id.value
        })
    }

    console.log('pressed');
    fetch('upload', options)
            .then(res => {
                return res.json()
            })
            .then(data => {
                mess.textContent = data.mess
                console.log(data)
            })
}

function xoaAnhThumbTruyen() {
    const id = document.querySelector("#xoa-truyen #id-xoa-thumb")
    const mess = document.querySelector("#xoa-truyen :nth-child(12)");

    let options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: id.value
        })
    }

    console.log('pressed');
    fetch('uploadThumb', options)
            .then(res => {
                return res.json();
            })
            .then(data => {
                mess.textContent = data.mess;
                console.log(data);
            })
}





const truyenFiles = document.querySelector('#file');
const anhFiles = document.querySelector('#file-thumb');
const thongBao = document.querySelector('#mess');
const thongBaoTraVe = document.querySelector('#mess2');
const thongBaoThumb = document.querySelector('#mess3');
const thongBaoTraVeThumb = document.querySelector('#mess4');
const upload = document.querySelector('#them');

truyenFiles.addEventListener('change', () => {
    uploadTruyenCheck(truyenFiles.files[0]);
});


anhFiles.addEventListener('change', () => {
    uploadThumbCheck(anhFiles.files[0]);
});


const uploadTruyenCheck = (file) => {
    console.log(file.type === 'application/pdf');
    if (!(file.type === 'application/pdf')) {
        console.log('in ra thong bao');
        thongBao.textContent = 'lam on chon file pdf';
        truyenFiles.value = '';
        return;
    }

    thongBao.textContent = file.type;


    console.log('chuan bi fetch');



}

const uploadThumbCheck = (file) => {
    console.log(file.type === 'image/jpeg');
    if (!(file.type === 'image/jpeg')) {
        console.log('in ra thong bao');
        thongBaoThumb.textContent = 'lam on chon file jpg';
        anhFiles.value = '';
        return;
    }

    thongBaoThumb.textContent = file.type;

    console.log('chuan bi fetch anh thumb');
}

taiTruyenLen = (file) => {

    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/pdf'
        },
        body: file
    };

    fetch('upload', options)
            .then(res => {
                return res.json()
            })
            .then(data => {
                loaderUploadTruyen.style.display = 'none';
                thongBaoTraVe.textContent = data.mess;
                console.log(data);
            })
            .catch(err => {
                thongBaoTraVe.textContent = err;
            })
}

taiAnhLen = (file) => {

    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'image/jpeg'
        },
        body: file
    };

    fetch('uploadThumb', options)
            .then(res => {
                return res.json()
            })
            .then(data => {
                loaderUploadThumb.style.display = 'none';
                thongBaoTraVeThumb.textContent = data.mess;
                console.log(data);
            })
}

