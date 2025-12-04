import React from "react";
import { ShoppingCart, Box as BoxIcon, Calendar } from "lucide-react";
import BottomMenu from "../components/BottomMenu";
import { useNavigate } from "react-router-dom";
import  "./empleadosHomeEstilos.css";


export default function EmpleadoHome() {
  const id = localStorage.getItem("userId");
  const username = localStorage.getItem("username");
  console.log("Empleado ID:", id);
  console.log("Empleado Username:", username);
  console.log(localStorage)
  const navigate = useNavigate();

  return (
    <div className="empleado-container">
      <div className="empleado-header">
        <h1>Bienvenido, Empleado</h1>
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

        <button className="empleado-btn" onClick={() => navigate("/turnos")}>
          <Calendar className="btn-icon" />
          Visualizar turnos
        </button>
      </div>

      <BottomMenu />
    </div>
  );
}
