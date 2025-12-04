
import BottomMenu from "../components/BottomMenu";

export default function EmpleadoHome() {
  const id = localStorage.getItem("userId");
  const username = localStorage.getItem("username");
  console.log("Empleado ID:", id);
  console.log("Empleado Username:", username);
  console.log(localStorage)
  return (
    <div style={{ paddingBottom: "70px" }}>
      <h1>Bienvenido, {username} con id: {id}</h1>

      <BottomMenu />
    </div>
  );
}
