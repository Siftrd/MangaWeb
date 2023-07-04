chiaHetchoBa = (num) =>{
    return num%3 == 0;
}

console.log(chiaHetchoBa(5));

var students = ['123', '243124', 'duc'];

students.unshift('111111');
var first = students.shift();


var studentTeenNames = students.map(student => {
    return student + 'yahoo.com';
})

var numbers = [1,2,3,4,5,6,7,8];

var total = numbers.reduce((soLuongSoChan, curr) =>{
    if(curr % 2 == 0) soLuongSoChan++;
    return soLuongSoChan;
}, 0)



console.log(total)
// console.log(students[1]);
