import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import "./registrarLle.css";

export default function RegistrarLlegada() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [pedido, setPedido] = useState(null);
  const [recibidos, setRecibidos] = useState({});
  const [showModal, setShowModal] = useState(false);

  useEffect(() => {
    fetch(`/api/pedidos/detalle?id=${id}`)
      .then(res => {
        if (!res.ok) throw new Error("Error cargando el pedido");
        return res.json();
      })
      .then(data => {
        setPedido(data);
        const map = {};
        if (data?.lineas) {
          data.lineas.forEach(l => {
            map[l.producto.id] = l.cantidadSolicitada || 0;
          });
        }
        setRecibidos(map);
      })
      .catch(err => console.error(err));
  }, [id]);

  if (!pedido) return <p>Cargando pedido...</p>;

  async function handleRegistrarLlegada() {
    const body = {
      lineas: Object.keys(recibidos).map(pid => ({
        productoId: Number(pid),
        cantidadRecibida: Number(recibidos[pid])
      }))
    };

    try {
      const res = await fetch(`/api/pedidos/${id}/llegada`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
      });

      if (!res.ok) throw new Error();
      await res.json();

      // 👉 MOSTRAMOS MODAL
      setShowModal(true);

    } catch (err) {
      console.error(err);
      alert("Error registrando llegada");
    }
  }

  return (
    <div className="realizar-container">

      {/* HEADER */}
      <div className="realizar-header">
        <button className="back-btn" onClick={() => navigate(-1)}>←</button>
        <h2>Registrar llegada</h2>
      </div>

      {/* LISTA */}
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
              <p><strong>Cantidad pedida:</strong> {linea.cantidadSolicitada} unidades</p>
            </div>
          </div>
        ))}
      </div>

      {/* BOTONES */}
      <div className="acciones">
        <button
          type="button"
          className="btn-secundario"
          onClick={e => { e.preventDefault(); e.stopPropagation(); handleRegistrarLlegada(); }}
        >
          Pedido correcto
        </button>

        <button
          type="button"
          className="btn-primario"
          onClick={e => { e.preventDefault(); e.stopPropagation(); navigate(`/pedidos/${id}/incidencia`, { state: { pedido, recibidos } }); }}
        >
          Registrar incidencia
        </button>
      </div>

      {/* ===== MODAL ===== */}
      {showModal && (
        <div className="modal-overlay">
          <div className="modal-card modal-confirmacion">
            <p className="modal-text">
              Informe de recepción del pedido <strong>{id}</strong> ha sido
              generado correctamente
            </p>

            <button
              className="modal-ver-btn"
              onClick={() => navigate(`/informes/recepcion/${id}`)}
            >
              Visualizar
            </button>
          </div>
        </div>
      )}

    </div>
  );
}
