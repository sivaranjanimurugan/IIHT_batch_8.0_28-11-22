// const func1 = () => {
//     console.log("This is a func 1");
// }

// const func2 = () => {
//     //set timeout
//     setTimeout(() => {
//         console.log("Hey wait for couple of sec !");
//     }, 5000);
//     console.log("This is a func 2");
// }

// const func3 = () => {
//     console.log("This is a func 3");
// }

// func1();
// func2();
// func3();

const func1 = () => {
    return "This is a func 1";
}

// const func2 = () => {
//     //set timeout
//     setTimeout(() => {
//         return "Hey wait for couple of sec !";
//     }, 5000);
// }

const func2 = () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("Hey wait for couple of sec !");
        }, 2000);
    })
}

const func3 = () => {
    return "This is a func 3";
}

// async and await is helps to wait for complete the func
const callFunc = async () => {
    let val1 = func1();
    console.log(val1);
    let val2 = await func2();
    console.log(val2);
    let val3 = func3();
    console.log(val3);
}