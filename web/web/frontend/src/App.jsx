import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import Login from "./auth/login/login";
import JefeHome from "./home/homeJefe";
import EmpleadoHome from "./home/homeEmpleado";
import Perfil from "./profile/Perfil";
import ProtectedRoute from "./auth/ProtectedRoute";
import InventarioTienda from "./screens/inventario";
import PedidosIntermedia from "./screens/pedidosIntermedia";
import HorariosIntermedia from "./screens/horariosIntermedia";
import Empleados from "./screens/empleados";
import CrearEmpleado from "./screens/crearEmpleado";
import EmpleadoDetalles from "./screens/empleadoDetalles";
import EditarEmpleado from "./screens/editarEmpleado";
import PedidosEnRevision from "./screens/pedidosEnRevision";
import RealizarPedido from "./screens/realizarPedido";
import PedidosEnEntrega from "./screens/pedidosEnEntrega";
import RegistarLlegada from "./screens/registrarLlegada";
import PedidosRealizados from "./screens/pedidosRealizados";
import Localizacion from "./screens/localizacion";


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

        <Route path="/pedidos-mercancia" element={<PedidosIntermedia />} />

        <Route path="/pedidos-revisión" element={<PedidosEnRevision />} />

        <Route path="/gestionar-horarios" element={<HorariosIntermedia />} />

        <Route path="/empleados" element={<Empleados />} />

        <Route path="/empleados/nuevo" element={<CrearEmpleado />} />

        <Route path="/empleados/:id" element={<EmpleadoDetalles />} />

        <Route path="/empleados/:id/editar" element={<EditarEmpleado />} />

        <Route path="/pedidos/:id/realizar" element={<RealizarPedido />} />

        <Route path="/pedidos-en-entrega" element={<PedidosEnEntrega />} />

        <Route path="/pedidos/:id/registrar-llegada" element={<RegistarLlegada />} />

        <Route path="/pedidos-realizados" element={<PedidosRealizados />} />

        <Route path="/pedidos/localizacion" element={<Localizacion />} />


      </Routes>
    </BrowserRouter>
  );
}

export default App;
