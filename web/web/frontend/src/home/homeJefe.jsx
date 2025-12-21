import BottomMenu from "../components/BottomMenu";
import React from "react";
import { ShoppingCart, Box as BoxIcon, Calendar } from "lucide-react";
import { useNavigate } from "react-router-dom";
import  "./jefeHomeEstilos.css";

export default function JefeHome() {

   const navigate = useNavigate();

return (
    <div className="empleado-container">
      <div className="empleado-header">
        <h1>Bienvenido, Jefe</h1>
      </div>

      <div className="empleado-buttons">
        <button className="empleado-btn" onClick={() => navigate("/pedidos-mercancia")}>
          <ShoppingCart className="btn-icon" />
          Pedidos de mercancía
        </button>

        <button className="empleado-btn" onClick={() => navigate("/inventario-tienda")}>
          <BoxIcon className="btn-icon" />
          Inventario de la tienda
        </button>

        <button className="empleado-btn" onClick={() => navigate("/gestionar-horarios")}>
          <Calendar className="btn-icon" />
          Gestión de horarios 
        </button>

        <button className="empleado-btn" onClick={() => navigate("/metricas")}>
          <Calendar className="btn-icon" />
          Consultar métricas 
        </button>

          <button className="empleado-btn" onClick={() => navigate("/empleados")}>
          <Calendar className="btn-icon" />
          Empleados
        </button>
      </div>

      <BottomMenu />
    </div>
  );
}
