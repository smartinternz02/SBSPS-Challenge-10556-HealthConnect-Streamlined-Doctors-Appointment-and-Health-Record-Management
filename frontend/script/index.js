$(document).ready(async function () {
  await getReviewsAPI();
  let getStartedBtn = document.getElementById("get-started-btn");
  if (getStartedBtn) {
    let email = window.localStorage.getItem("health-connect-plus-email");
    if (email != null && email != "") {
      document.getElementById("get-started-btn").innerHTML = `
      <button onclick="window.location.href='profile'" id="submitBtn" class="pika-button ac-button">Profile</button>
    `;
    } else {
      document.getElementById("get-started-btn").innerHTML = `
      <button onclick="window.location.href='login'" id="submitBtn" class="pika-button ac-button">Login</button>
    `;
    }
  }
});

function logout() {
  window.localStorage.removeItem("health-connect-plus-user-token");
  window.localStorage.removeItem("health-connect-plus-email");
  window.localStorage.removeItem("health-connect-plus-type");
  window.location.href = "/login";
}

async function getReviewsAPI() {
  $.ajax({
    url: "http://localhost:9999/health-connect-plus/reviews?rating_id=*",
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
    async: true,
    success: function (reviews) {
      reviews = reviews.slice(0, 3);
      reviews.forEach(review => {
        let rating = ``;
        let rate = review.rate;
        if (rate==1) {
          rating = `&#10029;`;
        } else if(rate==2){
          rating=`&#10029;&#10029;`;
        } else if(rate==3){
          rating=`&#10029;&#10029;&#10029;`;
        } else if(rate==4){
          rating=`&#10029;&#10029;&#10029;&#10029;`;
        } else if(rate==5 || rate>5){
          rating=`&#10029;&#10029;&#10029;&#10029;&#10029;`
        }
        document.getElementById("reviews-row").innerHTML += `
      <div class="ac-icon-box__col ac-icon-box__col--three  "> 
        <div class="ac-icon-box__img-wrap"> 
        <div class="ac-icon-box__img"> 
          <img class="" src="https://cdn-icons-png.flaticon.com/512/707/707675.png" alt="doctor-icon-avatar-white_136162-58" loading="lazy" style="max-width: 100%; height: auto;"> 
        </div> 
        </div> 
        <div class="ac-icon-box__content"> 
        <div class="ac-icon-box__text"> 
          <h6>${rating}</h6> 
          <p>${review.doctor_email}</p> 
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

async function loginAPI(type, email, password) {
  const data = JSON.stringify({
    password: password,
    type: type,
    email: email,
  });

  $.ajax({
    url: "http://localhost:9999/health-connect-plus/auth/login",
    crossDomain: true,
    method: "post",
    headers: {
      accept: "application/json",
      "content-type": "application/json",
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, OPTIONS",
      "Access-Control-Allow-Headers":
        "origin, content-type, accept, authorization",
    },
    data: data,
    async: true,
    success: function (resp) {
      window.localStorage.setItem(
        "health-connect-plus-user-token",
        resp.auth_token
      );
      window.localStorage.setItem("health-connect-plus-email", resp.email);
      window.localStorage.setItem("health-connect-plus-type", resp.type);
      window.location.href = "/profile";
    },
    error: function (err) {
      let errDesc = err?.responseJSON?.description;
      alert("failure: " + errDesc);
    },
  });
}

function generateRandomId() {
  const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
  let code = '';
  for (let i = 0; i < 12; i++) {
    const randomIndex = Math.floor(Math.random() * characters.length);
    code += characters.charAt(randomIndex);
  }
  return code;
}
