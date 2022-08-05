$(function() {
	
	$("input[type='file']").on("change", function() {

		let ruta=this.value;
		let rutaArray=ruta.split('\\');
		let filename=rutaArray[rutaArray.length-1];
		if(filename===""){
			filename="Imagen"
		}
		this.previousElementSibling.textContent = filename;
	
	})
});