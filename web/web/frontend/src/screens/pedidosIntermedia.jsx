
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
        <button className="empleado-btn" onClick={() => navigate("/pedidos-revisión")}>
          <ShoppingCart className="btn-icon" />
          Pedidos en revisión
        </button>

        <button className="empleado-btn" onClick={() => navigate("/pedidos-realizados")}>
          <BoxIcon className="btn-icon" />
          Pedidos realizados
        </button>

        <button className="empleado-btn" onClick={() => navigate("/pedidos-en-entrega")}>
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
