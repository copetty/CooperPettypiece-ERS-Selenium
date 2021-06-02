let welcome = document.getElementById('welcome');

let userString = sessionStorage.getItem('currentUser');

window.history.replaceState('',"","/project-1/");
if (userString === null) {
    window.location = "http://localhost8080/project-1/";
} else {
    let currentUser = JSON.parse(userString);
    console.log(currentUser);

    if (currentUser != null){
        welcome.innerHTML = "Welcome " + currentUser.firstName + " " + currentUser.lastName;
    }
}

function RR() {
    console.log("RR button trigger");

    let userString = sessionStorage.getItem('currentUser');
    let currentUser = JSON.parse(userString);
    console.log(currentUser);

    console.log(`id = ${currentUser.id}`);

   let idTemplate = {
       id : currentUser.id
   };


    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("Success!");

          
            sessionStorage.setItem('pendingReq', this.responseText);
            console.log('pendingReq');
            let userString = sessionStorage.getItem('pendingReq');
            let pendingReq = JSON.parse(userString);

            console.log(pendingReq);

           
            
           window.location = "http://localhost:8080/project-1/employeeRR.html";

            
            

        }

        if (this.readyState === 4 && this.status === 204) {
            console.log("failed to do what you were trying to do here");

            
        } 
    }
    xhr.open("POST", "http://localhost:8080/project-1/employeeRequests");

    xhr.send(JSON.stringify(idTemplate));

    

}

function RevReq() {
    console.log("review requests button was pressed!");

    let userString = sessionStorage.getItem('currentUser');
    let currentUser = JSON.parse(userString);
    console.log(currentUser);

    console.log(`id = ${currentUser.id}`);

    let idTemplate = {
        id : currentUser.id
    };

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("Success!");

          
            sessionStorage.setItem('reviewedReq', this.responseText);
            console.log('reviewedReq');
            let userString = sessionStorage.getItem('reviewedReq');
            let reviewedReq = JSON.parse(userString);

            console.log(reviewedReq);

           
            
           window.location = "http://localhost:8080/project-1/employeeReviewedRequests.html";

            
            

        }

        if (this.readyState === 4 && this.status === 204) {
            console.log("failed to do what you were trying to do here");

            
        } 
    }
    xhr.open("POST", "http://localhost:8080/project-1/employeeReviewed");

    xhr.send(JSON.stringify(idTemplate));

    

}

function newReq() {
    console.log("new requests button was pressed!");

    let userString = sessionStorage.getItem('currentUser');
    let currentUser = JSON.parse(userString);
    console.log(currentUser);

    console.log(`id = ${currentUser.id}`);

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("Success!");

          
            sessionStorage.setItem('reviewedReq', this.responseText);
            console.log('reviewedReq');
            let userString = sessionStorage.getItem('reviewedReq');
            let reviewedReq = JSON.parse(userString);

            console.log(reviewedReq);

           
            
           window.location = "http://localhost:8080/project-1/employeeSendRequest.html";

            
            

        }

        if (this.readyState === 4 && this.status === 204) {
            console.log("failed to do what you were trying to do here");

            
        } 
    }
    xhr.open("POST", "http://localhost:8080/project-1/sendRequestPage");

    xhr.send(JSON.stringify());
}


function returnMyInfo(){



    console.log("new requests button was pressed!");

    let userString = sessionStorage.getItem('currentUser');
    let currentUser = JSON.parse(userString);
    console.log(currentUser);

    console.log(`id = ${currentUser.id}`);

    let idTemplate = {
        id : currentUser.id
    };

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("Success!");

          
            
            sessionStorage.setItem('empInfo', this.responseText);
            console.log('empInfo');
            let userInfo = sessionStorage.getItem('empInfo');
            let empInfo = JSON.parse(userInfo);

            console.log(empInfo);


           
            
           window.location = "http://localhost:8080/project-1/employeeInfo.html";

            
            

        }

        if (this.readyState === 4 && this.status === 204) {
            console.log("failed to do what you were trying to do here");

            
        } 
    }
    xhr.open("POST", "http://localhost:8080/project-1/returnMyself");

    xhr.send(JSON.stringify(idTemplate));
}



// function logout() {
		
//     let xhr = new XMLHttpRequest();
//     xhr.open("POST", "http://localhost:8080/project-1/logout");
//     xhr.send();

//     sessionStorage.removeItem('currentUser');
//     window.location = "http://localhost:8080/project-1/";
    
    
// }
    