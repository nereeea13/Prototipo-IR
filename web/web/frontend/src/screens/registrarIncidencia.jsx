import React, { useEffect, useState } from "react";
import { useParams, useNavigate, useLocation } from "react-router-dom";
import "./registrarIncidencia.css";

export default function RegistrarIncidencia() {
  const { id } = useParams();
  const navigate = useNavigate();
  const location = useLocation();

  const state = location.state || {};
  const [pedido, setPedido] = useState(state.pedido || null);
  const [recibidos, setRecibidos] = useState(state.recibidos || {});
  const [lineaStatus, setLineaStatus] = useState({}); // correct | incorrect
  const [loading, setLoading] = useState(!state.pedido);
  const [error, setError] = useState(null);

  useEffect(() => {
    if (!pedido) {
      fetch(`/api/pedidos/detalle?id=${id}`)
        .then(res => res.ok ? res.json() : Promise.reject())
        .then(data => {
          setPedido(data);
          const map = {};
          data.lineas.forEach(l => {
            map[l.producto.id] = 0;
          });
          setRecibidos(map);
        })
        .catch(() => setError("No se pudo cargar el pedido"))
        .finally(() => setLoading(false));
    }
  }, [id]);

  if (loading) return <p>Cargando...</p>;
  if (error) return <div className="reg-inc-error">{error}</div>;
  if (!pedido) return <p>Pedido no encontrado</p>;

  function calcularFaltante(linea) {
    const recib = Number(recibidos[linea.producto.id] ?? 0);
    const ped = Number(linea.cantidadSolicitada ?? 0);
    return Math.max(0, ped - recib);
  }

  async function handleRegistrarIncidencia() {
    const lineas = Object.keys(recibidos)
      .filter(pid => lineaStatus[pid] === "incorrect")
      .map(pid => ({
        productoId: Number(pid),
        cantidadRecibida: Number(recibidos[pid])
      }));

    try {
      const res = await fetch(`/api/pedidos/${id}/llegada`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ lineas })
      });

      if (!res.ok) throw new Error();
      alert("Incidencia registrada correctamente");
      navigate("/pedidos-en-entrega");
    } catch {
      setError("Error registrando incidencia");
    }
  }

  return (
    <div className="reg-inc-container">

      {/* HEADER */}
      <header className="reg-inc-header">
        <button className="reg-inc-back" onClick={() => navigate(-1)}>←</button>
        <h2>Registrar incidencia</h2>
      </header>

      {/* LISTADO */}
      <div className="reg-inc-lista">
        {pedido.lineas.map(linea => {
          const pid = linea.producto.id;
          return (
            <div key={linea.id} className="reg-inc-card">

              <img
                src={linea.producto.foto}
                alt={linea.producto.nombre}
                className="reg-inc-img"
              />

              <div className="reg-inc-info">
                <p><strong>Nombre:</strong> {linea.producto.nombre}</p>
                <p><strong>Solicitado:</strong> {linea.cantidadSolicitada}</p>

                <div className="reg-inc-actions">
                  <button
                    className={`reg-btn-ok ${lineaStatus[pid] === "correct" ? "active" : ""}`}
                    onClick={() =>
                      setLineaStatus(s => ({ ...s, [pid]: "correct" }))
                    }
                  >
                    Cantidad correcta
                  </button>

                  <button
                    className={`reg-btn-error ${lineaStatus[pid] === "incorrect" ? "active" : ""}`}
                    onClick={() =>
                      setLineaStatus(s => ({ ...s, [pid]: "incorrect" }))
                    }
                  >
                    Cantidad incorrecta
                  </button>
                </div>

                {lineaStatus[pid] === "incorrect" && (
                  <div className="reg-inc-extra">
                    <label>
                      Recibido:
                      <input
                        type="number"
                        min="0"
                        value={recibidos[pid]}
                        onChange={e =>
                          setRecibidos(r => ({ ...r, [pid]: Number(e.target.value) }))
                        }
                      />
                    </label>
                    <p><strong>Faltante:</strong> {calcularFaltante(linea)}</p>
                  </div>
                )}

                {lineaStatus[pid] === "correct" && (
                  <div className="reg-inc-ok-msg">
                    Marcado como correcto — no se incluirá
                  </div>
                )}
              </div>
            </div>
          );
        })}
      </div>

      {/* FOOTER */}
      <div className="reg-inc-footer">
        <button className="reg-inc-cancel" onClick={() => navigate(-1)}>
          Cancelar
        </button>
        <button className="reg-inc-submit" onClick={handleRegistrarIncidencia}>
          Generar pedido
        </button>
      </div>

    </div>
  );
}
