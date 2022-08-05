$(function () {
  $(".btn-filtrar").on("click", function () {
    $("#filtros").toggle("blind");//efecto blind
  });
  $(".btn-categorias").on("click", function () {
    $("#categorias").toggle("blind");
  });
  $(".radio-tecnica").on("click", filtroTecnicas);
  $(".radio-ubicacion").on("click", filtroUbicacion);

  $("input[name=orden]").on("change", filtroOrden);

  $("#input-buscar").on("keyup", filtroBarra)
  $("#input-buscar").on("search", filtroBarra)
});

function filtrarTodo(tecnicasSelect, ubicacionesSelec, sigloSelec) {
  if (
    tecnicasSelect.length != 0 ||
    ubicacionesSelec.length != 0 ||
    sigloSelec != null
  ) {
    $(".col-obra").filter(function (i, elem) {
      $(elem).css("display", "none");
    });
  } else {
    $(".col-obra").filter(function (i, elem) {
      $(elem).css("display", "block");
    });
  }
  //si están todos los filtros
  if (
    sigloSelec != null &&
    tecnicasSelect.length != 0 &&
    ubicacionesSelec.length != 0
  ) {
    $(".col").filter(function (i, elem) {
      let fechaObra = this.dataset.fecha;
      let sigloObra;
      if (fechaObra != undefined) {
        sigloObra = parseInt(fechaObra.slice(0, 2)) + 1;
      }
      if (sigloObra == sigloSelec) {
        ubicacionesSelec.forEach((ubicacionSelec, i) => {
          if (ubicacionSelec == this.dataset.ubicacion) {
            tecnicasSelect.forEach((tecnicaSelect, i) => {
              if (tecnicaSelect == this.dataset.tecnica) {
                $(elem).css("display", "block");
              }
            });
          }
        });
      }
    });
    //siglo+tecnicas
  } else if (
    sigloSelec != null &&
    tecnicasSelect.length != 0 &&
    ubicacionesSelec.length == 0
  ) {
    $(".col").filter(function (i, elem) {
      let fechaObra = this.dataset.fecha;
      let sigloObra;
      if (fechaObra != undefined) {
        sigloObra = parseInt(fechaObra.slice(0, 2)) + 1;
      }
      if (sigloObra == sigloSelec) {
        tecnicasSelect.forEach((tecnicaSelect, i) => {
          if (tecnicaSelect == this.dataset.tecnica) {
            $(elem).css("display", "block");
          }
        });
      }
    });
    //siglo+ubicacion
  } else if (
    sigloSelec != null &&
    tecnicasSelect.length == 0 &&
    ubicacionesSelec.length != 0
  ) {
    $(".col").filter(function (i, elem) {
      let fechaObra = this.dataset.fecha;
      let sigloObra;
      if (fechaObra != undefined) {
        sigloObra = parseInt(fechaObra.slice(0, 2)) + 1;
      }
      if (sigloObra == sigloSelec) {
        ubicacionesSelec.forEach((ubicacionSelec, i) => {
          if (ubicacionSelec == this.dataset.ubicacion) {
            $(elem).css("display", "block");
          }
        });
      }
    });
    //tecnica+ubicacion
  } else if (
    sigloSelec == null &&
    tecnicasSelect.length != 0 &&
    ubicacionesSelec.length != 0
  ) {
    tecnicasSelect.forEach((tecnicaSelec, i) => {
      $(".col").filter(function (i, elem) {
        if (tecnicaSelec == this.dataset.tecnica) {
          ubicacionesSelec.forEach((ubicacionesSelec, i) => {
            if (ubicacionesSelec == this.dataset.ubicacion) {
              $(elem).css("display", "block");
            }
          });
        }
      });
    });
    //solo siglo
  } else if (
    sigloSelec != null &&
    tecnicasSelect.length == 0 &&
    ubicacionesSelec.length == 0
  ) {
    $(".col").filter(function (i, elem) {
      let fechaObra = this.dataset.fecha;
      let sigloObra;
      if (fechaObra != undefined) {
        sigloObra = parseInt(fechaObra.slice(0, 2)) + 1;
      }
      if (sigloObra == sigloSelec) {
        $(elem).css("display", "block");
        // sigloSelec=null;
      }
    });
    //solo tecnica
  } else if (
    sigloSelec == null &&
    tecnicasSelect.length != 0 &&
    ubicacionesSelec.length == 0
  ) {
    tecnicasSelect.forEach((tecnicaSelec, i) => {
      $(".col").filter(function (i, elem) {
        if (tecnicaSelec == this.dataset.tecnica) {
          $(elem).css("display", "block");
        }
      });
    });
    //solo ubicacion
  } else if (
    sigloSelec == null &&
    tecnicasSelect.length == 0 &&
    ubicacionesSelec.length != 0
  ) {
    ubicacionesSelec.forEach((ubicacionesSelec, i) => {
      $(".col").filter(function (i, elem) {
        if (ubicacionesSelec == this.dataset.ubicacion) {
          $(elem).css("display", "block");
        }
      });
    });
  }
}

