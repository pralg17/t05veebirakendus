function sendData() {
    var answer = document.getElementById("answer");
    var input_value = document.getElementById("prime-number").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            // Typical action to be performed when the document is ready:
            if (xhttp.responseText == "Ei ole algarv") {
                answer.innerHTML = "Sisestatud arv ei ole algarv.";
            } else if (xhttp.responseText == "Sisend ei ole arv") {

                answer.innerHTML = "Sisend ei ole arv.";
            } else {
                answer.innerHTML = "Sisestatud arv on algarv.";

            }
        }


    };

    xhttp.open("GET", "/algarv?number=" + input_value, true);
    xhttp.send();

}

