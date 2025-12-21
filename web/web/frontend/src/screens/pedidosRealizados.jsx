import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { ArrowLeft } from "lucide-react";
import "./pedidosReali.css";

export default function PedidosRealizados() {
  const [pedidos, setPedidos] = useState([]);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  useEffect(() => {
    fetch("/api/pedidos/todos-pedidos")
      .then(res => res.json())
      .then(data => {
        setPedidos(data);
        setLoading(false);
      })
      .catch(err => {
        console.error(err);
        setLoading(false);
      });
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
        <h2>Pedidos realizados</h2>
      </div>

      {/* LISTADO */}
      <div className="pedidos-lista">
        {pedidos.length === 0 && (
          <p>No hay pedidos disponibles</p>
        )}

        {pedidos.map(pedido => (
          <div key={pedido.id} className="pedido-card">

            {/* INFO */}
            <div className="pedido-info">
              <p><strong>Pedido {pedido.id} </strong></p>
              <p>
                <strong>Estado:</strong>{" "}
                <span className={`estado estado-${pedido.estado}`}>
                  {pedido.estado}
                </span>
              </p>
            </div>

            {/* ACCIÓN: mostrar botón si está en entrega, si no mostrar mensaje rojo */}
            {pedido.estado === "EN_ENTREGA" ? (
              <button
                className="realizar-btn"
                onClick={() => navigate(`/pedidos/localizacion`)}
              >
                VER LOCALIZACIÓN
              </button>
            ) : (
              <p className="localizacion-no">Localización no disponible</p>
            )}

          </div>
        ))}
      </div>
    </div>
  );
}
