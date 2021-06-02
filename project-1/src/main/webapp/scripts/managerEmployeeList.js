let userString = sessionStorage.getItem('employeeList');
window.history.replaceState('',"","/project-1/");
if (userString === null) {
    window.location = "http://localhost8080/project-1/";
} else {
    let employeeList = JSON.parse(userString);
    console.log(employeeList);

    if (employeeList !== null) {
        JSON.stringify(employeeList);

        // for (property in currentUser) {
        //     console.log(`${property}: ${currentUser[property]}`);
        // }
console.log(employeeList);
        var arr = [];

        // for (property in pendingReq){
        //     arr.push(pendingReq[property]);
        // }
        for (var j = 0; j < employeeList.length; j++) {
            for (property in employeeList[j]){
                arr.push(employeeList[j][property]);

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