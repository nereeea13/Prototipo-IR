import LogoutButton from "../auth/logout/LogoutButton";
import BottomMenu from "../components/BottomMenu";

export default function Perfil() {

  const role = localStorage.getItem("role");
  const username = localStorage.getItem("username");

  return (
    <div style={{ paddingBottom: "70px" }}>
      <h1>Perfil</h1>
      <p><strong>Usuario:</strong> {username}</p>
      <p><strong>Rol:</strong> {role}</p>

      <LogoutButton />

      <BottomMenu />
    </div>
  );
}
