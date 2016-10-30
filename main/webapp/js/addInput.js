/*var counter = 1;
var limit = 3;

var htmlStr = "<p>Hallo</p>";
htmlStr += "<input class='w3-input w3-animate-input' type='text' required style='width:50%' name='myInputs[]'>";
htmlStr += "<label class='w3-label w3-validate w3-border'>Name</label>";
htmlStr += "<input class='w3-input w3-animate-input' type='number' required style='width:50%' name='myInputs[]'>";
htmlStr += "<label class='w3-label w3-validate w3-border'>Social Security Number</label>";
htmlStr += "<input class='w3-input w3-animate-input' type='email' required style='width:50%' name='myInputs[]'>";
htmlStr += "<label class='w3-label w3-validate w3-border'>Email</label'>";
htmlStr += "<input class='w3-input w3-animate-input' type='double' required style='width:15%' name='myInputs[]'>";
htmlstr += "<label class='w3-label w3-validate w3-border'>Handicap</label>";

function addInput(divName){
     if (counter == limit)  {
          alert("You have reached the limit of adding " + counter + " participants");
     }
     else {
            var newdiv = document.createElement('div');
            newdiv.innerHTML = "Player " + (counter + 1) + htmlStr;

            document.getElementById(divName).appendChild(newdiv);
            counter++;
     }
}*/

var counter = 1;
var limit = 3;
function addInput(divName){
     if (counter == limit)  {
          alert("You have reached the limit of adding " + counter + " inputs");
     }
     else {
          var newdiv = document.createElement('div');
          newdiv.innerHTML = "Entry " + (counter + 1) + " <br><input type='text' name='myInputs[]'>";
          document.getElementById(divName).appendChild(newdiv);
          counter++;
     }
}
