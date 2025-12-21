import React from "react";
import { useNavigate } from "react-router-dom";
import "./informeInventario.css";

export default function InformeRe() {
  const navigate = useNavigate();

  return (
    <div className="localizacion-root">

      {/* HEADER */}
      <div className="localizacion-header">
        <button onClick={() => navigate("/informes-recepción")} className="back-btn">←</button>
        <h2>Informe de recepcion del pedido 13 </h2>
      </div>

      {/* IMAGEN */}
      <div className="localizacion-image-wrap">
        <img
          src="/images/rece.jpeg"
          alt="Informe de logística"
          onError={(e) => {
            e.currentTarget.onerror = null;
            e.currentTarget.alt = "No se pudo cargar la imagen";
          }}
        />
      </div>

      {/* BOTÓN DESCARGAR */}
      <div className="informe-footer">
        <button className="btn-descargar">
          Descargar
        </button>
      </div>

    </div>
  );
}
