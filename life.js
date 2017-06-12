var Statistics = [];
if (localStorage.getItem("lifeStatistics")) {
  Statistics = JSON.parse(localStorage.getItem("lifeStatistics"));
}

function saveData() {
  localStorage.setItem("lifeStatistics", JSON.stringify(Statistics));
}

function life(level) {
  if (level) {
    Statistics.push(true);
  } else {
    Statistics.push(false);
  }
  saveData();
  console.log("Andmed salvestatud");
  document.getElementById("answer").style.display = "none";
  document.getElementById("statistic").style.display = "block";
  document.getElementById("percentage").innerHTML = generateStats();
}

function generateStats() {
  var positives = 0, negatives = 0;
  for (var cnt = 0; cnt < Statistics.length; cnt++) {

    if (Statistics[cnt] === true)  {
      positives = Number(positives) + 1;
    } else {
      negatives = Number(negatives) + 1;
    }
  }
  return Math.round((positives*100)/(positives+negatives));
}
