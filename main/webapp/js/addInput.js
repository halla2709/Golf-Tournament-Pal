var counter = 1;
var limit = 8;
function addInput(divName){
     if (counter == limit)  {
          alert("You have reached the limit of adding " + counter + " participants");
     }
     else {
          var newdiv = document.createElement('div');
          newdiv.innerHTML = "Participant " + (counter + 1) + " <br><input type='text' name='myInputs[]'>";
          document.getElementById(divName).appendChild(newdiv);
          counter++;
     }
}