function logout() {
		
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            console.log("Success!");

          
            // sessionStorage.setItem('reviewRequest', this.responseText);
            // console.log('reviewRequest');
            // let userString = sessionStorage.getItem('reviewRequest');
            // let reviewRequest = JSON.parse(userString);

            // console.log(reviewRequest);

           
            
           window.location = "http://localhost:8080/project-1/";

            
            

        }

        if (this.readyState === 4 && this.status === 204) {
            console.log("failed to do what you were trying to do here");

            
        } 
    }
    xhr.open("POST", "http://localhost:8080/project-1/logout");

    xhr.send(JSON.stringify());

    

}
    
    

    

       
    
