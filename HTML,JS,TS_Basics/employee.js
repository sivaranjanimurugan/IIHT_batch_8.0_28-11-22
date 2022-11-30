//create parent class
class Employees {
    constructor(companyName) {
        this.companyName = "CTS";
    }
}

// extended child classes
class Developers extends Employees {
    constructor(name, experience, dept, position, joinDate, location, emailId, empId, salary) {
        super();
        this.name = name;
        this.experience = experience;
        this.dept = dept;
        this.position = position;
        this.joinDate = joinDate;
        this.location = location;
        this.emailId = emailId;
        this.empId = empId;
        this.salary = salary;
    }
}

class HR extends Employees {
    constructor(name, experience, dept, position, joinDate, location, emailId, empId, salary) {
        super();
        this.name = name;
        this.experience = experience;
        this.dept = dept;
        this.position = position;
        this.joinDate = joinDate;
        this.location = location;
        this.emailId = emailId;
        this.empId = empId;
        this.salary = salary;
    }
}

class Finance extends Employees {
    constructor(name, experience, dept, position, joinDate, location, emailId, empId, salary) {
        super();
        this.name = name;
        this.experience = experience;
        this.dept = dept;
        this.position = position;
        this.joinDate = joinDate;
        this.location = location;
        this.emailId = emailId;
        this.empId = empId;
        this.salary = salary;
    }
}

class Sales extends Employees {
    constructor(name, experience, dept, position, joinDate, location, emailId, empId, salary) {
        super();
        this.name = name;
        this.experience = experience;
        this.dept = dept;
        this.position = position;
        this.joinDate = joinDate;
        this.location = location;
        this.emailId = emailId;
        this.empId = empId;
        this.salary = salary;
    }
}

class Marketing extends Employees {
    constructor(name, experience, dept, position, joinDate, location, emailId, empId, salary) {
        super();
        this.name = name;
        this.experience = experience;
        this.dept = dept;
        this.position = position;
        this.joinDate = joinDate;
        this.location = location;
        this.emailId = emailId;
        this.empId = empId;
        this.salary = salary;
    }
}

class QA extends Employees {
    constructor(name, experience, dept, position, joinDate, location, emailId, empId, salary) {
        super();
        this.name = name;
        this.experience = experience;
        this.dept = dept;
        this.position = position;
        this.joinDate = joinDate;
        this.location = location;
        this.emailId = emailId;
        this.empId = empId;
        this.salary = salary;
    }
}

let developer = new Developers("siva", 2, "DEV", "PA", "2022-11-20", "Chennai", "mail@gmail.com", 123, 50000);
let hr = new HR("sam", 2, "HR", "PA", "2022-11-20", "Chennai", "mail@gmail.com", 123, 50000);
let finance = new Finance("ramya", 2, "fin", "PA", "2022-11-20", "Chennai", "mail@gmail.com", 123, 50000);
let sales = new Sales("pooma", 2, "sales", "PA", "2022-11-20", "Chennai", "mail@gmail.com", 123, 50000);
let marketing = new Marketing("mini", 2, "marketing", "PA", "2022-11-20", "Chennai", "mail@gmail.com", 123, 50000);
let qa = new QA("kabil", 2, "QA", "PA", "2022-11-20", "Chennai", "mail@gmail.com", 123, 50000);

console.log(developer);
console.log(hr);
console.log(finance);
console.log(sales);
console.log(marketing);
console.log(qa);

