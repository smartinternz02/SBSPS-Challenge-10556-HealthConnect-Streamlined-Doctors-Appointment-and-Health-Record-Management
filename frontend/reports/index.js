$(document).ready(async function () {
  await getReportsAPI();
});

async function getReportsAPI() {
  let token = window.localStorage.getItem("health-connect-plus-user-token");
  $.ajax({
    url: "http://localhost:9999/health-connect-plus/health-reports?report_id=*",
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
    success: async function (reports) {
      document.getElementById("reports-grid").innerHTML = "";
      reports.forEach((report) => {
        document.getElementById("reports-grid").innerHTML += `
                  <div class="ac-listing-grid__column   ac-grid--left btn-unactive  ac-listing-grid__col--three"> 
                      <div class="ac-listing-grid__col-wrap"> 
                          <div class="ac-listing-grid__image"> 
                              <img class="" src="https://t4.ftcdn.net/jpg/01/32/17/61/360_F_132176161_wHAzKMpRhCX3TjlRgcEo6UvSHrf7Ibt4.jpg" alt="Events" loading="lazy" style="max-width: 100%; height: auto;"> 
                              <span class="ac-listing__tag">${report.date}</span> 
                          </div> 
                          <div class="ac-listing-grid__content"> 
                              <span>${report.report_id}</span> 
                              <h5>${report.doctor_email}</h5> 
                              <button onclick="openReport('${report.url}');" class="pika-button ac-button">Open</button>
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
      } else {
        let errDesc = err?.responseJSON?.description;
        alert("failure: " + errDesc);
      }
    },
  });
}

function openReport(url) {
  window.open(url, "_blank");
}
