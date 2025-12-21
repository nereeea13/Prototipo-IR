import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./generarHorarios.css";

export default function GenerarHorario() {
  const navigate = useNavigate();

  const [empleados, setEmpleados] = useState([]);
  const [turnos, setTurnos] = useState([]);
  const [seleccion, setSeleccion] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchEmpleados();
    fetchTurnosVigente();
  }, []);

  const fetchEmpleados = async () => {
    try {
      const res = await fetch("/api/empleados");
      if (!res.ok) throw new Error("No se pudieron cargar los empleados");
      const data = await res.json();
      setEmpleados(Array.isArray(data.empleados) ? data.empleados : []);
    } catch (e) {
      console.error(e);
      setEmpleados([]);
    }
  };

  const fetchTurnosVigente = async () => {
    setLoading(true);
    setError(null);
    try {
      const res = await fetch("/api/horarios/vigente/turnos");
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

  const handleSeleccionChange = async (e) => {
    const nombre = e.target.value;
    setSeleccion(nombre);
    setLoading(true);
    setError(null);

    try {
      let res, data;
      if (!nombre) {
        res = await fetch("/api/horarios/vigente/turnos");
      } else {
        res = await fetch(
          `/api/empleados/nombre/${encodeURIComponent(
            nombre
          )}/turnos/vigente`
        );
      }

      if (!res.ok) throw new Error("No se pudieron cargar los turnos");
      data = await res.json();
      setTurnos(Array.isArray(data) ? data : []);
    } catch (e) {
      console.error(e);
      setError(e.message);
      setTurnos([]);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="generar-horario-page">
      {/* HEADER */}
      <header className="generar-header">
        <button className="back-btn" onClick={() => navigate(-1)}>
          ←
        </button>
        <h2>Generar horarios</h2>
      </header>

      {/* SELECT EMPLEADO */}
      <div className="generar-controls">
        <select value={seleccion} onChange={handleSeleccionChange}>
          <option value="">Empleado: Todos</option>
          {empleados.map((e) => (
            <option key={e.id} value={e.nombre}>
              {e.nombre}
            </option>
          ))}
        </select>
      </div>

      {loading && <p>Cargando turnos...</p>}
      {error && <p className="error">{error}</p>}

      {/* LISTADO TURNOS */}
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
                  <strong>Horario:</strong>{" "}
                  {t.horario === "LIBRE" ? (
                    <span className="libre">LIBRE</span>
                  ) : (
                    t.horario
                  )}
                </div>
              </div>

              <button
                className="btn-editar"
                onClick={() =>
                  navigate(`/horarios/editar`, { state: { turno: t } })
                }
              >
                Editar
              </button>
            </div>
          ))
        )}
      </div>

      {/* BOTONES INFERIORES */}
      <div className="acciones-horario">
        <button
          className="btn-secundario"
          onClick={() => navigate("/gestionar-horarios")}
        >
          Confirmar horario
        </button>

        <button
          className="btn-primario"
          onClick={async () => {
            setLoading(true);
            try {
              const res = await fetch('/api/horarios/cambiar', { method: 'POST' });
              if (!res.ok) throw new Error('No se pudo cambiar el horario');
              await fetchTurnosVigente();
            } catch (e) {
              console.error(e);
              setError(e.message);
            } finally {
              setLoading(false);
            }
          }}
        >
          Generar nuevo horario
        </button>
      </div>
    </div>
  );
}
