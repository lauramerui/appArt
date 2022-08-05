$(function() {
	$('#tablaUsuarios').DataTable({
    "columnDefs": [
        {"orderDataType": "dom-text",
            "targets": [2,3,4]
         },
         {"orderDataType": false,
            "targets": [0,6,7]
         },

    ],
    language: {
            url: 'https://cdn.datatables.net/plug-ins/1.12.1/i18n/es-ES.json'
        }
	});
	
	$('#tablaObras').DataTable({
  "columnDefs": [ {
      "targets": [0,8],
      "searchable": false
    } ],
    language: {
            url: 'https://cdn.datatables.net/plug-ins/1.12.1/i18n/es-ES.json'
        }
	});

    $('#tablaCorrientes').DataTable({
        "columnDefs": [ {
            "targets": 0,
            "searchable": false
          } ],
          language: {
                  url: 'https://cdn.datatables.net/plug-ins/1.12.1/i18n/es-ES.json'
              }
          });
	    $('#tablaArtistas').DataTable({
        "columnDefs": [ {
            "targets": 0,
            "searchable": false
          } ],
          language: {
                  url: 'https://cdn.datatables.net/plug-ins/1.12.1/i18n/es-ES.json'
              }
          });
    
});