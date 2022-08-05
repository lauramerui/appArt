$(function () {
  $(".btn-filtrar").on("click", function () {
    $("#filtros").toggle("blind"); //efecto blind
  });
  $(".btn-categorias").on("click", function () {
    $("#categorias").toggle("blind");
  });
  $(".radio-corriente").on("click", filtroCorrientes);
  $(".radio-nacionalidad").on("click", filtroNacionalidad);

  $("input[name=orden]").on("change", filtroOrden);

  $("#input-buscar").on("keyup", filtroBarra);
  $("#input-buscar").on("search", filtroBarra);
});

//orden, época, corriente, nacionalidad
function filtrarTodo(corrientesSelect, nacionalidadesSelec, sigloSelec) {
  if (
    corrientesSelect.length != 0 ||
    nacionalidadesSelec.length != 0 ||
    sigloSelec != null
  ) {
    $(".col-artista").filter(function (i, elem) {
      $(elem).css("display", "none");
    });
    $(".col-corriente").filter(function (i, elem) {
      $(elem).css("display", "none");
    });
  } else {
    $(".col-artista").filter(function (i, elem) {
      $(elem).css("display", "block");
    });
    $(".col-corriente").filter(function (i, elem) {
      $(elem).css("display", "block");
    });
  }
  //si están todos los filtros
  if (
    sigloSelec != null &&
    corrientesSelect.length != 0 &&
    nacionalidadesSelec.length != 0
  ) {
    $(".col").filter(function (i, elem) {
      let fechaObra = this.dataset.fecha;
      let sigloObra;
      if (fechaObra != undefined) {
        sigloObra = parseInt(fechaObra.slice(0, 2)) + 1;
      }
      if (sigloObra == sigloSelec) {
        nacionalidadesSelec.forEach((nacionalidadSelec, i) => {
          if (nacionalidadSelec == this.dataset.nacionalidad) {
            corrientesSelect.forEach((corrienteSelect, i) => {
              if (corrienteSelect == $(this).children().data("corriente")) {
                $(elem).css("display", "block");
              }
            });
          }
        });
      }
    });
    //siglo+corrientes
  } else if (
    sigloSelec != null &&
    corrientesSelect.length != 0 &&
    nacionalidadesSelec.length == 0
  ) {
    $(".col").filter(function (i, elem) {
      let fechaObra = this.dataset.fecha;
      let sigloObra;
      if (fechaObra != undefined) {
        sigloObra = parseInt(fechaObra.slice(0, 2)) + 1;
      }
      if (sigloObra == sigloSelec) {
        corrientesSelect.forEach((corrienteSelect, i) => {
          if (corrienteSelect == $(this).children().data("corriente")) {
            $(elem).css("display", "block");
          }
        });
      }
    });
    //siglo+nacionalidad
  } else if (
    sigloSelec != null &&
    corrientesSelect.length == 0 &&
    nacionalidadesSelec.length != 0
  ) {
    $(".col").filter(function (i, elem) {
      let fechaObra = this.dataset.fecha;
      let sigloObra;
      if (fechaObra != undefined) {
        sigloObra = parseInt(fechaObra.slice(0, 2)) + 1;
      }
      if (sigloObra == sigloSelec) {
        nacionalidadesSelec.forEach((nacionalidadSelec, i) => {
          if (nacionalidadSelec == this.dataset.nacionalidad) {
            $(elem).css("display", "block");
          }
        });
      }
    });
    //corriente+nacionalidad
  } else if (
    sigloSelec == null &&
    corrientesSelect.length != 0 &&
    nacionalidadesSelec.length != 0
  ) {
    corrientesSelect.forEach((corrienteSelec, i) => {
      $(".col").filter(function (i, elem) {
        if (corrienteSelec == $(this).children().data("corriente")) {
          nacionalidadesSelec.forEach((nacionalidadesSelec, i) => {
            if (nacionalidadesSelec == this.dataset.nacionalidad) {
              $(elem).css("display", "block");
            }
          });
        }
      });
    });
    //solo siglo
  } else if (
    sigloSelec != null &&
    corrientesSelect.length == 0 &&
    nacionalidadesSelec.length == 0
  ) {
    $(".col").filter(function (i, elem) {
      let fechaObra = this.dataset.fecha;
      let sigloObra;
      let sigloFin;
      if (fechaObra != undefined) {
        sigloObra = parseInt(fechaObra.slice(0, 2)) + 1;
        if($(".col-corriente").length>0){
          sigloFin=parseInt(fechaObra.slice(5, 7)) + 1;
        }
      }

      if (sigloObra == sigloSelec || sigloSelec>=sigloObra&&sigloSelec<=sigloFin) {
        $(elem).css("display", "block");
        // sigloSelec=null;
      }
    });
    //solo corriente
  } else if (
    sigloSelec == null &&
    corrientesSelect.length != 0 &&
    nacionalidadesSelec.length == 0
  ) {
    corrientesSelect.forEach((corrienteSelec, i) => {
      $(".col").filter(function (i, elem) {
        if (corrienteSelec == $(this).children().data("corriente")) {
          $(elem).css("display", "block");
        }
      });
    });
    //solo nacionalidad
  } else if (
    sigloSelec == null &&
    corrientesSelect.length == 0 &&
    nacionalidadesSelec.length != 0
  ) {
    nacionalidadesSelec.forEach((nacionalidadesSelec, i) => {
      $(".col").filter(function (i, elem) {
        if (nacionalidadesSelec == this.dataset.nacionalidad) {
          $(elem).css("display", "block");
        }
      });
    });
  }
}

