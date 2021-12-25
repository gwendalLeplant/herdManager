
let tabSheep = [];

function clearDiv(div) {
	let selector = document.querySelector(div);
	while (selector.firstChild) {
		selector.removeChild(selector.firstChild);
	}
}
async function getSheepsFromServer() {
	let url = "http://localhost:8080/herdManager/SheepServlet?param=getAllSheeps";
	const response = await fetch(url);
	sheepList = await response.json();
	for (let currentSheep of sheepList.Tab) {
		tabSheep.push(currentSheep);
	}
	console.log(tabSheep);
}
function displaySheepList(list) {
	// Clear div
	clearDiv("#divDisplaySheepList");
	// Add to HTML
	for (let currentSheep of list) {
		let newSheepRow = document.importNode(
			document.querySelector("#templateDisplaySheep").content,
			true
		);
		newSheepRow.querySelector("#sheepName").innerHTML = currentSheep.name;
		newSheepRow.querySelector("#registrationNumber").innerHTML = currentSheep.registationNumber;
		document.querySelector("#divDisplaySheepList").appendChild(newSheepRow);
	}
}

function searchSheep() {
	let strToFind = document.getElementById("searchBar").value;
	let listToDisplay = [];
	document.getElementById("searchBar").value = ""; // on vide le champ input
	listToDisplay = tabSheep.filter(function(sheep) {
		return sheep.name.toLowerCase().includes(strToFind) || sheep.registationNumber.toLowerCase().includes(strToFind);
	});
	displaySheepList(listToDisplay);
}

function displaySheepOnDivMiscellaneous(e) {
	let regNum = e.parentElement.parentElement.querySelector("#registrationNumber").innerHTML;
	let sheepToDisplay;
	for (sheep of tabSheep) {
		if (sheep.registationNumber.valueOf() == regNum) {
			sheepToDisplay = sheep;
		}
	}
	if (sheepToDisplay != null) {
		clearDiv("#divDisplayMiscellaneous");
		let newSheepDiv = document.importNode(
			document.querySelector("#templateSheepOnDivMiscellaneous").content,
			true
		);
		newSheepDiv.querySelector("#sheepName").innerHTML = sheepToDisplay.name;
		newSheepDiv.querySelector("#registrationNumber").innerHTML = sheepToDisplay.registationNumber;
		newSheepDiv.querySelector("#birthDate").innerHTML = sheepToDisplay.birthDate;
		newSheepDiv.querySelector("#comments").innerHTML = sheepToDisplay.comments;
		document.querySelector("#divDisplayMiscellaneous").appendChild(newSheepDiv);
	}
}

getSheepsFromServer();




