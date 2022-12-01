// var name = "sivaranjani"; //define a variable
// var age = 23;
// var isGraduated = true;
// var laptop;
// laptop = "lg";
// console.log(name, age);

// function alertUser() {
//     var favColor = "blue"; //local variable
//     alert("This user has logged in " + name);
// }
// alertUser();
// // console.log(favColor);
// function operators(num) {
//     if (num > 20) {
//         console.log("Number greater than 20");
//     } else if (num == 20) {
//         console.log("Number is equal to 20");
//     } else {
//         console.log("Number less than 20");
//     }
// }
// operators(20);

// function creditScore(score) {
//     var creditLimit;
//     switch (score) {
//         case 800: creditLimit = "above 1 lac";
//             break;
//         case 700: creditLimit = "50,000 to 1 lac";
//             break;
//         case 600: creditLimit = "20,000 to 50,000";
//             break;
//         default: creditLimit = "not eligible";
//     }
//     console.log(creditLimit);
// }
// creditScore(100);

// function counting() {
//     for (let i = 1; i <= 3; i++) {
//         console.log(i);
//     }
// }
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

//class declarations
let Car = class {
    //initialize variables using constructor
    constructor(brand, modelName, price) {
        this.brand = brand;
        this.modelName = modelName;
        this.price = price;
    }

    print() {
        console.log("This is a car brand" + this.brand + " " + this.modelName + " " + this.price);
    }
}

var c1 = new Car("BMW", "A-class", 12000000);
var c2 = new Car("Aadi", "B-class", 900000);
c1.print();
c2.print();

//inheritance implemetation
class TodayDate extends Date {
    constructor() {
        super();
    }

    printDate() {
        console.log(this.getDate());
    }
}

let today = new TodayDate();
today.printDate();
console.log(today.getFullYear());

//user defined parent and child relationship
class AppleLaptop {
    constructor(brand) {
        this.brand = "Apple";
    }
}

class MacBookPro extends AppleLaptop {
    constructor(model, ram, processor) {
        super();
        this.model = model;
        this.ram = ram;
        this.processor = processor;
    }
}

let lap1 = new MacBookPro("lattitude 350", 16, "i7");
console.log(lap1.brand + " " + lap1.model + " " + lap1.ram + " " + lap1.processor);

let fruits = ["Apple", "orange", "pineapple"];
let seasionalFruits = ["Mango", "jackfruit"];

let allFruits = [...fruits, ...seasionalFruits]; // ... is a spread operator and its copies the all the elements
//of an array after use of ...
console.log(allFruits);

let counting = () => { //this is how to define a inline or arrow func
    for (let i = 1; i <= 3; i++) {
        console.log(i);
    }
}
counting();

// there keywords are available in js = var, let, const
// var - scope of function
var num1 = 100;
var num1 = 200;
console.log("var is:", num1);

//let - scope of block and can not be redeclare it
let a = 100;
function addNumbers() {
    a = 500;
    let b = 200;
    console.log(a + b);
}

addNumbers();
console.log(a + 1000);

//const - scope of block and cannot be modified or redeclare it
function constNumbers() {
    const num2 = 120;
    // const num2 = 10;
    console.log("const is:", num2 + 200);
}
constNumbers();

function dogs(){
    this.dogname = dogname;
    throw new error("This is not a wild animal");
}

dogs.prototype.display = function(){
    return "this dog breed is " + this.dogname;
}

//constructor func
function Animal(dogname){
  this.dogname = dogname;
}

//create and object witout using constructor
Animal.prototype = Object.create(dogs.prototype);
let tommy = new Animal("German shepherd");
console.log(tommy.display());

function greeting(){
    alert("Hello !!!");
}


