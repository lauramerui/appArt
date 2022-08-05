$(function () {
  let tipoJuego = $("#divPregunta").data("juego");
  let obras;
  let artistas;
  //peticion para cargar obras
  cargarObras().then((data) => {
    obras = data;
    //peticion para cargar artistas
    cargarArtistas().then((data) => {
      artistas = data;
      //generar 5 obras aleatorias
      let obrasAleat = obraAleatoria(obras);
      if (tipoJuego == "artista") {
        jugarAveriguaArtista(obrasAleat, artistas);
      } else if ((tipoJuego = "obra")) {
        jugarAveriguarObra(obrasAleat, obras);
      }
    });
  });
});

  
  let preguntas = [];
  //genera las preguntas
  function jugarAveriguaArtista(obrasAleat, artistas) {
    preguntas = [];
    //crear una pregunta por cada obra
    $(obrasAleat).each((i, elem) => {
      let codArtista = elem.codArtista;
      let artista = artistas.filter(
        (artista) => artista.codArtista == codArtista
      )[0];

      //se generan 3 artistas aleatorios como respuesta incorrecta
      let artistasIncorrectos = generaArtistasAleatorios(codArtista, artistas);
      let pregunta = {
        respuesta: artista.nombre,
        incorrecta1: artistasIncorrectos[0].nombre,
        incorrecta2: artistasIncorrectos[1].nombre,
        incorrecta3: artistasIncorrectos[2].nombre,
        imagen: elem.imagen,
      };
      preguntas.push(pregunta);
    });
    comenzarJuego(preguntas);
  }



  //jugar averigua obra
  function jugarAveriguarObra(obrasAleat, obras) {
    preguntas = [];
    //crear una pregunta por cada obra
    $(obrasAleat).each((i, elem) => {
      let titulo = elem.titulo;

      //se generan 3 nombre aleatorios como respuesta incorrecta
      let titulosIncorrectos = generaObrasAleatorias(titulo, obras);
      let pregunta = {
        respuesta: titulo,
        incorrecta1: titulosIncorrectos[0].titulo,
        incorrecta2: titulosIncorrectos[1].titulo,
        incorrecta3: titulosIncorrectos[2].titulo,
        imagen: elem.imagen,
      };
      preguntas.push(pregunta);
    });
    comenzarJuego(preguntas);
  }

  let preguntaActual;
  let puntos=0;
  function comenzarJuego() {
    if(preguntas.length!=0){
      preguntaActual = preguntas[0];
      $("#numPreg").html(5-preguntas.length);
      preguntas.shift();
      $("#imagenJuego").attr("src", "img/obras/" + preguntaActual.imagen);
      desordenarRespuestas(preguntaActual);
      $("#puntos").html(puntos);
    }else if(preguntas.length==0){
      finalizarPartida(puntos);
      puntos=0;
    }
  }
  
  let respuestas=[];
  function desordenarRespuestas(pregunta) {
    respuestas = [
      pregunta.respuesta,
      pregunta.incorrecta1,
      pregunta.incorrecta2,
      pregunta.incorrecta3,
    ];
    
    respuestas.sort(() => Math.random() - 0.5);
    $("#btn1").html(respuestas[0]);
    $("#btn2").html(respuestas[1]);
    $("#btn3").html(respuestas[2]);
    $("#btn4").html(respuestas[3]);
  }
  
  //se pasa el indice de cada botón que corresponde con el indice de array de respuestas
  function comprobarRespuesta(i) {
    console.log(respuestas[i]==preguntaActual.respuesta)
    let btnPuls=event.target;
    if(respuestas[i]==preguntaActual.respuesta){
      $(btnPuls).removeClass("btn-preg");
      $(btnPuls).addClass("correcta");
      puntos++;
    }else{
      $(btnPuls).removeClass("btn-preg");
      $(btnPuls).addClass("incorrecta");
    }
    setTimeout(()=>{
      $(".botones .btn").each((i,btn)=>{
        $(btn).removeClass("correcta");
        $(btn).removeClass("incorrecta");
        $(btn).addClass("btn-preg");
      });
      comenzarJuego()
    },1000);
  }


  function finalizarPartida(puntos){
    //enviar puntos al servidor
    $.ajax({
      url: "/enviarPuntos",
      data: {"puntos":puntos},
//      contentType:"application/json",
//      dataType:"json",
      type: "GET",
      async: true,
       success: function (pos, estado, xhr) {
         console.log("datos recibidos:" + pos);
         window.location="/jugar-resultado?puntos="+puntos;
       },
      error: function (datos, estado) {
        console.log("error-> " + "datos: " + datos + "estado " + estado);
      },
    });
  }








  //genera 3 artistas aleatorios para las respuestas incorrectas
  function generaArtistasAleatorios(codArtCorrecto, artistas) {
    let cant = artistas.length;
    let iArtistas = [];
    let artistasAleatorios = [];
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
    return artistasAleatorios;
  }


    //genera 3 titulos aleatorios para las respuestas incorrectas
    function generaObrasAleatorias(tituloCorrecto, obras) {
      let cant = obras.length;
      let iTitulos = [];
      let titulosAleatorios = [];
      //generar 3 índices aleatorios de artistas
      while (iTitulos.length < 3) {
        let num = Math.floor(Math.random() * cant);
        let titulo = obras[num].titulo;
        if (!iTitulos.includes(num) && titulo != tituloCorrecto) {
          iTitulos.push(num);
        }
      }
      //se añaden al array los 3 artistas aleatorios
      $(iTitulos).each((i, elem) => {
        titulosAleatorios.push(obras[elem]);
      });
      return titulosAleatorios;
    }

  function obraAleatoria(obras) {
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

  //--PETICIONES--
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