let corrientesSelect = [];
let nacionalidadesSelec = [];
let sigloSelec = null;

function filtroSiglo() {
  sigloSelec = event.target.value;
  let sigloSelecRoman = romanize(sigloSelec);
  $("#epoca-span").html(sigloSelecRoman);
  filtrarTodo(corrientesSelect, nacionalidadesSelec, sigloSelec);
}
function resetSiglo() {
  sigloSelec = null;
  $("#epoca-span").html("-");
  $(".form-range").val("12");
  filtrarTodo(corrientesSelect, nacionalidadesSelec, sigloSelec);
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

function filtroCorrientes() {
  corrientesSelect = [];
  $("#panelFiltros-corrientes .list-group-item").each(function (i) {
    let input = $(this).children()[0];
    let corriente = input.value;
    let checked = $(input).is(":checked");
    if (checked) {
      corrientesSelect.push(corriente);
    }
  });
  filtrarTodo(corrientesSelect, nacionalidadesSelec, sigloSelec);
}

function filtroNacionalidad() {
  nacionalidadesSelec = [];
  $("#panelFiltros-nacionalidades .list-group-item").each(function (i) {
    let input = $(this).children()[0];
    let nacionalidad = input.value;
    let checked = $(input).is(":checked");
    if (checked) {
      nacionalidadesSelec.push(nacionalidad);
    }
  });
  filtrarTodo(corrientesSelect, nacionalidadesSelec, sigloSelec);
}

function filtroOrden() {
  console.log("orden seleccionado");
  let tipoOrden = $(this).val();
  if (tipoOrden == "asc") {
    $(".col-artista")
      .sort(function (a, b) {
        return $(a).data("fecha") - $(b).data("fecha");
      })
      .appendTo(".container-cards");
    //corrientes
    $(".col-corriente")
      .sort(function (a, b) {
        return $(a).data("fecha").toString().slice(0,4) - $(b).data("fecha").toString().slice(0,4);
      })
      .appendTo(".container-cards");
  } else if (tipoOrden == "desc") {
    $(".col-artista")
      .sort(function (a, b) {
        return $(b).data("fecha") - $(a).data("fecha");
      })
      .appendTo(".container-cards");

    //corrientes
    $(".col-corriente")
      .sort(function (a, b) {
        let valorA=$(a).data("fecha").toString().slice(0,4);
        let valorB= $(b).data("fecha").toString().slice(0,4);
        return valorB - valorA;
      })
      .appendTo(".container-cards");
  }
}

function filtroBarra() {
  let valor = $(this).val().toLowerCase();

  //corrientes
  if ($(".col-corriente").length > 0) {
    $(".col-corriente").filter(function (i, elem) {
      let nombre = this.dataset.nombre;
      let fecha = this.dataset.fecha;

      $(this).toggle(
        nombre.toLowerCase().indexOf(valor) > -1 ||
          fecha.toLowerCase().indexOf(valor) > -1
      );
    });
  } else if ($(".col-artista").length > 0) {
    $(".col-artista").filter(function (i, elem) {
      let corriente = $(this).children().data("corriente");
      let nombre = this.dataset.nombre;
      let nacionalidad = this.dataset.nacionalidad;
      let fecha = this.dataset.fecha;

      $(this).toggle(
          corriente.toLowerCase().indexOf(valor) > -1 ||
          nombre.toLowerCase().indexOf(valor) > -1 ||
          nacionalidad.toLowerCase().indexOf(valor) > -1 ||
          fecha.toLowerCase().indexOf(valor) > -1
      );
    });
  }
}
