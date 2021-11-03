function enviarformulario() {
  var nombre = document.getElementById("nombre-apellido").value;
  var correo = document.getElementById("correo").value;
  var clave = document.getElementById("contraseña").value;
  var confirmar = document.getElementById("confirmar").value;

  var clear = () => {
    document.getElementById("nombre-apellido").value = "";
    document.getElementById("correo").value = "";
    document.getElementById("contraseña").value = "";
    document.getElementById("confirmar").value = "";
  };
  clear();

  if (clave != confirmar) {
    document.getElementById("error").classList.add("mostrar");
    return false;
  } else {
    document.getElementById("error").classList.remove("mostrar");
    var obtenerRegistro = () => {
      var usuario = {
        id: null,
        nombre: nombre,
        correo: correo,
        clave: clave,
      };
      return usuario;
    };
    var data = obtenerRegistro();
    console.log("LLEGUE AQUI");
    fetch("http://localhost:8080/addUsuario", {
      method: "POST",
      body: JSON.stringify(data),
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((datas) => {
        var x = datas;
        console.log(datas);
        x ? null : alert("Usuario ya esta registrado con este correo");
        location.href = "inicio.html";
      })
      .catch((error) => console.log("error!"))
      .then(console.log("Si entro al fetch!"));
  }
}
