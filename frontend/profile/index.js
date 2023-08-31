$(document).ready(function() {
    let email = window.localStorage.getItem("health-connect-plus-email");
    let type = window.localStorage.getItem("health-connect-plus-type");
    document.getElementById("user-email").innerText = email;
    document.getElementById("user-type").innerText = type;
});