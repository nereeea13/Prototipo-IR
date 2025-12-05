
import React from "react";
import { ShoppingCart, Box as BoxIcon, Calendar } from "lucide-react";
import { useNavigate } from "react-router-dom";
import  "./horariosIntermediaEstilos.css";
import { ArrowLeft } from "lucide-react";


export default function HorariosIntermedia() {

   const navigate = useNavigate();

return (
    <div className="empleado-container">

              {/* ==== Flecha de volver ==== */}
      <button 
        className="back-arrow"
        onClick={() => navigate("/jefe")}
        aria-label="Volver"
      >
        <ArrowLeft size={40} />
      </button>

      <div className="empleado-buttons">
        <button className="empleado-btn" onClick={() => navigate("/generar-horario")}>
          <ShoppingCart className="btn-icon" />
          Generar horario
        </button>

        <button className="empleado-btn" onClick={() => navigate("/visualizar-turnos")}>
          <BoxIcon className="btn-icon" />
          Visualizar turnos
        </button>

        <button className="empleado-btn" onClick={() => navigate("/gestionar-cambios")}>
          <Calendar className="btn-icon" />
          Gestionar cambios de turno
        </button>

      </div>

    </div>
  );
}
