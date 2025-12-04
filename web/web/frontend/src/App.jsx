import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Login from "./auth/login/login";
import JefeHome from "./home/homeJefe";
import EmpleadoHome from "./home/homeEmpleado";
import Perfil from "./profile/Perfil";
import ProtectedRoute from "./auth/ProtectedRoute";
import InventarioTienda from "./screens/inventario";

function App() {
  // const role = localStorage.getItem("role");

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />

        <Route
          path="/jefe"
          element={
            <ProtectedRoute roleRequired="JEFE">
              <JefeHome />
            </ProtectedRoute>
          }
        />

        <Route
          path="/empleado"
          element={
            <ProtectedRoute roleRequired="EMPLEADO">
              <EmpleadoHome />
            </ProtectedRoute>
          }
        />

        <Route
          path="/perfil"
          element={
            <ProtectedRoute>
              <Perfil />
            </ProtectedRoute>
          }
        />

        <Route path="/inventario-tienda" element={<InventarioTienda />} />

      </Routes>
    </BrowserRouter>
  );
}

export default App;
