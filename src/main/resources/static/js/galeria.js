$(function () {
	var elem = document.querySelector(".grid-container");
	$('.grid-container').masonry(elem, {
	  // options
	  itemSelector: ".grid-item",
	//   gutter: 10,
	  columnWidth: ".grid-sizer",
	//   isFitWidth: true,
	  percentPosition: true
	});
});