import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import "./registrarLlegada.css";

export default function RegistarLlegada() {
  const { id } = useParams(); // id del pedido
  const navigate = useNavigate();
  const [pedido, setPedido] = useState(null);

useEffect(() => {
  fetch(`/api/pedidos/detalle?id=${id}`)
    .then(res => {
      if (!res.ok) {
        throw new Error("Error cargando el pedido");
      }
      return res.json();
    })
    .then(data => setPedido(data))
    .catch(err => console.error(err));
}, [id]);

  if (!pedido) {
    return <p>Cargando pedido...</p>;
  }

  return (
    <div className="realizar-container">

      {/* HEADER */}
      <div className="realizar-header">
        <button className="back-btn" onClick={() => navigate(-1)}>←</button>
        <h2>Registar llegada</h2>
      </div>

      {/* LISTA DE PRODUCTOS */}
      <div className="productos-lista">
        {pedido.lineas.map(linea => (
          <div key={linea.id} className="producto-card">
            <img
              src={linea.producto.foto}
              alt={linea.producto.nombre}
              className="producto-img"
            />

            <div className="producto-info">
              <p><strong>Nombre:</strong> {linea.producto.nombre}</p>
              <p><strong>Cantidad:</strong> {linea.cantidadSolicitada} unidades.</p>
            </div>
          </div>
        ))}
      </div>

      {/* BOTONES */}
      <div className="acciones">
        <button className="btn-secundario">Pedido correcto</button>
        <button className="btn-primario">Registar incidencia</button>
      </div>

    </div>
  );
}
