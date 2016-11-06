function myfunction() {
	var link = document.getElementById('hidden');
	if (document.getElementById('brackets').checked) {
		link.style.display = 'inline'; 
	}
	else {
		link.style.display = 'none'; 	
	}

}