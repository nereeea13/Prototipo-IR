import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./generarHorarios.css";
import "./visualizarTurnos.css";

export default function VisualizarTurnos() {
  const empleadoId = localStorage.getItem("empleadoId");
  console.log("empleadoId:", empleadoId);
  const navigate = useNavigate();
  const [turnos, setTurnos] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const [mostrarModal, setMostrarModal] = useState(false);
  const [textoSolicitud, setTextoSolicitud] = useState("");
  const [turnoSeleccionado, setTurnoSeleccionado] = useState(null);

  console.log("Turnos:", turnos);
  console.log("turnboSeleccionado:", turnoSeleccionado);


  const fetchAleatorios = async () => {
    setLoading(true);
    setError(null);
    try {
      const res = await fetch(`/api/empleados/id/${empleadoId}/turnos/vigente`);
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

   console.log(turnos);

  const [successMessage, setSuccessMessage] = useState("");

  return (
    <div className="generar-horario-page">
      <header className="generar-header">
        <button className="back-btn" onClick={() => navigate(-1)}>
          ←
        </button>
        <h2>Tu horario</h2>
      </header>

      {error && <p className="error">{error}</p>}
      {successMessage && <p className="success">{successMessage}</p>}

     
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
                onClick={() => {
                  setTurnoSeleccionado(t);
                  setMostrarModal(true);
                }}
              >
                Solicitar cambio
              </button>
            </div>
          ))
        )}
      </div>

      {mostrarModal && (
        <div className="modal-overlay">
          <div className="modal">
            <h3>Solicitar cambio de turno</h3>

            <p>
              <strong>Fecha:</strong> {turnoSeleccionado?.dia}<br />
              <strong>Horario:</strong> {turnoSeleccionado?.horario}
            </p>

            <textarea
              placeholder="Escribe el motivo del cambio..."
              value={textoSolicitud}
              onChange={(e) => setTextoSolicitud(e.target.value)}
            />

            <div className="modal-buttons">
              <button
                className="btn-cancelar"
                onClick={() => {
                  setMostrarModal(false);
                    setTextoSolicitud("");
                  }}
                  >
                  Cancelar
                  </button>

                  <button
                  className="btn-aceptar"
                  onClick={async () => {
                    try {
                    const response = await fetch("/api/solicitudes", {
                      method: "POST",
                      headers: {
                      "Content-Type": "application/json",
                      },
                      body: JSON.stringify({
                      fecha: turnoSeleccionado?.dia,
                      horario: turnoSeleccionado?.horario,
                      motivo: textoSolicitud,
                      empleadoSolicitanteId: empleadoId,
                      }),
                    });

                    if (!response.ok) throw new Error("Error al solicitar cambio");

                    setSuccessMessage("¡Solicitud creada correctamente!");
                    setTimeout(() => setSuccessMessage(""), 3000);
                  } catch (error) {
                    console.error(error);
                    setError(error.message);
                  } finally {
                    setMostrarModal(false);
                    setTextoSolicitud("");
                  }
                }}
              >
                Aceptar
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}
