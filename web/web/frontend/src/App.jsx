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
import EditarPedido from "./screens/editarPedido";
import PedidosEnEntrega from "./screens/pedidosEnEntrega";
import RegistarLlegada from "./screens/registrarLlegada";
import RegistrarIncidencia from "./screens/registrarIncidencia";
import PedidosRealizados from "./screens/pedidosRealizados";
import Localizacion from "./screens/localizacion";
import ConsultarMetricas from "./screens/metricas";
import InformesRecepcion from "./screens/informesRecepcion";
import InformeInventario from "./screens/informeInventario";
import InformeLogis from "./screens/informesLogistica";
import InformeEmple from "./screens/informesEmpleado";
import GenerarHorario from "./screens/generarHorario";
import VisualizarTurnos from "./screens/visualizarTurnos";
import SolicitudesCambiosJefe from "./screens/solicitudesCambiosJefe";


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

        <Route path="/gestionar-cambios" element={<SolicitudesCambiosJefe />} />

        <Route path="/empleados" element={<Empleados />} />

        <Route path="/empleados/nuevo" element={<CrearEmpleado />} />

        <Route path="/empleados/:id" element={<EmpleadoDetalles />} />

        <Route path="/empleados/:id/editar" element={<EditarEmpleado />} />

        <Route path="/pedidos/:id/realizar" element={<RealizarPedido />} />
        <Route path="/pedidos/:id/editar" element={<EditarPedido />} />

        <Route path="/pedidos-en-entrega" element={<PedidosEnEntrega />} />

        <Route path="/pedidos/:id/registrar-llegada" element={<RegistarLlegada />} />
        <Route path="/pedidos/:id/incidencia" element={<RegistrarIncidencia />} />

        <Route path="/pedidos-realizados" element={<PedidosRealizados />} />

        <Route path="/pedidos/localizacion" element={<Localizacion />} />

        <Route path="/metricas" element={<ConsultarMetricas />} />

        <Route path="/informes-recepción" element={<InformesRecepcion />} />

        <Route path="/metricas/inventario" element={<InformeInventario/>} />

        <Route path="/metricas/eficiencia-logistica"element={<InformeLogis />}/>

        <Route path="/metricas/cumplimiento-horarios" element={<InformeEmple />} />

        <Route path="/generar-horario" element={<GenerarHorario />} />
        <Route path="/turnos" element={<VisualizarTurnos />} />


      </Routes>
    </BrowserRouter>
  );
}

export default App;
