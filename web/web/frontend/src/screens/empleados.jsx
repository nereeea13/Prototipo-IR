import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";   // ← necesario para navegar
import "./empleados.css";

export default function Empleados({ apiBase = "/api/empleados" }) {
  const [empleados, setEmpleados] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const navigate = useNavigate(); // ← hook para navegar

  useEffect(() => {
    setLoading(true);
    fetch(apiBase)
      .then((r) => {
        if (!r.ok) throw new Error(`HTTP ${r.status}`);
        return r.json();
      })
      .then((data) => {
        const lista = Array.isArray(data)
          ? data
          : data && Array.isArray(data.empleados)
          ? data.empleados
          : [];
        setEmpleados(lista);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, [apiBase]);

  function renderAvatarOrImage(emp, size = 80) {
    const foto = emp?.foto;
    const dimension = `${size}px`;

    if (foto) {
      const src = foto.startsWith("http")
        ? foto
        : `${window.location.origin}${foto}`;
      return (
        <img
          src={src}
          alt={emp.nombre + " " + (emp.apellidos || "")}
          style={{
            width: dimension,
            height: dimension,
            borderRadius: "9999px",
            objectFit: "cover",
          }}
          onError={(e) => {
            e.currentTarget.onerror = null;
            e.currentTarget.style.display = "none";
          }}
        />
      );
    }

    const initials = (emp.nombre || "?")
      .split(" ")
      .map((s) => s[0])
      .slice(0, 2)
      .join("")
      .toUpperCase();

    return (
      <div
        style={{ width: dimension, height: dimension }}
        className="rounded-full bg-gray-300 flex items-center justify-center text-lg font-bold text-gray-700"
      >
        {initials}
      </div>
    );
  }

  if (loading)
    return (
      <div className="min-h-screen w-screen flex items-center justify-center p-4">
        Cargando empleados...
      </div>
    );

  if (error)
    return (
      <div className="min-h-screen w-screen flex items-center justify-center p-4 text-red-600">
        Error: {error}
      </div>
    );

  return (
    <div className="empleados-root">

        <header className="empleados-header">
        <button
            className="empleados-back-btn"
            onClick={() => navigate("/jefe")}
        >
            ←
        </button>

        <h1 className="empleados-title">Empleados</h1>
        </header>

      {/* Lista */}
      <div className="empleados-grid">
        {empleados.map((e) => (
          <div key={e.id} className="empleado-card">
            
            {/* Avatar */}
            <div className="empleado-avatar">{renderAvatarOrImage(e)}</div>

            {/* Información */}
            <div className="empleado-info">
              <div className="empleado-nombre">
                <strong>Nombre:</strong> {e.nombre}
              </div>
              <div className="empleado-nombre">
                <strong>Apellidos:</strong> {e.apellidos}
              </div>
            </div>

            {/* Botón */}
            <div className="empleado-actions">
              <button
                className="empleado-btn"
                onClick={() => navigate(`/empleados/${e.id}`)}
              >
                Ver
              </button>
            </div>

          </div>
        ))}
      </div>

      {/* BOTÓN AÑADIR EMPLEADO */}
      <div className="empleados-footer" style={{ marginTop: "30px" }}>
        <button
          className="add-btn"
          onClick={() => navigate("/empleados/nuevo")}
        >
          Añadir empleado +
        </button>
      </div>
    </div>
  );
}
