class Student{
    name;
    age;
    constructor(name, age){
        this.name = name;
        this.age = age;
    }

}

Students = [new Student('Duc', 16), new Student('Cuong', 19), new Student('Gioi', 15)];

Students.sort((a, b) => {
    return String(b.name).localeCompare(String(a.name));
})
// return parseInt(a.age) - parseInt(b.age);

Students.forEach(Student => {
    console.log(Student.name);
})



