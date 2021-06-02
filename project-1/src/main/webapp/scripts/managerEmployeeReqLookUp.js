let managerName = sessionStorage.getItem('currentUser');
let currentManager = JSON.parse(managerName);
console.log(currentManager);

window.history.replaceState('',"","/project-1/");


function sendFirstAndLast() {

    console.log("send employee look up triggered");

    let fName = document.getElementById('fName').value;

    let lName = document.getElementById('lName').value;

    let lookUpTemplate = {
        firstName: fName,
        lastName: lName

    };

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            console.log("Success!");

            sessionStorage.setItem('singleEmployeeInfo', this.responseText);
            let userString = sessionStorage.getItem('singleEmployeeInfo');
            let singleEmployeeInfo = JSON.parse(userString);
            console.log(singleEmployeeInfo);


            ////////////////////////////////////////////////////////////////////////////////////////////////


            // let userString = sessionStorage.getItem('singleEmployeeInfo');

            if (userString === null) {
                window.location = "http://localhost8080/project-1/";
            } else {
                let singleEmployeeInfo = JSON.parse(userString);
                console.log(singleEmployeeInfo);

                if (singleEmployeeInfo !== null) {
                    JSON.stringify(singleEmployeeInfo);

                    // for (property in currentUser) {
                    //     console.log(`${property}: ${currentUser[property]}`);
                    // }
                    console.log(singleEmployeeInfo);
                    var arr = [];

                    // for (property in pendingReq){
                    //     arr.push(pendingReq[property]);
                    // }
                    for (var j = 0; j < singleEmployeeInfo.length; j++) {
                        for (property in singleEmployeeInfo[j]) {
                            arr.push(singleEmployeeInfo[j][property]);

                        }
                    }


                    console.log(arr);

                    // function findIt() {




                    //     var perrow = 8, 

                    //         html = "<table id='employeeInfo'><tr><th>Account Id</th><th>First Name</th><th>Last Name</th><th>Amount Requests</th><th>Reason</th><th>Reviewed</th><th>Approved</th><th>Employee Id</th></tr>";


                    //     for (var i = 0; i < arr.length; i++) {
                    //         // "NORMAL" CELL
                    //         html += `<td>${arr[i]}</td>`;


                    //         var next = i + 1;
                    //         if (next % perrow == 0 && next != arr.length) {
                    //             html += "</tr><tr>";
                    //         }
                    //     }
                    //     html += "</tr></table>";

                    //     // (C) ATTACH HTML TO CONTAINER
                    //     document.getElementById("container").innerHTML = html;
                    // };






                    // var perrow = 8, 

                    //     html = "<table id='employeeInfo'><tr><th>Account Id</th><th>First Name</th><th>Last Name</th><th>Amount Requests</th><th>Reason</th><th>Reviewed</th><th>Approved</th><th>Employee Id</th></tr>";


                    // for (var i = 0; i < arr.length; i++) {
                    //     // "NORMAL" CELL
                    //     html += `<td>${arr[i]}</td>`;


                    //     var next = i + 1;
                    //     if (next % perrow == 0 && next != arr.length) {
                    //         html += "</tr><tr>";
                    //     }
                    // }
                    // html += "</tr></table>";

                    // // (C) ATTACH HTML TO CONTAINER
                    // document.getElementById("container").innerHTML = html;


                    var perrow = 8,

                        html = "<table class='table table-striped table-hover' id='employeeInfo'><tr><th>Account Id</th><th>First Name</th><th>Last Name</th><th>Amount Requests</th><th>Reason</th><th>Reviewed</th><th>Approved</th><th>Employee Id</th><th>Approve/Deny</th></tr>";

                    let counter = 0;
                    for (var i = 0; i < arr.length; i++) {
                        // "NORMAL" CELL

                        html += `<td>${arr[i]}</td>`;


                        var next = i + 1;
                        if (next % perrow == 0 && next != arr.length) {
                            html += '<td class="buttonColumn"><button class="approveButton" id="' + counter + '" onclick="appReq(this.id)">Approve</button><button class="denyButton" id="' + counter + '" onclick="disReq(this.id)">Deny</button></td></tr><tr>';
                            counter++;
                        }

                    }
                    html += '<td class="buttonColumn"><button class="approveButton" id="' + (singleEmployeeInfo.length - 1) + '" onclick="appReq(this.id)">Approve</button><button class="denyButton" id="' + (singleEmployeeInfo.length - 1) + '" onclick="disReq(this.id)">Deny</button></td></tr></table>';

                    // (C) ATTACH HTML TO CONTAINER
                    document.getElementById("container").innerHTML = html;

                }


            }

            ///////////////////////////////////////////////////////////////////////////////////////////////////////


            console.log(sessionStorage.getItem('currentUser'));


            // window.location = "http://localhost:8080/project-1/employeeSendRequest.html";




        }

        if (this.readyState === 4 && this.status === 204) {
            console.log("failed to insert the reimbursement");

            // let childDiv = document.getElementById('warningText');
            // childDiv.textContent = "Failed to login! Username or Password was incorrect!!"
        }
    }
    xhr.open("POST", "http://localhost:8080/project-1/sendLookUp");

    xhr.send(JSON.stringify(lookUpTemplate));




}

function appReq(clicked_id) {
    let userString = sessionStorage.getItem('singleEmployeeInfo');
    let singleEmployeeInfo = JSON.parse(userString);
    console.log(singleEmployeeInfo);



    //     for (property in singleEmployeeInfo[clicked_id]){
    //         console.log(singleEmployeeInfo[property][clicked_id]);

    // }
    console.log(clicked_id);
    // console.log(singleEmployeeInfo[clicked_id].accountId);
    //console.log(100004);

    let requestToApprove = singleEmployeeInfo[clicked_id].accountId;

    let firstName = currentManager.firstName;
    let lastName = currentManager.lastName;

    let approveRequestTemplate = {
        accountId: requestToApprove,
        reviewedBy: firstName + " " + lastName
    };

    console.log(approveRequestTemplate);
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
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
            console.log("failed to approve reimbursement");

            // let childDiv = document.getElementById('warningText');
            // childDiv.textContent = "Failed to login! Username or Password was incorrect!!"
        }
    }
    xhr.open("POST", "http://localhost:8080/project-1/requestApproved");

    xhr.send(JSON.stringify(approveRequestTemplate));


}

function disReq(otherClicked_id) {

    //     for (property in singleEmployeeInfo[clicked_id]){
    //         console.log(singleEmployeeInfo[property][clicked_id]);

    // }

    // console.log(singleEmployeeInfo[clicked_id].accountId);
    //console.log(100004);

    let userString = sessionStorage.getItem('singleEmployeeInfo');
    let singleEmployeeInfo = JSON.parse(userString);
    console.log(singleEmployeeInfo);

    let requestToDeny = singleEmployeeInfo[otherClicked_id].accountId;

    let firstName = currentManager.firstName;
    let lastName = currentManager.lastName;

    let denyRequestTemplate = {
        accountId: requestToDeny,
        reviewedBy: firstName + " " + lastName
    };

    console.log(denyRequestTemplate);
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
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
            console.log("failed to approve reimbursement");

            // let childDiv = document.getElementById('warningText');
            // childDiv.textContent = "Failed to login! Username or Password was incorrect!!"
        }
    }
    xhr.open("POST", "http://localhost:8080/project-1/requestDenied");

    xhr.send(JSON.stringify(denyRequestTemplate));


}













