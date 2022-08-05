$(document).ready(function () {
  var slider = tns({
    container: ".slider",
    // fixedWidth: 200,
    controlsContainer: "#customize-controls",
    mouseDrag: true,
    gutter: 10,
    items: 2,
    // loop: true,
    rewind: true,
    swipeAngle: false,
    speed: 400,
    arrowKeys: true,
    responsive: {
      576: {
        items: 2,
      },
      768: {
        items: 3,
      },
      992: {
        items: 4,
      },
      1200: {
        items: 5,
      },
    },
  });
  //   slider.play();
  // $(".tns-controls button").addClass("btn-azul");

});
