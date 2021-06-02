function sendLogin() {
    console.log("send login triggered");

    let uName = document.getElementById('uName').value;

    let pWord = document.getElementById('pWord').value;

    
    console.log(`Username: ${uName}`);
    console.log(`Password: ${pWord}`);


    let loginTemplate = {
        username: uName,
        password: pWord
    };

    

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("Success!");

            sessionStorage.setItem('currentUser', this.responseText);
            let userString = sessionStorage.getItem('currentUser');
            let currentUser = JSON.parse(userString);
            
            
            if (currentUser.manager == false){
           window.location = "http://localhost:8080/project-1/employeeHome.html";
            } else if (currentUser.manager == true){
                window.location = "http://localhost:8080/project-1/managerHome.html";
            }
           
            console.log(sessionStorage.getItem('currentUser'));
           

           

            
            

        }

        if (this.readyState === 4 && this.status === 204) {
            console.log("failed to find the user");

            let childDiv = document.getElementById('warningText');
            childDiv.textContent = "Failed to login! Username or Password was incorrect!!"
        } 
    }
    xhr.open("POST", "http://localhost:8080/project-1/login");

    xhr.send(JSON.stringify(loginTemplate));

   
}