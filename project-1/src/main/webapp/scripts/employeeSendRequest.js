window.history.replaceState('',"","/project-1/");
var lodging = false;
var travel = false;
var food = false;
var other = false;

    function checkedIt1() {
        lodging = true;
    }
    function checkedIt2() {
        travel = true;
    }
    function checkedIt3() {
        food = true;
    }
    function checkedIt4() {
        other = true;
    }

function sendReRequest() {
    console.log("send request triggered");

    let rAmount = document.getElementById('rAmount').value;

    let rReason = document.getElementById('rReason').value;

    let reviewed = false;
    let approved = false;

    var checkedText;
    if (lodging == true) {
        checkedText = "Lodging: ";
    }else if (travel == true){
        checkedText = "Travel: ";
    }else if (food == true){
        checkedText = "Food: "
    }else {
        checkedText = "Other: "
    }
    



    let userString = sessionStorage.getItem('currentUser');
    let currentUser = JSON.parse(userString);
    console.log(currentUser);

    console.log(currentUser.firstName);
    console.log(currentUser.lastName);
    console.log(currentUser.id);

    let firstName = currentUser.firstName;
    let lastName = currentUser.lastName;
    let id = currentUser.id;
    let reviewedBy = null

    console.log(approved);
    console.log(reviewed);
    
    console.log(`reqAmount: ${rAmount}`);
    console.log(`reqReason: ${rReason}`);

    
    let reimbursementTemplate = {
        firstName : firstName,
        lastName : lastName,
        reimbursementAmount: rAmount,
        reimbursementReason: checkedText + rReason,
        reviewed : false,
        approved : false,
        id: id,
        reviewedBy: null

    };
    let childDiv = document.getElementById("submittedText");
    childDiv.textContent = "Request Submitted!";

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("Success!");

            // sessionStorage.setItem('currentUser', this.responseText);
            // let userString = sessionStorage.getItem('currentUser');
            // let currentUser = JSON.parse(userString);
            // console.log(currentUser);
            
            
            
           
           console.log(sessionStorage.getItem('currentUser'));
        
        //    var frm = document.getElementsByName("requestAmount")[0];
        //    frm.submit();
        //    frm.reset();
        //    return false;
           

           

           window.location = "http://localhost:8080/project-1/employeeSendRequest.html";

            
            

        }

        if (this.readyState === 4 && this.status === 204) {
            console.log("failed to insert the reimbursement");

            let childDiv = document.getElementById('submittedText');
            childDiv.textContent = "Failed to send Request! Somethings Wrong!";
        } 
    }
    xhr.open("POST", "http://localhost:8080/project-1/sendReimRequest");

    xhr.send(JSON.stringify(reimbursementTemplate));

   
}

