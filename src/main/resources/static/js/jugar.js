$(function () {});
async function cargarArtistas() {
  let respuesta;
  await $.ajax({
    url: "/cargarArtistas",
    //        data: {obras:'todas'},
    type: "GET",
    // async: true,
    success: function (pos, estado, xhr) {
      // alert("artistas:" + JSON.stringify(pos) + " " + estado + " " + xhr);
      respuesta = pos;
    },
    error: function (datos, estado) {
      console.log("error-> " + "datos: " + datos + "estado " + estado);
    },
  });
  return respuesta;
}

async function cargarObras() {
  let respuesta;
  await $.ajax({
    url: "/cargarObras",
    //        data: {obras:'todas'},
    type: "GET",
    async: true,
    success: function (pos, estado, xhr) {
      // alert("obras:" + JSON.stringify(pos) + " " + estado + " " + xhr);
      respuesta = pos;
    },
    error: function (datos, estado) {
      console.log("error-> " + "datos: " + datos + "estado " + estado);
    },
  });
  return respuesta;
}

function jugar(e) {
    event.preventDefault();
  let obras;
  let artistas;

  //peticion para cargar obras
  cargarObras().then((data) => {
    obras = data;
    // console.info('Obras:', data)

    //peticion para cargar artistas
    cargarArtistas().then((data) => {
      artistas = data;
      // console.info('Artistas',data)
      //generar obras aleatorias
      let obrasAleat = obraAleatoria(obras);
      console.log("Obras aleatorias" + obrasAleat);

      if (e.value == "artista") {
        jugarAveriguaArtista(obrasAleat, artistas);

      } else if ((e.value = "obra")) {
        console.log("jugar a averigua la obra");
        jugarAveriguaObra(obrasAleat, obras);
      }
    });
    
  });

}

function obraAleatoria(obras) {
  event.preventDefault();
  let cant = obras.length;
  let iObras = [];
  // let idObras=[];
  let obrasAleatorias = [];

  //generar 5 índices aleatorios de obras
  while (iObras.length < 5) {
    let num = Math.floor(Math.random() * (cant - 0)) + 0;
    if (!iObras.includes(num)) {
      iObras.push(num);
    }
  }
  //se añaden al array las 5 obras aleatorias
  $(iObras).each((i, elem) => {
    obrasAleatorias.push(obras[elem]);
  });
  return obrasAleatorias;
}

function jugarAveriguaArtista(obrasAleat, artistas) {
  event.preventDefault();
  let preguntas = [];
  //crear una pregunta por cada obra
  $(obrasAleat).each((i, elem) => {
    let codArtista = elem.codArtista;
    let artista = artistas.filter(
      (artista) => artista.codArtista == codArtista
    )[0];

    //se generan 3 artistas aleatorios como respuesta incorrecta
    let artistasIncorrectos = generaArtistasAleatorios(codArtista, artistas);
    let pregunta = {
      "categoria": "averigua artista",
      "pregunta": "¿Quién pintó la obra?",
      "respuesta": artista.nombre,
      "incorrecta1":artistasIncorrectos[0].nombre,
      "incorrecta2":artistasIncorrectos[1].nombre,
      "incorrecta3":artistasIncorrectos[2].nombre,
      "imagen":elem.imagen
    };
    preguntas.push(pregunta);
  });
  console.log(preguntas);
  localStorage.setItem("preguntas",preguntas);
}

function generaArtistasAleatorios(codArtCorrecto, artistas) {
  event.preventDefault();
  let cant = artistas.length;
  let iArtistas = [];
  let artistasAleatorios=[];
  //generar 3 índices aleatorios de artistas
  while (iArtistas.length < 3) {
    let num = Math.floor(Math.random() * (cant - 0)) + 0;
    let codArt = artistas[num].codArtista;
    if (!iArtistas.includes(num) && codArt != codArtCorrecto) {
      iArtistas.push(num);
    }
  }
  //se añaden al array los 3 artistas aleatorios
  $(iArtistas).each((i, elem) => {
    artistasAleatorios.push(artistas[elem]);
  });
  console.log(artistasAleatorios);
  return artistasAleatorios;
}
