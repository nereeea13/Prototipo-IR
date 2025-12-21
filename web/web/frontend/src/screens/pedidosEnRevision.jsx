import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { ArrowLeft } from "lucide-react";
import "./pedidosRe.css";

export default function PedidosEnRevision() {
  const [pedidos, setPedidos] = useState([]);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  useEffect(() => {
    fetch("/api/pedidos/en-proceso")
      .then(res => res.json())
      .then(data => {
        setPedidos(data);
        setLoading(false);
      })
      .catch(() => setLoading(false));
  }, []);

  if (loading) {
    return <div className="center">Cargando pedidos...</div>;
  }

  return (
    <div className="pedidos-container">

      {/* HEADER */}
      <div className="pedidos-header">
        <button className="back-btn" onClick={() => navigate(-1)}>
          <ArrowLeft size={28} />
        </button>
        <h2>Pedidos en revisión</h2>
      </div>

      {/* LISTADO */}
      <div className="pedidos-lista">
        {pedidos.map(pedido => (
          <div key={pedido.id} className="pedido-card">

            <div className="pedido-info">
              <p><strong>Id de pedido:</strong> {pedido.id}</p>
              <p>
                <strong>Fecha creación:</strong>{" "}
                {pedido.fechaCreacion?.split("-").reverse().join("/")}
              </p>
            </div>

            <button
              className="realizar-btn"
              onClick={() => navigate(`/pedidos/${pedido.id}/realizar`)}
            >
              REALIZAR PEDIDO
            </button>

          </div>
        ))}
      </div>
    </div>
  );
}