let tecnicasSelect = [];
let ubicacionesSelec = [];
let sigloSelec = null;

function filtroSiglo() {
  sigloSelec = event.target.value;
  let sigloSelecRoman = romanize(sigloSelec);
  $("#epoca-span").html(sigloSelecRoman);
  filtrarTodo(tecnicasSelect, ubicacionesSelec, sigloSelec);
}
function resetSiglo() {
  sigloSelec = null;
  $("#epoca-span").html("-");
  $(".form-range").val("12");
  filtrarTodo(tecnicasSelect, ubicacionesSelec, sigloSelec);
}
function romanize(num) {
  if (isNaN(num)) return NaN;
  var digits = String(+num).split(""),
    key = [
      "",
      "C",
      "CC",
      "CCC",
      "CD",
      "D",
      "DC",
      "DCC",
      "DCCC",
      "CM",
      "",
      "X",
      "XX",
      "XXX",
      "XL",
      "L",
      "LX",
      "LXX",
      "LXXX",
      "XC",
      "",
      "I",
      "II",
      "III",
      "IV",
      "V",
      "VI",
      "VII",
      "VIII",
      "IX",
    ],
    roman = "",
    i = 3;
  while (i--) roman = (key[+digits.pop() + i * 10] || "") + roman;
  return Array(+digits.join("") + 1).join("M") + roman;
}

function filtroTecnicas() {
  tecnicasSelect = [];
  $("#panelFiltros-tecnicas .list-group-item").each(function (i) {
    let input = $(this).children()[0];
    let tecnica = input.value;
    let checked = $(input).is(":checked");
    if (checked) {
      tecnicasSelect.push(tecnica);
    }
  });
  filtrarTodo(tecnicasSelect, ubicacionesSelec, sigloSelec);
}

function filtroUbicacion() {
  ubicacionesSelec = [];
  $("#panelFiltros-museos .list-group-item").each(function (i) {
    let input = $(this).children()[0];
    let ubicacion = input.value;
    let checked = $(input).is(":checked");
    if (checked) {
      ubicacionesSelec.push(ubicacion);
    }
  });
  filtrarTodo(tecnicasSelect, ubicacionesSelec, sigloSelec);
}

function filtroOrden() {
  console.log("orden seleccionado");
  let tipoOrden = $(this).val();
  if (tipoOrden == "asc") {
    $(".col-obra")
      .sort(function (a, b) {
        return $(a).data("fecha") - $(b).data("fecha");
      })
      .appendTo(".container-cards");
  } else if (tipoOrden == "desc") {
    $(".col-obra")
      .sort(function (a, b) {
        return $(b).data("fecha") - $(a).data("fecha");
      })
      .appendTo(".container-cards");
  }
}

function filtroBarra(){
  let valor=$(this).val().toLowerCase();
  $(".col-obra").filter(function (i, elem) {

    let tecnica=this.dataset.tecnica;
    let titulo=this.dataset.titulo;
    let ubicacion=this.dataset.ubicacion;
    let fecha=this.dataset.fecha;
    let autor=$(this).find('.nomAutor').html();

    $(this).toggle(
      tecnica.toLowerCase().indexOf(valor) > -1 || 
      titulo.toLowerCase().indexOf(valor) > -1  ||
      ubicacion.toLowerCase().indexOf(valor) > -1 ||
      fecha.toLowerCase().indexOf(valor) > -1 ||
      autor.toLowerCase().indexOf(valor) > -1
      ) 

  })
}

