
 let userString = sessionStorage.getItem('currentUser');
 let currentUser = JSON.parse(userString);
 console.log(currentUser);
 window.history.replaceState('',"","/project-1/");

 console.log(`id = ${currentUser.id}`);

let userInfo = sessionStorage.getItem('empInfo');

if (userInfo === null) {
    window.location = "http://localhost8080/project-1/";
} else {
    let empInfo = JSON.parse(userInfo);
    console.log(empInfo);

    if (empInfo !== null) {
        JSON.stringify(empInfo);

        // for (property in currentUser) {
        //     console.log(`${property}: ${currentUser[property]}`);
        // }
console.log(empInfo);
        var arr = [];

        // for (property in pendingReq){
        //     arr.push(pendingReq[property]);
        // }
        for (var j = 0; j < empInfo.length; j++) {
            for (property in empInfo[j]){
                arr.push(empInfo[j][property]);

        }
    }
    

        console.log(arr);

        window.addEventListener("load", function () {
            


           
            var perrow = 11, 

                html = "<table class='table table-striped table-hover' id='employeeInfo'><tr><th>Employee Id</th><th>username</th><th>password</th><th>first name</th><th>last name</th><th>phone number</th><th>email</th><th>address</th><th>social security number</th><th>salary</th><th>manager</th></tr>";

            
            for (var i = 0; i < arr.length; i++) {
                // "NORMAL" CELL
                html += `<td>${arr[i]}</td>`;

                
                var next = i + 1;
                if (next % perrow == 0 && next != arr.length) {
                    html += "</tr><tr>";
                }
            }
            html += "</tr></table>";

            // (C) ATTACH HTML TO CONTAINER
            document.getElementById("container").innerHTML = html;
        });


    }


}

function updateUser(){
    console.log("updateUser button clicked!");
    // console.log(reviewRequest[clicked_id].accountId);
     //console.log(100004);
 
    
     let uName = document.getElementById('uName').value;
     let id = currentUser.id;


 
     let updateTemplate = {
         id : id,
         username : uName
     };
 
    //  let childDiv = document.getElementById('warningText');
    //          childDiv.textContent = "Updated!!"
     console.log(updateTemplate);
     let xhr = new XMLHttpRequest();
 
     xhr.onreadystatechange = function() {
         if (this.readyState === 4 && this.status === 200) {
             console.log("Success!");
 
             // sessionStorage.setItem('currentUser', this.responseText);
             // let userString = sessionStorage.getItem('currentUser');
             // let currentUser = JSON.parse(userString);
             // console.log(currentUser);
             
             
             
            
          //  console.log(sessionStorage.getItem('currentUser'));
            
 
          //  window.location = "http://localhost:8080/project-1/employeeInfo.html";
 
             
              
            
         }
 
         if (this.readyState === 4 && this.status === 204) {
             console.log("failed to Update!");
 
             // let childDiv = document.getElementById('warningText');
             // childDiv.textContent = "Failed to login! Username or Password was incorrect!!"
         } 
     }
     xhr.open("POST", "http://localhost:8080/project-1/updtUsername");
 
     xhr.send(JSON.stringify(updateTemplate));
 
    
 
}

function updatePass(){
    console.log("update password button clicked!");
    // console.log(reviewRequest[clicked_id].accountId);
     //console.log(100004);
 
    
     let pWord = document.getElementById('pWord').value;
     let id = currentUser.id;


 
     let updateTemplate = {
         id : id,
         password : pWord
     };
 
     console.log(updateTemplate);
     let xhr = new XMLHttpRequest();
 
     xhr.onreadystatechange = function() {
         if (this.readyState === 4 && this.status === 200) {
             console.log("Success!");
 
             // sessionStorage.setItem('currentUser', this.responseText);
             // let userString = sessionStorage.getItem('currentUser');
             // let currentUser = JSON.parse(userString);
             // console.log(currentUser);
             
             
             
            
          //  console.log(sessionStorage.getItem('currentUser'));
            
 
           // window.location = "http://localhost:8080/project-1/employeeSendRequest.html";
 
             
             
 
         }
 
         if (this.readyState === 4 && this.status === 204) {
             console.log("failed to Update!");
 
             // let childDiv = document.getElementById('warningText');
             // childDiv.textContent = "Failed to login! Username or Password was incorrect!!"
         } 
     }
     xhr.open("POST", "http://localhost:8080/project-1/updtPassword");
 
     xhr.send(JSON.stringify(updateTemplate));
 
    
 
}

