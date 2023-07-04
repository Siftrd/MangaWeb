//Phan cua Chinh

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
const nutTim = document.getElementById('nut-tim')
const oTimKiem = document.getElementById('search')


//Phan cua Gioi
function searchByName(parameter) {
    var txtSearch = parameter.value;
    fetch('searchAuto?txt=' + txtSearch)
            .then((res) => {
                return res.text();

            })
            .then((res) => {
                var row = document.getElementById("danh-muc-truyen");
                row.innerHTML = res;
            });
}
