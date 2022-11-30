var name = "sivaranjani"; //define a variable
var age = 23;
var isGraduated = true;
var laptop;
laptop = "lg";
console.log(name, age);

function alertUser() {
    var favColor = "blue"; //local variable
    alert("This user has logged in " + name);
}
alertUser();
// console.log(favColor);
function operators(num) {
    if (num > 20) {
        console.log("Number greater than 20");
    } else if (num == 20) {
        console.log("Number is equal to 20");
    } else {
        console.log("Number less than 20");
    }
}
operators(20);

function creditScore(score) {
    var creditLimit;
    switch (score) {
        case 800: creditLimit = "above 1 lac";
            break;
        case 700: creditLimit = "50,000 to 1 lac";
            break;
        case 600: creditLimit = "20,000 to 50,000";
            break;
        default: creditLimit = "not eligible";
    }
    console.log(creditLimit);
}
creditScore(100);

function counting() {
    for (let i = 1; i <= 5; i++) {
        console.log(i);
    }
}
// counting();

//declaring and assign value to the object in js
var car = new Object();
car.brand = "Aadi";
car.model = "C class";
car.price = 70000000;
console.log(car);

//declare and initialize array
var names = ["siva", "ramya", "pooma", "mini"];
console.log(names);