function Car(model, cost, color) {
    this.model = model;
    this.cost = cost;
    this.color = color;
    // hide runningCost property
    let runningCost = 50000; //let is helps to change state to immute of field

    this.getDetails = function () {
        console.log("Color", this.color);
    }

    this.totalCostPerYear = function () {
        console.log(this.runningCost + this.cost);
    }
}

let AadiCar = new Car("Aadi", 20000, "Black");
AadiCar.getDetails();
// AadiCar.runningCost=100;
console.log(AadiCar.totalCostPerYear());