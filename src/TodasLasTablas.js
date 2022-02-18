import React, { useState } from "react";
import Tabla from "./Tabla";
const TodasLasTablas = (props) => {
    const numeros = [2, 3, 4, 5, 6, 7, 8, 9, 10]
    return (
        <>
            <div>
                <h1>Tablas: </h1>
                <ul className="grid">
                    {
                        numeros.map((num) => {
                            return (
                                <li><Tabla tabla={num} /> </li>
                            );
                        })
                    }
                </ul>
            </div>
            
        </>
    );
};
export default TodasLasTablas;