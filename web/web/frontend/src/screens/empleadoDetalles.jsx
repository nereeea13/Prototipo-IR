import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import "./detallesEmpleado.css";

export default function EmpleadoDetalles({ id: propId, apiBase = "/api/empleados" }) {
  const { id: paramId } = useParams();
  const navigate = useNavigate();
  const id = propId ?? paramId;

  const [empleado, setEmpleado] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch(`${apiBase}/${id}`)
      .then(r => {
        if (!r.ok) throw new Error("Empleado no encontrado");
        return r.json();
      })
      .then(setEmpleado)
      .catch(e => setError(e.message))
      .finally(() => setLoading(false));
  }, [id, apiBase]);

  if (loading) return <div className="center">Cargando...</div>;
  if (error) return <div className="center error">Error: {error}</div>;
  if (!empleado) return null;

  return (
    <div className="empleado-detalle-desktop">

      {/* Header */}
      <div className="detalle-header">
        <button onClick={() => navigate("/empleados")} className="back-btn">←</button>
        <h2>{empleado.nombre} {empleado.apellidos}</h2>
      </div>

      {/* Avatar */}
      <div className="detalle-avatar">
        <div className="avatar">
          {empleado.foto
            ? <img src={empleado.foto} alt="avatar" />
            : <div className="avatar-placeholder" />}
        </div>
      </div>

      {/* Datos */}
      <div className="detalle-datos">
        <p><strong>Nombre:</strong> {empleado.nombre}</p>
        <p><strong>Apellidos:</strong> {empleado.apellidos}</p>
        <p><strong>DNI:</strong> {empleado.dni}</p>
        <p><strong>Teléfono:</strong> {empleado.telefono}</p>
        <p><strong>Email:</strong> {empleado.email}</p>
        <p><strong>Horas semanales:</strong> {empleado.contratoHorasSemanales}</p>
        <p><strong>Preferencias:</strong> {empleado.preferenciaTurno}</p>
        <p><strong>Rol:</strong> {empleado.rol}</p>
      </div>

      {/* Botón */}
      <div className="detalle-footer">
        <button
          className="editar-btn"
          onClick={() => navigate(`/empleados/${empleado.id}/editar`)}
        >
          Editar
        </button>
      </div>

    </div>
  );
}
