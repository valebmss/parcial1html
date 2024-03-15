let valuesList = [];
let relationsList = [];
let relationsOriginList = [];
let counter = 1;

//Función para eliminar relaciones
function deleteRelation(id) {
  valuesList.pop(id - counter); //elimina valor de la relación
  relationsList.pop(id - counter); //elimina relación de donde viene
  relationsOriginList.pop(id - counter); //elimina relación a donde llega
  document.getElementById(`li-${id}`).remove();
  document.getElementById("generarEnlacesBtn").click();
  counter++;
}

document.addEventListener("DOMContentLoaded", () => {
  //Nombrando los elementos de la página html
  const graficarBtn = document.getElementById("graficarBtn");
  const generarEnlacesBtn = document.getElementById("generarEnlacesBtn");
  const graficaContainer = document.getElementById("grafica");
  const puntosLista = document.getElementById("puntosLista");
  const buttonAdd = document.getElementById("buttonAdd");
  const selectNodes = document.getElementById("selectNodes");
  const deleteNode = document.getElementById("deleteNode");
  const inputNodeName = document.getElementById("inputNodeName");
  const nodes = new vis.DataSet();
  const edges = new vis.DataSet();
  const data = { nodes, edges };
  const options = {};

  let addIds = 0;

  const network = new vis.Network(graficaContainer, data, options);

  //Función para refrescar los select del formulario y de eliminar
  function refresh() {
    const lis = document.querySelectorAll(".li");
    console.log(lis.length);
    for (let i = 0; i < lis.length; i++) {
      //Itera los elementos html con la clase "li"
      const li = lis[i];
      const liChildren = li.children;
      const selectOrigin = liChildren[0];
      const input = liChildren[1];
      const select = liChildren[2];

      selectOrigin.innerHTML = "";
      select.innerHTML = "";

      //Refresca los elementos html de clase "li"
      nodes.forEach((node) => {
        selectOrigin.innerHTML += `<option value="${node.id}">Nodo ${node.id}</option>`;
        select.innerHTML += `<option value="${node.id}">Nodo ${node.id}</option>`;
      });

      //Pone los valores anteriormente guardados
      if (relationsList.length > 0 && i < lis.length - 1) {
        input.value = valuesList[i];
        select.value = relationsList[i];
        selectOrigin.value = relationsOriginList[i];
      }
    }

    selectNodes.innerHTML = "";

    //Refresca los elemenos del select de borrar
    nodes.forEach((item) => {
      selectNodes.innerHTML += `<option value="${item.id}">Nodo ${item.id}</option>`;
    });
  }

  //Función para añadir una relación
  buttonAdd.addEventListener("click", () => {
    addIds++;
    const id = addIds;
    puntosLista.innerHTML += `<li class="li" id="li-${id}"><select id="selectOrigin-${id}" value="${1}"></select> <input class="input" type="text" id="${id}" value="${1}" /> <select id="select-${id}" value="${1}"></select> <button onClick="deleteRelation(${id})">Delete Relation</button></li>`;
    refresh();
  });

  //Función para añadir un nodo
  graficarBtn.addEventListener("click", () => {
    const id = inputNodeName.value;
    if (id == "") return;

    const color = "#5FDABD";

    try {
      nodes.add({
        id,
        label: id.toString(),
        color: color,
        font: { color: "white" },
      });
    } catch {
      alert("El nodo ya existe!");
      inputNodeName.value = "";
      return;
    }

    buttonAdd.disabled = false;

    refresh();
    inputNodeName.value = "";
  });

  //Función para eliminar un nodo
  deleteNode.addEventListener("click", () => {
    const lis = document.querySelectorAll(".li");
    lis.forEach((li) => {
      const id = parseInt(li.id.slice(3));
      const selectOrigin = document.getElementById(`selectOrigin-${id}`).value;
      const selectDestination = document.getElementById(`select-${id}`).value;
      if (
        selectNodes.value == selectOrigin ||
        selectNodes.value == selectDestination
      ) {
        deleteRelation(id);
      }
    });
    nodes.remove(selectNodes.value);
    refresh();
    const lastLi = document.getElementById(`li-${lis.length}`);
    const lastLiChildren = lastLi.children;
    lastLiChildren[0].value =
      relationsOriginList[relationsOriginList.length - 1];
    lastLiChildren[1].value = valuesList[valuesList.length - 1];
    lastLiChildren[2].value = relationsList[relationsList.length - 1];
  });

  //Función para generar los enlaces entre nodos con el formulario
  generarEnlacesBtn.addEventListener("click", () => {
    //Reinicia todas las relaciones
    relationsList = [];
    relationsOriginList = [];
    valuesList = [];
    edges.clear();
    const inputs = puntosLista.querySelectorAll(".input"); //Obtiene todas las entradas del formulario
    inputs.forEach((input) => {
      //Itera en  cada entrada
      const valor = input.value; //Obtiene el valor de la relación obtenida en el formulario
      const origin = document.getElementById(`selectOrigin-${input.id}`); //Obtiene el nodo del que sale la relación
      const originValue = origin.value;
      const destination = document.getElementById(`select-${input.id}`); //Obtiene el nodo al que llega la relación
      const destinationValue = destination.value;
      if (valor !== "") {
        //Valida que el input no esté vacio
        valuesList.push(valor); //Introduce el valor de la relación a la lista de valores
        relationsList.push(destinationValue); //Introduce el nodo al que llega a la lista
        relationsOriginList.push(originValue); //Introduce el nodo del que sale a la lista
        edges.add({
          //Crea la relación
          from: originValue,
          to: destinationValue,
          label: valor,
          arrows: {
            to: {
              enabled: true,
            },
          },
        });
      }
    });
  });
});