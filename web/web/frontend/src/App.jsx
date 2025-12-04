import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Login from "./pages/Login";
import JefeHome from "./pages/JefeHome";
import EmpleadoHome from "./pages/EmpleadoHome";

function App() {
  const role = localStorage.getItem("role");

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />

        <Route path="/jefe" element={
          role === "JEFE" ? <JefeHome /> : <Navigate to="/" />
        } />

        <Route path="/empleado" element={
          role === "EMPLEADO" ? <EmpleadoHome /> : <Navigate to="/" />
        } />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
