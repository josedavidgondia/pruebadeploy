import React, { useState } from "react";
const Tabla = (props) => {
  let [contador, incrementar] = useState(1);
  const {tabla} = props;
  const multiplicar = () => {
    contador++;
    contador %= 11;
    incrementar(contador);
  }
  return (
    <>
    <div className="tabla">
      <p>Tabla del {contador}</p>
      <p>{tabla} * {contador} = {Number.parseInt(tabla) * Number.parseInt(contador)}</p>
      <button onClick={multiplicar}>{tabla} * {contador}</button>
    </div>
    </>
  );
};
export default Tabla;
