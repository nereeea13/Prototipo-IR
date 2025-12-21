import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import "./editarEmpleado.css";

export default function EditarEmpleado({ apiBase = "/api/empleados" }) {
  const { id } = useParams();
  const navigate = useNavigate();

  const [values, setValues] = useState({
    nombre: "",
    apellidos: "",
    dni: "",
    telefono: "",
    email: "",
    contratoHorasSemanales: "",
    preferenciaTurno: "",
    rol: ""
  });

  const [loading, setLoading] = useState(true);
  const [saving, setSaving] = useState(false);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch(`${apiBase}/${id}`)
      .then(r => r.json())
      .then(data => {
        setValues({
          nombre: data.nombre || "",
          apellidos: data.apellidos || "",
          dni: data.dni || "",
          telefono: data.telefono || "",
          email: data.email || "",
          contratoHorasSemanales: data.contratoHorasSemanales || "",
          preferenciaTurno: data.preferenciaTurno || "",
          rol: data.rol || ""
        });
        setLoading(false);
      });
  }, [id, apiBase]);

  const changeField = (k, v) =>
    setValues(prev => ({ ...prev, [k]: v }));

  async function handleSubmit(e) {
    e.preventDefault();
    setSaving(true);

    await fetch(`${apiBase}/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(values)
    });

    navigate(`/empleados/${id}`);
  }

  if (loading) return <div className="center">Cargando...</div>;

  return (
    <div className="editar-empleado-desktop">

      {/* HEADER */}
      <div className="detalle-header">
        <button className="back-btn" onClick={() => navigate(-1)}>←</button>
        <h2>{values.nombre} {values.apellidos}</h2>
      </div>

      {/* AVATAR */}
      <div className="detalle-avatar">
        <div className="avatar" />
      </div>

      {/* FORM */}
      <form className="form-vertical" onSubmit={handleSubmit}>

        <div className="fila">
          <span>Nombre:</span>
          <input value={values.nombre} onChange={e => changeField("nombre", e.target.value)} />
        </div>

        <div className="fila">
          <span>Apellidos:</span>
          <input value={values.apellidos} onChange={e => changeField("apellidos", e.target.value)} />
        </div>

        <div className="fila">
          <span>DNI:</span>
          <input value={values.dni} onChange={e => changeField("dni", e.target.value)} />
        </div>

        <div className="fila">
          <span>Teléfono:</span>
          <input value={values.telefono} onChange={e => changeField("telefono", e.target.value)} />
        </div>

        <div className="fila">
          <span>Email:</span>
          <input value={values.email} onChange={e => changeField("email", e.target.value)} />
        </div>

        <div className="fila">
          <span>Horas semanales:</span>
          <input value={values.contratoHorasSemanales} onChange={e => changeField("contratoHorasSemanales", e.target.value)} />
        </div>

        <div className="fila">
          <span>Preferencias:</span>
          <input value={values.preferenciaTurno} onChange={e => changeField("preferenciaTurno", e.target.value)} />
        </div>

        <div className="fila">
          <span>Rol:</span>
          <input value={values.rol} onChange={e => changeField("rol", e.target.value)} />
        </div>

        {error && <p className="error">{error}</p>}

        <button className="confirmar-btn" type="submit" disabled={saving}>
          Confirmar
        </button>

      </form>
    </div>
  );
}