function updatePhoneNum(){
    console.log("update phone number button clicked!");
    // console.log(reviewRequest[clicked_id].accountId);
     //console.log(100004);
 
    
     let pNumber = document.getElementById('pNumber').value;
     let id = currentUser.id;


 
     let updateTemplate = {
         id : id,
         phoneNumber : pNumber
     };
 
     console.log(updateTemplate);
     let xhr = new XMLHttpRequest();
 
     xhr.onreadystatechange = function() {
         if (this.readyState === 4 && this.status === 200) {
             console.log("Success!");
 
             // sessionStorage.setItem('currentUser', this.responseText);
             // let userString = sessionStorage.getItem('currentUser');
             // let currentUser = JSON.parse(userString);
             // console.log(currentUser);
             
             
             
            
          //  console.log(sessionStorage.getItem('currentUser'));
            
 
           // window.location = "http://localhost:8080/project-1/employeeSendRequest.html";
 
             
             
 
         }
 
         if (this.readyState === 4 && this.status === 204) {
             console.log("failed to Update!");
 
             // let childDiv = document.getElementById('warningText');
             // childDiv.textContent = "Failed to login! Username or Password was incorrect!!"
         } 
     }
     xhr.open("POST", "http://localhost:8080/project-1/updtPhoneNumber");
 
     xhr.send(JSON.stringify(updateTemplate));
 
    
 
}

function updateEm(){
    console.log("update email button clicked!");
    // console.log(reviewRequest[clicked_id].accountId);
     //console.log(100004);
 
    
     let eMail = document.getElementById('eMail').value;
     let id = currentUser.id;


 
     let updateTemplate = {
         id : id,
         email : eMail
     };
 
     console.log(updateTemplate);
     let xhr = new XMLHttpRequest();
 
     xhr.onreadystatechange = function() {
         if (this.readyState === 4 && this.status === 200) {
             console.log("Success!");
 
             // sessionStorage.setItem('currentUser', this.responseText);
             // let userString = sessionStorage.getItem('currentUser');
             // let currentUser = JSON.parse(userString);
             // console.log(currentUser);
             
             
             
            
          //  console.log(sessionStorage.getItem('currentUser'));
            
 
           // window.location = "http://localhost:8080/project-1/employeeSendRequest.html";
 
             
             
 
         }
 
         if (this.readyState === 4 && this.status === 204) {
             console.log("failed to Update!");
 
             // let childDiv = document.getElementById('warningText');
             // childDiv.textContent = "Failed to login! Username or Password was incorrect!!"
         } 
     }
     xhr.open("POST", "http://localhost:8080/project-1/updtEmail");
 
     xhr.send(JSON.stringify(updateTemplate));
 
    
 
}

function updateAdd(){
    console.log("update address button clicked!");
    // console.log(reviewRequest[clicked_id].accountId);
     //console.log(100004);
 
    
     let addie = document.getElementById('addie').value;
     let id = currentUser.id;


 
     let updateTemplate = {
         id : id,
         address : addie
     };
 
     console.log(updateTemplate);
     let xhr = new XMLHttpRequest();
 
     xhr.onreadystatechange = function() {
         if (this.readyState === 4 && this.status === 200) {
             console.log("Success!");
 
             // sessionStorage.setItem('currentUser', this.responseText);
             // let userString = sessionStorage.getItem('currentUser');
             // let currentUser = JSON.parse(userString);
             // console.log(currentUser);
             
             
             
            
          //  console.log(sessionStorage.getItem('currentUser'));
            
 
           // window.location = "http://localhost:8080/project-1/employeeSendRequest.html";
 
             
             
 
         }
 
         if (this.readyState === 4 && this.status === 204) {
             console.log("failed to Update!");
 
             // let childDiv = document.getElementById('warningText');
             // childDiv.textContent = "Failed to login! Username or Password was incorrect!!"
         } 
     }
     xhr.open("POST", "http://localhost:8080/project-1/updtAddress");
 
     xhr.send(JSON.stringify(updateTemplate));
 
    
 
}