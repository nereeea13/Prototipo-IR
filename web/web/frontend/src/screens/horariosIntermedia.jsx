
import React from "react";
import { ShoppingCart, Box as BoxIcon, Calendar } from "lucide-react";
import { useNavigate } from "react-router-dom";
import  "./horariosIntermediaEstilos.css";
import { ArrowLeft } from "lucide-react";


export default function HorariosIntermedia() {

   const navigate = useNavigate();

   const handleGenerarHorario = async () => {
     try {
       await fetch('/api/horarios/cambiar', { method: 'POST' });
     } catch (e) {
       console.error('Error cambiando horario', e);
     } finally {
       navigate('/generar-horario');
     }
   };

return (
    <div className="empleado-container">
    <div className="empleado-header-bar">
      <button
        onClick={() => navigate("/jefe")}
        style={{
          position: "fixed",
          top: "20px",
          left: "20px",
          zIndex: 9999,
          background: "transparent",
          border: "none",
          cursor: "pointer"
        }}
        aria-label="Volver"
      >
        <ArrowLeft size={48} color="red" strokeWidth={2.5} />
      </button>

      </div>

      <div className="empleado-buttons">
        <button className="empleado-btn" onClick={handleGenerarHorario}>
          <ShoppingCart className="btn-icon" />
          Generar horario
        </button>

        <button className="empleado-btn" onClick={() => navigate("/turnos")}>
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
