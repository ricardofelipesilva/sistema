var cards = document.querySelectorAll(".card");
for (var i = 0; i < cards.length; i++) {
	cards[i].querySelector(".cat").textContent;
}


var prot = document.querySelector(".prot");

prot.addEventListener("click",function(){
	event.preventDefault();
	for (var i = 0; i < cards.length; i++) {
		if(cards[i].querySelector(".cat").textContent != "CATEGORIA:  1"){
			cards[i].style.display = "none";
		}else{
			cards[i].style.display = "block";
		}
	}
});




var todos = document.querySelector(".todos");
todos.addEventListener("click",function(){
	event.preventDefault();
	for (var i = 0; i < cards.length; i++) {
			cards[i].style.display = "block";
		}
});



var lati = document.querySelector(".lati");

lati.addEventListener("click",function(){
	event.preventDefault();
	for (var i = 0; i < cards.length; i++) {
		if(cards[i].querySelector(".cat").textContent != "CATEGORIA:  2"){
			cards[i].style.display = "none";
		}else{
			cards[i].style.display = "block";
		}
	}
});


var limp = document.querySelector(".limp");

limp.addEventListener("click",function(){
	event.preventDefault();
	for (var i = 0; i < cards.length; i++) {
		if(cards[i].querySelector(".cat").textContent != "CATEGORIA:  3"){
			cards[i].style.display = "none";
		}else{
			cards[i].style.display = "block";
		}
	}
});


var carne = document.querySelector(".carne");

carne.addEventListener("click",function(){
	event.preventDefault();
	for (var i = 0; i < cards.length; i++) {
		if(cards[i].querySelector(".cat").textContent != "CATEGORIA:  4"){
			cards[i].style.display = "none";
		}else{
			cards[i].style.display = "block";
		}
	}
});