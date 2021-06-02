let userString = sessionStorage.getItem('reviewRequest');

// this is for the manager to approve/dissapprove requests
window.history.replaceState('',"","/project-1/");
if (userString === null) {
    window.location = "http://localhost8080/project-1/";
} else {
    let managerName = sessionStorage.getItem('currentUser');
    let currentManager = JSON.parse(managerName);
    console.log(currentManager);
    //console.log(sessionStorage.getItem('currentUser'));

    let reviewRequest = JSON.parse(userString);
    console.log(reviewRequest);

    if (reviewRequest !== null) {
        JSON.stringify(reviewRequest);

        console.log(reviewRequest);
        var arr = [];
      

        // let userString = sessionStorage.getItem('reviewRequest');
        //     let reviewRequest = JSON.parse(userString);

        //     console.log(reviewRequest)

        for (var j = 0; j < reviewRequest.length; j++) {
            for (property in reviewRequest[j]){
                arr.push(reviewRequest[j][property]);

        }

        
    }
    

        console.log(arr);

        window.addEventListener("load", function () {
            


           
            var perrow = 8, 

                html = "<table class='table table-striped table-hover' id='employeeInfo'><tr><th>Account Id</th><th>First Name</th><th>Last Name</th><th>Amount Requests</th><th>Reason</th><th>Reviewed</th><th>Approved</th><th>Employee Id</th><th>Approve/Deny</th></tr>";

            let counter = 0;
            for (var i = 0; i < arr.length; i++) {
                // "NORMAL" CELL
                
                html += `<td>${arr[i]}</td>`;

                
                var next = i + 1;
                if (next % perrow == 0 && next != arr.length) {
                    html += '<td class="buttonColumn"><button class="approveButton" id="'+counter +'" onclick="appReq(this.id)">Approve</button><button class="denyButton" id="'+counter +'" onclick="disReq(this.id)">Deny</button></td></tr><tr>';
                counter++;
                }
                
            }
            html += '<td class="buttonColumn"><button class="approveButton" id="'+(reviewRequest.length-1)+'" onclick="appReq(this.id)">Approve</button><button class="denyButton" id="'+(reviewRequest.length-1)+'" onclick="disReq(this.id)">Deny</button></td></tr></table>';

            // (C) ATTACH HTML TO CONTAINER
            document.getElementById("container").innerHTML = html;
        });

        // window.addEventListener("load", function () {
            


           
        //     var perrow = 1, 

        //         html = "<table id='employeeInfoButtons'><tr><th>App/Deny</th><tr>";

            
        //     for (var i = 0; i < reviewRequest.length; i++) {

        //         var buttonInfo = reviewRequest[i];
        //         console.log(buttonInfo);
        //         // "NORMAL" CELL
        //         html += '<td class="buttonColumn"><button id="'+i +'" onclick="appReq(this.id)">but</button><button id="'+i +'" onclick="disReq(this.id)">diss</button></td>';

        // //    <form name="appDisReq" onsubmit="appReq(this.id)"> ' +
        // //    ' <button type="submit" class="btn btn-primary" id="1">Approve</button>
        //         var next = i + 1;
        //         // i made the change here
        //         if (next % perrow == 0 && next != reviewRequest.length) {
        //             html += "</tr><tr>";
        //         }
        //     }
        //     html += "</tr></table>";

        //     // (C) ATTACH HTML TO CONTAINER
        //     document.getElementById("approvebuttons").innerHTML = html;




        // });

    }
function appReq(clicked_id) {

//     for (property in reviewRequest[clicked_id]){
//         console.log(reviewRequest[property][clicked_id]);

// }
    console.log(clicked_id);
   // console.log(reviewRequest[clicked_id].accountId);
    //console.log(100004);

    let requestToApprove = reviewRequest[clicked_id].accountId;

    let firstName = currentManager.firstName;
    let lastName = currentManager.lastName;

    let approveRequestTemplate = {
        accountId : requestToApprove,
        reviewedBy : firstName + " " + lastName
    };

    console.log(approveRequestTemplate);
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("Success!");

            // sessionStorage.setItem('currentUser', this.responseText);
            // let userString = sessionStorage.getItem('currentUser');
            // let currentUser = JSON.parse(userString);
            // console.log(currentUser);
            
            
        //         var frm = document.getElementsByName("requestAmount")[0];
        //    frm.submit();
        //    frm.reset();
        //    return false;
           
         //  console.log(sessionStorage.getItem('currentUser'));
           

         // window.location = "http://localhost:8080/project-1/managerreviewrequest.html";

            
            

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

    //     for (property in reviewRequest[clicked_id]){
    //         console.log(reviewRequest[property][clicked_id]);
    
    // }
    
       // console.log(reviewRequest[clicked_id].accountId);
        //console.log(100004);
    
        let requestToDeny = reviewRequest[otherClicked_id].accountId;
    
        let firstName = currentManager.firstName;
        let lastName = currentManager.lastName;

        let denyRequestTemplate = {
            accountId : requestToDeny,
            reviewedBy : firstName + " " + lastName
        };
    
        console.log(denyRequestTemplate);
        let xhr = new XMLHttpRequest();
    
        xhr.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
                console.log("Success!");
    
                // sessionStorage.setItem('currentUser', this.responseText);
                // let userString = sessionStorage.getItem('currentUser');
                // let currentUser = JSON.parse(userString);
                // console.log(currentUser);
                
                
        //             var frm = document.getElementsByName("requestAmount")[0];
        //    frm.submit();
        //    frm.reset();
        //    return false;
               
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

}

