$(function() {

	jQuery.extend(jQuery.validator.messages, {
		required: "Este campo es obligatorio.",
		remote: "Por favor, rellena este campo.",
		email: "Por favor, escribe una dirección de correo válida.",
		url: "Por favor, escribe una URL válida.",
		date: "Por favor, escribe una fecha válida.",
		dateISO: "Por favor, escribe una fecha (ISO) válida.",
		number: "Por favor, escribe un número entero válido.",
		digits: "Por favor, escribe sólo dígitos.",
		creditcard: "Por favor, escribe un número de tarjeta válido.",
		equalTo: "Por favor, escribe el mismo valor de nuevo.",
		accept: "Por favor, escribe un valor con una extensión aceptada.",
		maxlength: jQuery.validator.format(
			"Por favor, no escribas más de {0} caracteres."
		),
		minlength: jQuery.validator.format(
			"Por favor, no escribas menos de {0} caracteres."
		),
		rangelength: jQuery.validator.format(
			"Por favor, escribe un valor entre {0} y {1} caracteres."
		),
		range: jQuery.validator.format(
			"Por favor, escribe un valor entre {0} y {1}."
		),
		max: jQuery.validator.format(
			"Por favor, escribe un valor menor o igual a {0}."
		),
		min: jQuery.validator.format(
			"Por favor, escribe un valor mayor o igual a {0}."
		),
	});

	$.validator.addMethod(
		"patternPassw",
		function(value, element) {
			let password = value;
			if (
				!/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%&])(.{8,20}$)/.test(
					password
				)
			) {
				return false;
			}
			return true;
		},
		function(value, element) {
			let password = $(element).val();
			if (!/^(.{8,20}$)/.test(password)) {
				return "La contraseña debe contener entre 8 y 20 carácteres.";
			} else if (!/^(?=.*[A-Z])/.test(password)) {
				return "La contraseña debe contener al menos una letra mayúscula.";
			} else if (!/^(?=.*[a-z])/.test(password)) {
				return "La contraseña debe contener al menos una letra minúscula.";
			} else if (!/^(?=.*[0-9])/.test(password)) {
				return "La contraseña debe contener al menos un dígito.";
			} else if (!/^(?=.*[@#$%&])/.test(password)) {
				return "La contraseña debe contener al menos un carácter especial (@#$%&.)";
			}
			return false;
		}
	);

	$("#formLogin").validate({
		onkeyup: false,
		onblur: false,
		onclick: false,
		onfocusout: false,
		onchange: false,
		rules: {
			email: {
				required: true,
			},
			password: {
				required: true,

				remote: {
					onblur: false,
					onkeyup: false,
					url: "comprobarPassw",
					type: "post",
					data: {
						email: function() {
							return $("#emailLogin").val();
						},
						password: function() {
							return $("#passwordLogin").val();
						},
					},
				},
			},
		},
		messages: {
			password: {
				remote: "Usuario o contraseña incorrecta",
			},
		},
		errorClass: "error",
	});

	//	FORMULARIO REGISTRO
	$("#formReg").validate({
		rules: {
			nombre: {
				required: true,
				minlength: 3,
			},
			apellidos: {
				required: true,
				minlength: 3,
			},
			email: {
				required: true,
				email: true,
				remote: {
					url: "comprobarEmail",
					type: "post",
					data: {
						email: function() {
							return $("#emailReg").val();
						},
					},
				},
			},
			password: {
				required: true,
				patternPassw: true,
			},
			password2: {
				required: true,
				equalTo: "#passwordReg",
			},
		},
		messages: {
			nombre: {
				minlength: "Mínimo 3 carácteres.",
			},
			apellidos: {
				minlength: "Mínimo 3 carácteres.",
			},
			password: {
				remote: "Usuario o contraseña incorrecta.",
			},
			password2: {
				equalTo: "Las contraseñas no coinciden",
			},
			email: {
				remote: "Email ya registrado.",
			},
		},
		errorClass: "error",
	});

	// crear galería
	$("#formGaleria").validate({
		rules: {
			nombre: {
				required: true,
			},
		},
		errorClass: "error",
	});

	// cambiar contraseña
	$("#formCambiaPsw").validate({
		rules: {
			passwActual: {
				required: true,
				remote: {
					url: "comprobarPassw",
					type: "post",
					data: {
						password: function() {
							return $("#passwActual").val();
						},
					},
				},
			},
			nuevaPassw: {
				required: true,
				patternPassw: true,
			},
			nuevaPassw2: {
				required: true,
				equalTo: "#nuevaPassw",
			},
		},
		messages: {
			passwActual: {
				remote: "Contraseña incorrecta",
			},
			nuevaPassw2: {
				equalTo: "Las contraseñas no coinciden",
			},
		},
		errorClass: "error",
		validClass: "success",
	});

	// borrar cuenta usuario
	$("#formBorrarUsu").validate({
		rules: {
			passwActual: {
				required: true,
				remote: {
					url: "comprobarPassw",
					type: "post",
					data: {
						password: function() {
							return $("#confPass").val();
						},
					},
				},
			},
		},
		messages: {
			passwActual: {
				remote: "Contraseña incorrecta",
			},
		},
	});

	//alta usuario
	$("#formAltaUsu").validate({
		rules: {
			email: {
				email: true,
				required: true,
				remote: {
					url: "comprobarEmail",
					type: "post",
					data: {
						email: function() {
							return $("#email").val();
						},
					},
				},
			},
			nombre: {
				required: true,
				minlength: 3,
			},
			password: {
				required: true
			}

		},
		messages: {
			email: {
				remote: "Email ya registrado.",
			},
		}
	});
  $("#formEdit").validate({
		rules: {
			nombre: {
				required: true,

			},
		},
		messages: {

		},
	});

	$("#formEditObra").validate({
		rules: {
			titulo: {
				required: true,
				minlength: 3
			},
			// codArtista: {
			// 	required: true
			// },
			// codCorriente: {
			// 	required: true
			// },
			// fecha: {
			// 	digits: true,
			// 	maxlength: 4
			// },
			// tecnica: {
			// 	required: true,
			// 	minlength: 3
			// },
			// ubicacion: {
			// 	required: true,
			// 	minlength: 3
			// }
		}
	});


});
