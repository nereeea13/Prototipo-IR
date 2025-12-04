import { Link } from "react-router-dom";
import "./bottomMenu.css";

export default function BottomMenu() {
  const role = localStorage.getItem("role");

  const homePath = role === "JEFE" ? "/jefe" : "/empleado";

  return (
    <div className="bottom-menu">
      <Link to={homePath} className="menu-item">Inicio</Link>
      <Link to="/perfil" className="menu-item">Perfil</Link>
    </div>
  );
}
