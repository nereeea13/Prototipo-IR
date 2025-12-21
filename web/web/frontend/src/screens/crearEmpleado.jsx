import React, { useState } from "react";
import "./CrearEmpleado.css";

export default function CrearEmpleado({ apiBase = "/api/empleados", onCreated }) {
  const [values, setValues] = useState({
    nombre: "",
    apellidos: "",
    dni: "",
    telefono: "",
    email: "",
    contratoHorasSemanales: "",
    preferenciaTurno: "",
    rol: "",
    foto: ""
  });

  const [saving, setSaving] = useState(false);
  const [error, setError] = useState(null);

  const changeField = (k, v) =>
    setValues(prev => ({ ...prev, [k]: v }));

  async function handleSubmit(e) {
    e.preventDefault();
    setError(null);

    if (!values.nombre.trim()) {
      setError("El nombre es obligatorio");
      return;
    }

    setSaving(true);
    try {
      const res = await fetch(apiBase, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(values)
      });

      if (!res.ok) throw new Error("Error al crear empleado");

      const created = await res.json();
      onCreated ? onCreated(created) : window.history.back();
    } catch (err) {
      setError(err.message);
    } finally {
      setSaving(false);
    }
  }

  return (
    <div className="nuevo-empleado">

      {/* Header */}
      <div className="nuevo-empleado-header">
        <button className="back-btn" onClick={() => window.history.back()}>
          ←
        </button>
        <h2>Nuevo Empleado</h2>
      </div>

      {/* Foto */}
      <div className="foto-box">
        <div className="foto-placeholder">+</div>
        <span>Añadir foto</span>
        <input
          type="text"
          placeholder="URL foto (opcional)"
          value={values.foto}
          onChange={e => changeField("foto", e.target.value)}
        />
      </div>

      {/* Formulario */}
      <form onSubmit={handleSubmit} className="form-col">
        <label>
          Nombre:
          <input value={values.nombre} onChange={e => changeField("nombre", e.target.value)} />
        </label>

        <label>
          Apellidos:
          <input value={values.apellidos} onChange={e => changeField("apellidos", e.target.value)} />
        </label>

        <label>
          DNI:
          <input value={values.dni} onChange={e => changeField("dni", e.target.value)} />
        </label>

        <label>
          Teléfono:
          <input value={values.telefono} onChange={e => changeField("telefono", e.target.value)} />
        </label>

        <label>
          Email:
          <input value={values.email} onChange={e => changeField("email", e.target.value)} />
        </label>

        <label>
          Horas semanales:
          <input
            value={values.contratoHorasSemanales}
            onChange={e => changeField("contratoHorasSemanales", e.target.value)}
          />
        </label>

        <label>
          Preferencias:
          <input
            value={values.preferenciaTurno}
            onChange={e => changeField("preferenciaTurno", e.target.value)}
          />
        </label>

        <label>
          Rol:
          <input value={values.rol} onChange={e => changeField("rol", e.target.value)} />
        </label>

        {error && <p className="error">{error}</p>}

        <button type="submit" className="confirmar-btn" disabled={saving}>
          {saving ? "Guardando..." : "Confirmar"}
        </button>
      </form>
    </div>
  );
}
