$(document).ready(async function () {
  await getDoctorsAPI();
});

async function getDoctorsAPI() {
  $.ajax({
    url: "http://localhost:9999/health-connect-plus/doctors?email=*",
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
    success: async function (doctors) {
      document.getElementById("doctors-grid").innerHTML = "";
      doctors.forEach((doc) => {
        document.getElementById("doctors-grid").innerHTML += `
                <div class="ac-listing-grid__column   ac-grid--left btn-unactive  ac-listing-grid__col--three"> 
                    <div class="ac-listing-grid__col-wrap"> 
                        <div class="ac-listing-grid__image"> 
                            <img class="" src="https://img.freepik.com/free-vector/national-doctor-s-day-hand-drawn-background_23-2149438164.jpg?w=2000" alt="Events" loading="lazy" style="max-width: 100%; height: auto;"> 
                            <span class="ac-listing__tag">&#8377;${doc.consultation_fees}</span> 
                        </div> 
                        <div class="ac-listing-grid__content"> 
                            <span>${doc.speciality}</span> 
                            <h5>${doc.email}</h5> 
                            <button onclick="bookDoctor('${doc.email}');" class="pika-button ac-button">Book</button>
                        </div>
                    </div>
                </div> 
            `;
      });
    },
    error: function (err) {
      let errDesc = err?.responseJSON?.description;
      alert("failure: " + errDesc);
    },
  });
}

function bookDoctor(email) {
  window.location.href = "book?email="+email;
}
