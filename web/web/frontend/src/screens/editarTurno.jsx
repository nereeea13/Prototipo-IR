import React, { useState, useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import "./generarHorarios.css";

export default function EditarTurno() {
  const navigate = useNavigate();
  const location = useLocation();
  const turno = location.state?.turno;

  const [fecha, setFecha] = useState( turno?.dia || "" );
  const [horaInicio, setHoraInicio] = useState( turno?.horario?.split("-")?.[0] || "" );
  const [horaFin, setHoraFin] = useState( turno?.horario?.split("-")?.[1] || "" );
  const [empleadoId, setEmpleadoId] = useState( turno?.empleadoId || "" );
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    if (!turno || !turno.id) {
      // if no turno in state, redirect back
      navigate(-1);
    }
  }, [turno, navigate]);

  const handleGuardar = async () => {
    setLoading(true);
    setError(null);
    try {
      const body = {
        fecha: fecha,
        horaInicio: horaInicio,
        horaFin: horaFin,
        empleadoId: empleadoId ? Number(empleadoId) : null
      };

      const res = await fetch(`/api/turnos/${turno.id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
      });

      if (!res.ok) throw new Error("Error al actualizar turno");
      navigate(-1);
    } catch (e) {
      console.error(e);
      setError(e.message || "Error al actualizar turno");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="generar-horario-page">
      <header className="generar-header">
        <button className="back-btn" onClick={() => navigate(-1)}>←</button>
        <h2>Editar turno</h2>
      </header>

      <div className="edit-card">
        <label>
          Fecha
          <input type="date" value={fecha} onChange={e => setFecha(e.target.value)} />
        </label>

        <label className="field">
          Hora inicio
          <input type="time" value={horaInicio} onChange={e => setHoraInicio(e.target.value)} />
        </label>

        <label className="field">
          Hora fin
          <input type="time" value={horaFin} onChange={e => setHoraFin(e.target.value)} />
        </label>


        {error && <div className="error">{error}</div>}

        <div className="acciones-horario" style={{ marginTop: 20 }}>
          <button className="btn-secundario" onClick={() => navigate("/generar-horario")} disabled={loading}>Cancelar</button>
          <button className="btn-primario" onClick={handleGuardar} disabled={loading}>Guardar</button>
        </div>
      </div>
    </div>
  );
}
