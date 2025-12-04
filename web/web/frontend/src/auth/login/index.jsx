import { useState } from "react";
import { login } from "../../api/api";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const [username, setUser] = useState("");
  const [password, setPass] = useState("");
  const navigate = useNavigate();

  const handleLogin = async () => {
    const res = await login(username, password);

    if (res.error) {
      alert("Usuario o contraseña incorrectos");
      return;
    }

    localStorage.setItem("token", res.token);
    localStorage.setItem("role", res.role);

    if (res.role === "JEFE") navigate("/jefe");
    else navigate("/empleado");
  };

  return (
    <div>
      <h2>Login</h2>
      <input placeholder="Usuario" onChange={e => setUser(e.target.value)} />
      <input placeholder="Contraseña" type="password" onChange={e => setPass(e.target.value)} />
      <button onClick={handleLogin}>Entrar</button>
    </div>
  );
}
