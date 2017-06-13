//lihtne veebirakendus, mis võimaldab salvestada päevaplaani tegevusi ning neid eemaldada



window.onload = function () {
  


  
    
    document.getElementById("toDoList").addEventListener("keypress", enterDodo);

    function enterDodo(evt) {
        if (evt.key == "Enter") {
            displayToDoList(this.value);
            document.getElementById("toDoList").value = ""
        }
    }
	
	    function addZero(i) {
        if (i < 10) {
            i = "0" + i
        };
        return i;
    }
   

   function DateAndTime() {
        var aeg = new Date();
        var kp = addZero(aeg.getDate());
        var k = aeg.getMonth();
        var a = aeg.getFullYear()
        var p = aeg.getDay()
        var day = [
            "Pühapäev",
            "Esmaspäev",
            "Teisipäev",
            "Kolmapäev",
            "Neljapäev",
            "Reede",
            "Laupäev"
        ]
        var month = [
            "Jaanuar",
            "Veebruar",
            "Märts",
            "Aprill",
            "Mai",
            "Juuni",
            "Juuli",
            "August",
            "September",
            "Oktoober",
            "November",
            "Detsember"
        ]
       
        document.getElementsByClassName("date")[0].innerHTML = day[p] + ", " + kp + ". " + month[k].toLowerCase();
        dateToDO = (kp+" "+month[k].toLowerCase()+", "+day[p]+"-" +a+" :")
        setTimeout(DateAndTime, 500);
    }


 
    
DateAndTime()

displayToDoList()

}

function delrow(see) {
    var LSArray = JSON.parse(localStorage.getItem("to do:"))
    var sisu = see.previousSibling.innerText
    var match = LSArray.indexOf(sisu)
    if (LSArray.indexOf(sisu) !== -1) {
        LSArray.splice(match, 1)
        localStorage.setItem("to do:", JSON.stringify(LSArray))
        displayToDoList()
    }
}

function displayToDoList(item) {
    var LSArray = JSON.parse(localStorage.getItem("to do:")) || [];
    var table = document.getElementById("toDo");
    var kuup = document.getElementsByClassName("date")[0].innerHTML
    if (!item) {
        table.innerHTML = "<tr><th>TO DO:</th></tr>"
        for (var i = 0; i < LSArray.length; i++) {
            var row = table.insertRow(-1);
            row.innerHTML = '<div id = "xtext">' + LSArray[i] + '</div><div id = "xbutton" onclick="delrow(this)">X</div>';
        }
    } else {
        LSArray.push(dateToDO + " " + item)
        localStorage.setItem("to do:", JSON.stringify(LSArray))
        var row = table.insertRow(-1);
        row.innerHTML = '<div id = "xtext">' + dateToDO + " " + item + '</div><div id = "xbutton" onclick="delrow(this)">X</div>';;
    }
}