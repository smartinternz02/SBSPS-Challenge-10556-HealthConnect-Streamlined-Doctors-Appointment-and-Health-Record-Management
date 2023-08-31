$(document).ready(async function () {
  await getMedicinesAPI();
});

async function getMedicinesAPI() {
  $.ajax({
    url: "http://localhost:9999/health-connect-plus/medicines?medicine_id=*",
    crossDomain: true,
    method: "get",
    headers: {
      accept: "application/json",
      "content-type": "application/json",
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, OPTIONS",
      "Access-Control-Allow-Headers":
        "origin, content-type, accept, authorization",
    },
    success: async function (medicines) {
      document.getElementById("medicines-grid").innerHTML = "";
      medicines.forEach((medicine) => {
        document.getElementById("medicines-grid").innerHTML += `
                  <div class="ac-listing-grid__column   ac-grid--left btn-unactive  ac-listing-grid__col--three"> 
                      <div class="ac-listing-grid__col-wrap"> 
                          <div class="ac-listing-grid__image"> 
                              <img class="" src="https://t4.ftcdn.net/jpg/01/32/17/61/360_F_132176161_wHAzKMpRhCX3TjlRgcEo6UvSHrf7Ibt4.jpg" alt="Events" loading="lazy" style="max-width: 100%; height: auto;"> 
                              <span class="ac-listing__tag">&#8377;${medicine.price}</span> 
                          </div> 
                          <div class="ac-listing-grid__content"> 
                              <span>${medicine.manufacturer}</span> 
                              <h5>${medicine.name}</h5> 
                              <button onclick="createOrderAPI('${medicine.medicine_id}', '${medicine.price}');" class="pika-button ac-button">Buy</button>
                          </div>
                      </div>
                  </div> 
              `;
      });
    },
    error: function (err) {
      let errCode = err?.responseJSON.code;
      if (errCode == 404) {
        // DO NOTHING
      } else {
        let errDesc = err?.responseJSON?.description;
        alert("failure: " + errDesc);
      }
    },
  });
}

function createOrderAPI(medicine_id, price) {
  let userEmail = window.localStorage.getItem("health-connect-plus-email");
  let token = window.localStorage.getItem("health-connect-plus-user-token");

  const data = JSON.stringify({
    order_id: generateRandomId(),
    user_email: userEmail,
    items: [medicine_id],
    type: "Medicine",
    "date": new Date().toJSON(),
    price: price,
  });

  $.ajax({
    url: "http://localhost:9999/health-connect-plus/orders",
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
    success: async function () {
      window.location.href = "/";
    },
    error: function (err) {
      let errCode = err?.responseJSON.code;
      if (errCode == 401) {
        logout();
      } else if (errCode == 404) {
        // DO NOTHING
      } else {
        let errDesc = err?.responseJSON?.description;
        alert("failure: " + errDesc);
      }
    },
  });
}
