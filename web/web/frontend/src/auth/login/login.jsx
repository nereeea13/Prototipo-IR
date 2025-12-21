import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./login.css"; //  <-- IMPORTA EL CSS

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    const response = await fetch("http://localhost:8080/auth/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ username, password }),
    });

    if (!response.ok) {
      alert("Credenciales incorrectas");
      return;
    }

    const data = await response.json();
    console.log(data);

    localStorage.setItem("token", data.token);
    localStorage.setItem("role", data.role);
    localStorage.setItem("userId", data.id);
    localStorage.setItem("username", data.username);
    localStorage.setItem("empleadoId", data.empleadoId);


    if (data.role === "JEFE") navigate("/jefe");
    else if (data.role === "EMPLEADO") navigate("/empleado");
  };

  return (
    <div className="login-container">
      <div className="login-card">

        <h2>Iniciar Sesión</h2>

        <form onSubmit={handleLogin} className="login-form">
          <input
            type="text"
            placeholder="Usuario"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />

          <input
            type="password"
            placeholder="Contraseña"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />

          <button type="submit">Entrar</button>
        </form>
      </div>
    </div>
  );
}

export default Login;
