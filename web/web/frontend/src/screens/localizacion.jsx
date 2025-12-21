import React from "react";
import { useNavigate } from "react-router-dom";
import "./localizacion.css";

export default function Localizacion() {
  const navigate = useNavigate();

  return (
    <div className="localizacion-root">

      {/* HEADER */}
      <div className="localizacion-header">
        <button onClick={() => navigate(-1)} className="back-btn">←</button>
        <h2>Localización</h2>
      </div>

      {/* IMAGEN */}
      <div className="localizacion-image-wrap">
        <img
          src="/images/localizacion.png"
          alt="Localización del pedido"
          onError={(e) => {
            e.currentTarget.onerror = null;
            e.currentTarget.alt = "No se pudo cargar la imagen";
          }}
        />
      </div>

    </div>
  );
}
