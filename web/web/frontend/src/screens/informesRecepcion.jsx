import React from "react";
import { useNavigate } from "react-router-dom";
import { ArrowLeft, Download } from "lucide-react";
import "./informesRecepcion.css";

export default function InformesRecepcion() {
  const navigate = useNavigate();

  // ⚠️ Datos solo visuales
  const informes = [13, 14, 15, 16];

  return (
    <div className="infrec-container">

      {/* HEADER */}
      <header className="infrec-header">
        <button className="infrec-back" onClick={() => navigate(-1)}>
          <ArrowLeft size={28} />
        </button>
        <h2>Informes de recepción</h2>
      </header>

      {/* LISTADO */}
      <div className="infrec-lista">
        {informes.map(id => (
          <div key={id} className="infrec-card">
            <div className="infrec-icon">
              <Download size={34} />
            </div>

            <div className="infrec-info">
              <p>Informe de recepción del pedido <strong>{id}</strong></p>
            </div>

            <button
              className="infrec-ver-btn"
              onClick={() => navigate(`/informes/recepcion/${id}`)}
            >
              Ver
            </button>
          </div>
        ))}
      </div>

      {/* FOOTER */}
      <footer className="infrec-footer">
        <button className="infrec-descargar-todo">
          Descargar todos
        </button>
      </footer>

    </div>
  );
}
