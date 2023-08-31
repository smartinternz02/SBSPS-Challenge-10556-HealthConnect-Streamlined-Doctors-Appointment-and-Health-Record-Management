$(document).ready(async function () {
  await getOrdersAPI();
  await getAppointmentsAPI();
});

async function getOrdersAPI() {
  let userEmail = window.localStorage.getItem("health-connect-plus-email");
  let token = window.localStorage.getItem("health-connect-plus-user-token");
  $.ajax({
    url: "http://localhost:9999/health-connect-plus/orders?email="+userEmail,
    crossDomain: true,
    method: "get",
    headers: {
      accept: "application/json",
      "content-type": "application/json",
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, OPTIONS",
      "Access-Control-Allow-Headers":
        "origin, content-type, accept, authorization",
      Authorization: `bearer ${token}`,
    },
    success: async function (orders) {
      document.getElementById("orders-grid").innerHTML = "";
      orders.forEach((order) => {
        document.getElementById("orders-grid").innerHTML += `
                  <div class="ac-listing-grid__column   ac-grid--left btn-unactive  ac-listing-grid__col--three"> 
                      <div class="ac-listing-grid__col-wrap"> 
                          <div class="ac-listing-grid__image"> 
                              <img style="max-height: 500px; max-width: 500px" src="https://t4.ftcdn.net/jpg/01/32/17/61/360_F_132176161_wHAzKMpRhCX3TjlRgcEo6UvSHrf7Ibt4.jpg" alt="Events" loading="lazy" style="max-width: 100%; height: auto;"> 
                              <span class="ac-listing__tag">${order.order_id}</span> 
                          </div> 
                          <div class="ac-listing-grid__content"> 
                              <span>${order.date}</span> 
                              <h5>${order.items}</h5> 
                              <button onclick="deleteOrderAPI('${order.order_id}');" class="pika-button ac-button">Cancel</button>
                          </div>
                      </div>
                  </div> 
              `;
      });
    },
    error: function (err) {
      let errCode = err?.responseJSON.code;
      if (errCode == 401) {
        logout();
      } else if(errCode == 404) {
        // DO NOTHING
      } else {
        let errDesc = err?.responseJSON?.description;
        alert("failure: " + errDesc);
      }
    },
  });
}

async function getAppointmentsAPI() {
  let userEmail = window.localStorage.getItem("health-connect-plus-email");
  let token = window.localStorage.getItem("health-connect-plus-user-token");
  $.ajax({
    url: "http://localhost:9999/health-connect-plus/appointments?email="+userEmail,
    crossDomain: true,
    method: "get",
    headers: {
      accept: "application/json",
      "content-type": "application/json",
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, OPTIONS",
      "Access-Control-Allow-Headers":
        "origin, content-type, accept, authorization",
      Authorization: `bearer ${token}`,
    },
    success: async function (appointments) {
      document.getElementById("appointments-grid").innerHTML = "";
      appointments.forEach((appointment) => {
        document.getElementById("appointments-grid").innerHTML += `
                  <div class="ac-listing-grid__column   ac-grid--left btn-unactive  ac-listing-grid__col--three"> 
                      <div class="ac-listing-grid__col-wrap"> 
                          <div class="ac-listing-grid__image"> 
                              <img style="max-height: 500px; max-width: 500px" src="https://cdn-icons-png.flaticon.com/512/3774/3774299.png" alt="Events" loading="lazy" style="max-width: 100%; height: auto;"> 
                              <span class="ac-listing__tag">${appointment.appointment_id}</span> 
                          </div> 
                          <div class="ac-listing-grid__content"> 
                              <span>${appointment.date} - ${appointment.time}</span> 
                              <h5>${appointment.doctor_email}</h5> 
                              <button onclick="deleteAppointmentAPI('${appointment.appointment_id}');" class="pika-button ac-button">Cancel</button>
                          </div>
                      </div>
                  </div> 
              `;
      });
    },
    error: function (err) {
      let errCode = err?.responseJSON.code;
      if (errCode == 401) {
        logout();
      } else if(errCode == 404) {
        // DO NOTHING
      } else {
        let errDesc = err?.responseJSON?.description;
        alert("failure: " + errDesc);
      }
    },
  });
}

async function deleteAppointmentAPI(appointment_id) {
  let token = window.localStorage.getItem("health-connect-plus-user-token");
  $.ajax({
    url:
      "http://localhost:9999/health-connect-plus/appointments?appointment_id=" + appointment_id,
    crossDomain: true,
    method: "delete",
    headers: {
      accept: "application/json",
      "content-type": "application/json",
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, OPTIONS",
      "Access-Control-Allow-Headers":
        "origin, content-type, accept, authorization",
      Authorization: `bearer ${token}`,
    },
    success: async function () {
      window.location.reload();
    },
    error: function (err) {
      let errCode = err?.responseJSON.code;
      if (errCode == 401) {
        logout();
      } else {
        let errDesc = err?.responseJSON?.description;
        alert("failure: " + errDesc);
      }
    },
  });
}

async function deleteOrderAPI(order_id) {
  let token = window.localStorage.getItem("health-connect-plus-user-token");
  $.ajax({
    url:
      "http://localhost:9999/health-connect-plus/orders?order_id=" + order_id,
    crossDomain: true,
    method: "delete",
    headers: {
      accept: "application/json",
      "content-type": "application/json",
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, OPTIONS",
      "Access-Control-Allow-Headers":
        "origin, content-type, accept, authorization",
      Authorization: `bearer ${token}`,
    },
    success: async function () {
      window.location.reload();
    },
    error: function (err) {
      let errCode = err?.responseJSON.code;
      if (errCode == 401) {
        logout();
      } else {
        let errDesc = err?.responseJSON?.description;
        alert("failure: " + errDesc);
      }
    },
  });
}
