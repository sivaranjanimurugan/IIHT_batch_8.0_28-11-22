function getFormValue(ev) {
    // Disable default form submission action
    ev.preventDefault();
    // Pick the form reference
    const form = document.getElementById('form1');
    // get all elements like input and select, you can add many more
    const allInputs = form.querySelectorAll('input,select');
    let formObj = {};
    // Get the values of each field
    allInputs.forEach(e => {
        //All key depends on the name in the element
        const key = e.getAttribute('name');
        formObj[key] = e.value;
    });
    // var a = document.getElementById('fname').value;
    // console.log(a);
    // console.log(formObj);
    localStorage.setItem("form1",JSON.stringify(formObj));
    // window.location.replace('/thankyou.html');
    setTimeout("location.href = '/thankyou.html';",1000);
}