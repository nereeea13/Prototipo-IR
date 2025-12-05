
import React from "react";
import { ShoppingCart, Box as BoxIcon, Calendar } from "lucide-react";
import { useNavigate } from "react-router-dom";
import  "./pedidosIntermediaEstilos.css";
import { ArrowLeft } from "lucide-react";


export default function PedidosIntermedia() {

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
        <button className="empleado-btn" onClick={() => navigate("/pedidos-revisión")}>
          <ShoppingCart className="btn-icon" />
          Pedidos en revisión
        </button>

        <button className="empleado-btn" onClick={() => navigate("/pedidos-realizados")}>
          <BoxIcon className="btn-icon" />
          Pedidos realizados
        </button>

        <button className="empleado-btn" onClick={() => navigate("/registrar-llegada")}>
          <Calendar className="btn-icon" />
          Registrar llegada
        </button>

          <button className="empleado-btn" onClick={() => navigate("/informes-recepción")}>
          <Calendar className="btn-icon" />
          Informes de recepción
        </button>
      </div>

    </div>
  );
}
