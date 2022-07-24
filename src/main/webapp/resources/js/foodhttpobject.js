

window.onload = function(){ 
    getAllFood();
    document.getElementById('foodList').addEventListener("click", getFoodList);
    document.getElementById('addFood').addEventListener("click", addFood);
    document.getElementById('deleteFood').addEventListener("click", removeFood);
    ajaxGetCurrentUserInformation();
    
}

function getFoodList(){    
    let textField = document.getElementById('foodList').value;   
    
    let xhttp = new XMLHttpRequest();
        
    xhttp.onreadystatechange = function (){

        if(xhttp.readyState==4 && xhttp.status ==200){
            console.log("readyState is 4!!! AND status is 200!!!");

            let foodObj = JSON.parse(xhttp.responseText);
            console.log(foodObj);            
            displayFoodList(foodObj);          
        }
    }
  
   
        xhttp.open('GET', `http://localhost:9002/FoodServlet2/json/foodlist?`); 
     
    
       xhttp.send();
   
}

function displayFoodList(foods) {

    // var mainContainer = document.getElementById("demo");
    // for (var i = 0; i < foodObj.length; i++) {
    //   var div = document.createElement("div");
    //   div.innerHTML = foodObj[i].foodId + '  ' + foodObj[i].foodName;
    //   mainContainer.appendChild(div);
    // }

    let ol = document.getElementById("demo");
    for(let i = 0; i < foods.length; i++) {
        let li = document.createElement("li");
        let text = document.createTextNode(foods[i].foodId + " " +foods[i].foodName);
        li.appendChild(text);
        ol.appendChild(li);
    }

}

function addFood() {
    
    let xhttp = new XMLHttpRequest;

    xhttp.open('POST', `http://localhost:9002/FoodServlet2/food/addfood`);
    xhttp.setRequestHeader("content-type", "application/json");

    xhttp.onreadystatechange = function(){
        if (xhttp.readyState == 4 && xhttp.status== 200) {            
            
            let foodObj = xhttp.responseText;
            // console.log(food);
            console.log(foodObj);
            
        }
    }

    let newFoodName = document.getElementById("foodName").value;
    
    let newFood = {
        "foodName" : newFoodName
    }

    //xhttp.setRequestHeader("content-type", "text/html");    
    //xhttp.send(food);
    xhttp.send(JSON.stringify(newFood));
    //xhttp.send();
}

function removeFood() {   
    
    let xhttp = new XMLHttpRequest;
    
    
    xhttp.open('POST', `http://localhost:9002/FoodServlet2/food/deletefood`);
    xhttp.setRequestHeader("content-type", "application/json");
    
    xhttp.onreadystatechange = function(){
        if (xhttp.readyState == 4 && xhttp.status== 200) {            
            
            let foodObj = xhttp.responseText;
            // console.log(food);
            console.log(foodObj);
            
        }
    }
    
    let myFoodId = document.getElementById("foodId").value; 

    let foodTodelete = {
        "foodId" : myFoodId
    }

    xhttp.send(JSON.stringify(foodTodelete));
    
}

function ajaxGetCurrentUserInformation(){
	let xhttp = new XMLHttpRequest();

   xhttp.onreadystatechange = function (){

        if(xhttp.readyState==4 && xhttp.status==200){
            let currentUser = JSON.parse(xhttp.responseText);

            ourDOMManipulationONE(currentUser);
        }
   }

    xhttp.open('GET', `http://localhost:9002/FoodServlet2/json/getCurrentUserObject`);

   xhttp.send();
}


function ourDOMManipulationONE(ourResponseObject){
	console.log(ourResponseObject);

	document.getElementById("welcomeTextName").innerText = "Welcome, " + ourResponseObject.userName; 
	
	// let powersArray = ourResponseObject.superpower;
	// let powersString = "";
	// for(let i =0 ; i<powersArray.length; i++){
	// 	powersString += powersArray[i] + "\t";
	// }
	
	// document.getElementById("welcomeTextPowers").innerText = "Your Powers Are: " + powersString; 
}
    
function getAllFood() {
    let xhttp = new XMLHttpRequest;

    xhttp.onreadystatechange = function(){
        if (xhttp.readyState==4 && xhttp.status==200) {
            let allFood = JSON.parse(xhttp.responseText);
            console.log(allFood);

            displayFoodList(allFood);
        }
    }

    xhttp.open('GET', `http://localhost:9002/FoodServlet2/json/foodlist?`);

    xhttp.send();
}    

function displayFood(food, location) {
    if(food.foodName == undefined) {
        document.getElementById(location).innerText = food;
    }else {
        document.getElementById(location).innerText = food.foodName;
    }
}

function displayResult(string, location) {
    document.getElementById(location).innerText = string;
}