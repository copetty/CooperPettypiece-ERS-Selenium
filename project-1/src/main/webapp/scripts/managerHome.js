window.history.replaceState('',"","/project-1/");
function RevReq() {
    console.log("Review request button trigger");
    // this is for seeing requests that haven't been approved yet

    let userString = sessionStorage.getItem('currentUser');
    let currentUser = JSON.parse(userString);
    console.log(currentUser);

    console.log(`id = ${currentUser.id}`);

   


    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("Success!");

          
            sessionStorage.setItem('reviewRequest', this.responseText);
            console.log('reviewRequest');
            let userString = sessionStorage.getItem('reviewRequest');
            let reviewRequest = JSON.parse(userString);

            console.log(reviewRequest);

           
            
           window.location = "http://localhost:8080/project-1/managerreviewrequest.html";

            
            

        }

        if (this.readyState === 4 && this.status === 204) {
            console.log("failed to do what you were trying to do here");

            
        } 
    }
    xhr.open("POST", "http://localhost:8080/project-1/reviewRequest");

    xhr.send(JSON.stringify());

    

}

function lookUpResolved(){

    console.log("resolve request button trigger");
    // this is for seeing requests that haven't been approved yet

    let userString = sessionStorage.getItem('currentUser');
    let currentUser = JSON.parse(userString);
    console.log(currentUser);

    console.log(`id = ${currentUser.id}`);

   


    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("Success!");

          
            sessionStorage.setItem('resolvedRequests', this.responseText);
            console.log('resolvedRequests');
            let userString = sessionStorage.getItem('resolvedRequests');
            let resolvedRequests = JSON.parse(userString);

            console.log(resolvedRequests);

           
            
           window.location = "http://localhost:8080/project-1/managerResolvedRequests.html";

            
            

        }

        if (this.readyState === 4 && this.status === 204) {
            console.log("failed to do what you were trying to do here");

            
        } 
    }
    xhr.open("POST", "http://localhost:8080/project-1/lookUpResolvedReq");

    xhr.send(JSON.stringify());


}

function employeeReqLookUp() {

    console.log("employee look up button trigger");
    // this is for seeing requests that haven't been approved yet

    let userString = sessionStorage.getItem('currentUser');
    let currentUser = JSON.parse(userString);
    console.log(currentUser);

    console.log(`id = ${currentUser.id}`);

   


    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("Success!");

          
            

           
            
           window.location = "http://localhost:8080/project-1/managerEmployeeReqLookUp.html";

            
            

        }

        if (this.readyState === 4 && this.status === 204) {
            console.log("failed to do what you were trying to do here");

            
        } 
    }
    xhr.open("POST", "http://localhost:8080/project-1/resolveOne");

    xhr.send(JSON.stringify());


}

function returnEmployeeList(){


    

    //console.log(`id = ${currentUser.id}`);

   


    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("Success!");

          
            console.log("employee list button trigger");
    // this is for seeing requests that haven't been approved yet
    sessionStorage.setItem('employeeList', this.responseText);
 let userString = sessionStorage.getItem('employeeList');
    let employeeList = JSON.parse(userString);
    console.log(employeeList);

           
            
           window.location = "http://localhost:8080/project-1/managerEmployeeList.html";

            
            

        }

        if (this.readyState === 4 && this.status === 204) {
            console.log("failed to do what you were trying to do here");

            
        } 
    }
    xhr.open("POST", "http://localhost:8080/project-1/empList");

    xhr.send(JSON.stringify());


}