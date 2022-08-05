$(function () {
  //imagen
  const element = document.getElementById("panzoom");
  const panzoom = Panzoom(element, {
    // options here
    animate: true,
    canvas: true,
    disablePan: false,
    overflow: "hidden",
    disableXAxis: false,
    disableYAxis: false,
    // min/max scale factors
    maxScale: 6,
    minScale: 1,
    // Enable panning during pinch zoom
    pinchAndPan: false,
    // X Value used to set the beginning transform
    startX: 0,
    // Y Value used to set the beginning transform
    startY: 0,
    // Contain the panzoom element either inside or outside the parent.
    // "inside" | "outside"
    contain: null,
    // set touch-action on both the Panzoom element and its parent
    touchAction: "none",
  });

  // const parent = element.parentElement;
  // parent.addEventListener("wheel", panzoom.zoomWithWheel);

  $("#zoom-in").on("click", function () {
    panzoom.zoomIn();
  });
  $("#zoom-out").on("click", function () {
    panzoom.zoomOut();
  });
  $("#zoom-reset").on("click", function () {
    panzoom.reset();
  });
});
