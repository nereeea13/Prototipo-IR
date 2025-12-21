import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./generarHorarios.css";

export default function VisualizarTurnos() {
  const navigate = useNavigate();
  const [turnos, setTurnos] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const fetchAleatorios = async () => {
    setLoading(true);
    setError(null);
    try {
      const res = await fetch("/api/horarios/vigente/turnos/aleatorios");
      if (!res.ok) throw new Error("No se pudieron cargar los turnos");
      const data = await res.json();
      setTurnos(Array.isArray(data) ? data : []);
    } catch (e) {
      console.error(e);
      setError(e.message);
      setTurnos([]);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchAleatorios();
  }, []);

  return (
    <div className="generar-horario-page">
      <header className="generar-header">
        <button className="back-btn" onClick={() => navigate(-1)}>
          ←
        </button>
        <h2>Tu horario</h2>
      </header>

      {/* removed manual refresh button; list auto-loads on mount */}

      {error && <p className="error">{error}</p>}

      <div className="turnos-list">
        {turnos.length === 0 && !loading ? (
          <div>No hay turnos</div>
        ) : (
          turnos.map((t, idx) => (
            <div key={idx} className="turno-card">
              <div className="turno-info">
                <div>
                  <strong>Fecha:</strong> {t.dia}
                </div>
                <div>
                  <strong>Horario:</strong> {t.horario}
                </div>

              </div>

              <button
                className="btn-solicitar"
                onClick={() => navigate('/gestionar-cambios')}
              >
                Solicitar cambio
              </button>
            </div>
          ))
        )}
      </div>
    </div>
  );
}
