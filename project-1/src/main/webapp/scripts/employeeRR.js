let welcome = document.getElementById('welcome');

window.history.replaceState('',"","/project-1/");



let userString = sessionStorage.getItem('pendingReq');

if (userString === null) {
    window.location = "http://localhost8080/project-1/";
} else {
    let pendingReq = JSON.parse(userString);
    console.log(pendingReq);

    if (pendingReq !== null) {
        JSON.stringify(pendingReq);

        // for (property in currentUser) {
        //     console.log(`${property}: ${currentUser[property]}`);
        // }
console.log(pendingReq);
        var arr = [];

        // for (property in pendingReq){
        //     arr.push(pendingReq[property]);
        // }
        for (var j = 0; j < pendingReq.length; j++) {
            for (property in pendingReq[j]){
                arr.push(pendingReq[j][property]);

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




