import { useNavigate } from "react-router-dom";

export default function LogoutButton() {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.clear();
    navigate("/");
  };

  return (
    <button 
      style={{ backgroundColor: "red", color: "white", padding: "10px", borderRadius: "5px" }}
      onClick={handleLogout}
    >
      Cerrar sesión
    </button>
  );
}
