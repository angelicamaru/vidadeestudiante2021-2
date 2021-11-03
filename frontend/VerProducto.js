window.onload = function () {
  const valores = window.location.search;
  const urlParams = new URLSearchParams(valores);

  var idProducto = urlParams.get("id");

  var url = "http://localhost:8080/getProducto";
  var data = "cuaderagenda";

  fetch(url, {
    method: "POST",
    body: JSON.stringify(idProducto),
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  })
    .then(function (response) {
      return response.json();
    })
    .then(function (datas) {
      console.log(datas);
      showDatos(datas.imagen, datas.nombre, datas.descripcion, datas.precio);
    });
};

function showDatos(image, nombre, descripcion, precio) {
  const imageC = image.split("corte");
  var x = document.createElement("IMG");
  x.setAttribute("src", imageC[0]);
  x.setAttribute("width", "366");
  x.setAttribute("height", "366");
  x.setAttribute("alt", "The Pulpit Rock");
  document.getElementById("imagen").appendChild(x);
  document.getElementById("tituloProducto").innerHTML = nombre;
  document.getElementById("descripcion").innerHTML = descripcion;
  document.getElementById("precio").innerHTML = "$" + precio;
}
