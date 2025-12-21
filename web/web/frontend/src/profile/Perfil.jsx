import React from "react";
import { ShoppingCart, Box as BoxIcon, Calendar } from "lucide-react";
import { useNavigate } from "react-router-dom";
import LogoutButton from "../auth/logout/LogoutButton";
import BottomMenu from "../components/BottomMenu";

export default function Perfil() {
  const role = localStorage.getItem("role");
  const username = localStorage.getItem("username");
  const navigate = useNavigate();

  return (
    <div style={{ paddingBottom: "70px", display: "flex", flexDirection: "column", alignItems: "center", justifyContent: "center", minHeight: "100vh" }}>
      <h1>Perfil</h1>
      <h2><strong>Usuario:</strong> {username}</h2>
      <h2><strong>Rol:</strong> {role}</h2>

      <div className="empleado-buttons">

        <button className="empleado-btn" onClick={() => navigate("/solicitudes-cambio-empleados")}>
          Solicitudes de cambio de turno
        </button>

        <button className="empleado-btn" onClick={() => navigate("/notificaciones-horarios")}>
          Notificaciones de horarios y turnos
        </button>

        <button className="empleado-btn" onClick={() => navigate("/incidencias-camiones")}>
           Incidencias de camiones
        </button>
      </div>

      <LogoutButton />

      <BottomMenu />
    </div>
  );
}
