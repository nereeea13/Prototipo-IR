import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Login from "./auth/login";
import JefeHome from "./home/homeJefe";
import EmpleadoHome from "./home/homeEmpleado";

function App() {
  const role = localStorage.getItem("role");

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />

        <Route path="/jefe" element={
          role === "JEFE" ? <JefeHome/> : <Navigate to="/" />
        } />

        <Route path="/empleado" element={
          role === "EMPLEADO" ? <EmpleadoHome /> : <Navigate to="/" />
        } />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
