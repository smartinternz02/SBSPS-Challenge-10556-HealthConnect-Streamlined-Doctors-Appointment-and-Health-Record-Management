$(document).ready(async function() {
    let loginBtn = document.getElementById("submitBtn");
    loginBtn.addEventListener('click', loginBtnFunc);
});

async function loginBtnFunc() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    let type = document.getElementById("type").value;
    loginAPI(type, email, password);
}

