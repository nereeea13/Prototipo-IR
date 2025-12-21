import React from "react";
import { useNavigate } from "react-router-dom";
import { ArrowLeft, Download } from "lucide-react";
import "./consultarMetricas.css";

export default function ConsultarMetricas() {
  const navigate = useNavigate();

  return (
    <div className="metricas-container">

      {/* HEADER */}
      <header className="metricas-header">
        <button className="back-btn" onClick={() => navigate(-1)}>
          <ArrowLeft size={28} />
        </button>
        <h2>Consultar métricas</h2>
      </header>

      {/* LISTADO DE INFORMES */}
      <div className="metricas-lista">

        <div
          className="metrica-card"
          onClick={() => navigate("/metricas/inventario")}
        >
          <Download size={28} />
          <span>Informe de inventario</span>
        </div>

        <div
          className="metrica-card"
          onClick={() => navigate("/metricas/eficiencia-logistica")}
        >
          <Download size={28} />
          <span>Informe de eficiencia logística</span>
        </div>

        <div
          className="metrica-card"
          onClick={() => navigate("/metricas/cumplimiento-horarios")}
        >
          <Download size={28} />
          <span>Informe de cumplimiento de horarios</span>
        </div>

      </div>

      {/* BOTÓN FINAL */}
      <div className="metricas-footer">
        <button
          className="descargar-todo-btn"
          onClick={() => navigate("/metricas/descargar-todos")}
        >
          <Download size={22} />
          Descargar todos
        </button>
      </div>

    </div>
  );
}
