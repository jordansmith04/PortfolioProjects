
getElementById('approve-button').addEventListener('click', ()=>{approveOrDenyRequest});

function getEmployeeTree1(){
	
	let tbody = document.getElementById('employee-list1');
	let xhr = new XMLHttpRequest(); 
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			
			document.getElementById('employee-list').remove();
			
			let response = JSON.parse(xhr.response);
			
			for(let j of response){
			let tr = document.createElement('tr');
			let id = document.createElement('td');
			let username = document.createElement('td');
			let password = document.createElement('td');
			let firstName = document.createElement('td');
			let lastName = document.createElement('td');
			let manager = document.createElement('td');
		
			id.innerHTML = j["employeeid"];
			username.innerHTML = j["username"];
			password.innerHTML = "xxxxxxxx";
			firstName.innerHTML = j["firstname"];
			lastName.innerHTML = j["lastname"];
			manager.innerHTML = j["ismanager"]
			
			tr.appendChild(id);
			tr.appendChild(username);
			tr.appendChild(password);
			tr.appendChild(firstName);
			tr.appendChild(lastName);
			tr.appendChild(manager);
			tbody.appendChild(tr);
			}
			
		}
	}
	
	
	xhr.open('GET', 'http://localhost:8080/ProjectOne/EmployeeTree'); 
	xhr.send(); 
};


function myFunction() {
    var x = document.getElementById("myLinks");
    if (x.style.display === "block") {
      x.style.display = "none";
    } else {
      x.style.display = "block";
    }
  };

function getPendingRequests1(){
	fetch("http://localhost:8080/ProjectOne/PendingRequests")
		.then((response) => {
			console.log(response);
			return response.json();
		}).then((returnedData) => {
			let tableBody = document.getElementById('pending-requests1');
			
			for(let j of returnedData){
				let tr = document.createElement('tr');
				
				let td1 = document.createElement('td');
				let td2 = document.createElement('td');
				let td3 = document.createElement('td');
				let td4 = document.createElement('td');
				
				td1.innerHTML = j["requestNumber"];
				td2.innerHTML = j["description"];
				td3.innerHTML = j["amount"];
				td4.innerHTML = j["employeeID"];
				
				
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tableBody.appendChild(tr);
			}
			
		});
	return tableBody;
}

function getPendingRequests2(){
	fetch("http://localhost:8080/ProjectOne/PendingRequests")
		.then((response) => {
			console.log(response);
			return response.json();
		}).then((returnedData) => {
			let tableBody = document.getElementById('pending-requests2');
			
			for(let j of returnedData){
				let tr = document.createElement('tr');
				
				let td1 = document.createElement('td');
				let td2 = document.createElement('td');
				let td3 = document.createElement('td');
				let td4 = document.createElement('td');
				
				td1.innerHTML = j["requestNumber"];
				td2.innerHTML = j["description"];
				td3.innerHTML = j["amount"];
				td4.innerHTML = j["employeeID"];
				
				
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tableBody.appendChild(tr);
			}
			
		});
	return tableBody;
}


function getPendingRequests3(){
	fetch("http://localhost:8080/ProjectOne/PendingRequests")
		.then((response) => {
			console.log(response);
			return response.json();
		}).then((returnedData) => {
			let tableBody = document.getElementById('pending-requests3');
			
			for(let j of returnedData){
				let tr = document.createElement('tr');
				
				let td1 = document.createElement('td');
				let td2 = document.createElement('td');
				let td3 = document.createElement('td');
				let td4 = document.createElement('td');
				
				td1.innerHTML = j["requestNumber"];
				td2.innerHTML = j["description"];
				td3.innerHTML = j["amount"];
				td4.innerHTML = j["employeeID"];
				
				
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td4);
				tableBody.appendChild(tr);
			}
			
		});
	return tableBody;
}



	function getApprovedRequests() {
		fetch('http://localhost:8080/ProjectOne/ApprovedRequests')
			.then((response) => {
				console.log(response); //response is the entire response (head and body)
				return response.json();
			}).then((returnedData) => {
				//Now do your DOM manipulation as usual.
				let tableBody = document.getElementById('approved-requests');
				
				for(let j of returnedData){
					let tr = document.createElement('tr');
					let td1 = document.createElement('td');
					let td2 = document.createElement('td');
					let td3 = document.createElement('td');
					let td5 = document.createElement('td');
					
					td1.innerHTML = j["requestNumber"];
					td2.innerHTML = j["description"];
					td3.innerHTML = j["amount"];
					td5.innerHTML = j["employeeID"];
					
					
					tr.appendChild(td1);
					tr.appendChild(td2);
					tr.appendChild(td3);
					tr.appendChild(td5);
					
					tableBody.appendChild(tr);
					
					return tableBody;
				}
			})
};

function getApprovedRequests1() {
	fetch('http://localhost:8080/ProjectOne/ApprovedRequests')
		.then((response) => {
			console.log(response); //response is the entire response (head and body)
			return response.json();
		}).then((returnedData) => {
			//Now do your DOM manipulation as usual.
			let tableBody = document.getElementById('approved-requests1');
			
			for(let j of returnedData){
				let tr = document.createElement('tr');
				let td1 = document.createElement('td');
				let td2 = document.createElement('td');
				let td3 = document.createElement('td');
				let td5 = document.createElement('td');
				
				td1.innerHTML = j["requestNumber"];
				td2.innerHTML = j["description"];
				td3.innerHTML = j["amount"];
				td5.innerHTML = j["employeeID"];
				
				
				tr.appendChild(td1);
				tr.appendChild(td2);
				tr.appendChild(td3);
				tr.appendChild(td5);
				
				tableBody.appendChild(tr);
				
				return tableBody;
			}
		})
};
function logoutUser() {
	let xhr = new XMLHttpRequest();
	
	
	xhr.onreadystatechange = function(){

		if(xhr.readyState === 4 && xhr.status === 200) {
			window.location.replace("http://localhost:8080/ProjectOne/index.html");
		}
	}
	xhr.open('GET', '/ProjectOne/Invalidate');
	xhr.send();
}


document.getElementById("logout").addEventListener("click", logoutUser);
 

//EventListeners
