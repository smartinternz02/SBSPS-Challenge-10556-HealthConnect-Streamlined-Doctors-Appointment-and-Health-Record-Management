$(document).ready(function () {});

async function bookBtnFunc() {
  let bookingDate = document.getElementById("book-date").value;
  let bookingTime = document.getElementById("book-time").value;
  let urlParams = new URLSearchParams(window.location.search);
  let doctorEmail = urlParams.get("email");
  await bookAPI(doctorEmail, bookingDate, bookingTime);
}

async function bookAPI(doctorEmail, date, time) {
  let token = window.localStorage.getItem("health-connect-plus-user-token");
  let userEmail = window.localStorage.getItem("health-connect-plus-email");
  if ((token == null || token=="") || (userEmail==null || userEmail=="")){
    logout();
  }

  const data = JSON.stringify({
    appointment_id: generateRandomId(),
    doctor_email: doctorEmail,
    date: date,
    time: time,
    user_email: userEmail,
  });

  $.ajax({
    url: "http://localhost:9999/health-connect-plus/appointments",
    crossDomain: true,
    method: "post",
    headers: {
      accept: "application/json",
      "content-type": "application/json",
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, OPTIONS",
      "Access-Control-Allow-Headers":
        "origin, content-type, accept, authorization",
      Authorization: `bearer ${token}`,
    },
    data: data,
    async: true,
    success: function (resp) {
      let appointmentId = resp?.appointment_id;
      alert(`appointment booked successfully: ${appointmentId}`);
      window.location.href="/";
    },
    error: function (err) {
      let errDesc = err?.responseJSON?.description;
      alert("failure: " + errDesc);
    },
  });
}
