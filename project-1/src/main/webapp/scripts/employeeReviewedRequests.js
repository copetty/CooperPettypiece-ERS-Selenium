let userString = sessionStorage.getItem('reviewedReq');
window.history.replaceState('',"","/project-1/");
if (userString === null) {
    window.location = "http://localhost8080/project-1/";
} else {
    let reviewedReq = JSON.parse(userString);
    console.log(reviewedReq);

    if (reviewedReq !== null) {
        JSON.stringify(reviewedReq);

        // for (property in currentUser) {
        //     console.log(`${property}: ${currentUser[property]}`);
        // }
console.log(reviewedReq);
        var arr = [];

        // for (property in pendingReq){
        //     arr.push(pendingReq[property]);
        // }
        for (var j = 0; j < reviewedReq.length; j++) {
            for (property in reviewedReq[j]){
                arr.push(reviewedReq[j][property]);

        }
    }
    

        console.log(arr);

        window.addEventListener("load", function () {
            


           
            var perrow = 8, 

                html = "<table class='table table-striped table-hover' id='employeeInfo'><tr><th>Account Id</th><th>First Name</th><th>Last Name</th><th>Amount Requests</th><th>Reason</th><th>Reviewed</th><th>Approved</th><th>Employee Id</th></tr>";

            
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