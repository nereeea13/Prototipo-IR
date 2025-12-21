import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import "./realizarPedido.css";

export default function RealizarPedido() {
  const { id } = useParams(); // id del pedido
  const navigate = useNavigate();
  const [pedido, setPedido] = useState(null);
  const [saving, setSaving] = useState(false);
  const [error, setError] = useState(null);

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

  async function handleConfirmarPedido() {
    setError(null);
    setSaving(true);
    try {
      const res = await fetch(`/api/pedidos/en-preparacion?id=${id}`, {
        method: "PUT",
        headers: { Accept: "application/json" }
      });
      if (!res.ok) throw new Error(`HTTP ${res.status}`);
      const updated = await res.json();
      setPedido(updated);
      navigate(-1);
    } catch (err) {
      console.error(err);
      setError(err.message || "Error al confirmar pedido");
    } finally {
      setSaving(false);
    }
  }

  if (!pedido) {
    return <p>Cargando pedido...</p>;
  }

  return (
    <div className="realizar-container">

      {/* HEADER */}
      <div className="realizar-header">
        <button className="back-btn" onClick={() => navigate(-1)}>←</button>
        <h2>Realizar pedido</h2>
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
              <p className="stock-warning">Stock por debajo de mínimo!</p>
            </div>
          </div>
        ))}
      </div>

      {/* BOTONES */}
      <div className="acciones">
        <button className="btn-secundario" onClick={() => navigate(`/pedidos/${id}/editar`)}>Editar pedido</button>
        <button
          className="btn-primario"
          onClick={handleConfirmarPedido}
          disabled={saving}
        >
          {saving ? "Confirmando..." : "Confirmar pedido"}
        </button>
      </div>
      {error && <div className="error-msg">Error: {error}</div>}

    </div>
  );
}
