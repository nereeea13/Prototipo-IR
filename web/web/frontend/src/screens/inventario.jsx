import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./inventario.css";

const CATEGORIES = [
  { label: "Todas", value: "" },
  { label: "Frescos", value: "FRESCOS" },
  { label: "Congelados", value: "CONGELADOS" },
  { label: "Despensa", value: "DESPENSA" },
  { label: "Bebidas", value: "BEBIDAS" },
  { label: "Hogar", value: "HOGAR" },
  { label: "Cuidado personal", value: "CUIDADO_PERSONAL" },
];

function stockState(qty) {
  if (qty <= 10) return { label: "BAJO", className: "badge--low" };
  if (qty > 100) return { label: "SOBRESTOCK", className: "badge--over" };
  return { label: "NORMAL", className: "badge--normal" };
}

export default function InventarioTienda() {
  const navigate = useNavigate();

  const [productos, setProductos] = useState([]);
  const [categoriaSeleccionada, setCategoriaSeleccionada] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  // modal
  const [productoEditando, setProductoEditando] = useState(null);
  const [nuevaCantidad, setNuevaCantidad] = useState("");
  const [motivo, setMotivo] = useState("");

  /* =========================
     FETCH PRODUCTOS
     ========================= */
  const fetchProductos = async (categoria = "") => {
    setLoading(true);
    setError(null);

    try {
      const url = categoria
        ? `/api/productos/categoria/${encodeURIComponent(categoria)}`
        : `/api/productos`;

      const res = await fetch(url, { headers: { Accept: "application/json" } });
      if (!res.ok) throw new Error("Error al cargar productos");

      const data = await res.json();
      setProductos(Array.isArray(data.productos) ? data.productos : []);
    } catch (err) {
      setError(err.message);
      setProductos([]);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchProductos();
  }, []);

  useEffect(() => {
    fetchProductos(categoriaSeleccionada);
  }, [categoriaSeleccionada]);

  /* =========================
     PUT ACTUALIZAR STOCK
     ========================= */
  const guardarCambios = async () => {
    if (!productoEditando) return;

    try {
      const res = await fetch(
        `/api/productos/${productoEditando.id}/stock`,
        {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            stockTotal: Number(nuevaCantidad),
          }),
        }
      );

      if (!res.ok) throw new Error("No se pudo actualizar el stock");

      await fetchProductos(categoriaSeleccionada);

      setProductoEditando(null);
      setNuevaCantidad("");
      setMotivo("");
    } catch (err) {
      alert(err.message);
    }
  };

  /* =========================
     RENDER
     ========================= */
  return (
    <div className="inv-page">

      {/* HEADER */}
      <header className="inv-header">
        <button className="inv-back" onClick={() => navigate(-1)}>←</button>
        <h2>Inventario de la tienda</h2>
      </header>

      {/* CONTROLES */}
      <div className="inv-controls">
        <select
          className="inv-select"
          value={categoriaSeleccionada}
          onChange={(e) => setCategoriaSeleccionada(e.target.value)}
        >
          {CATEGORIES.map((c) => (
            <option key={c.value} value={c.value}>
              {c.label}
            </option>
          ))}
        </select>

        <div className="inv-actions">
          <button className="btn-filter">Filtros</button>
          <button className="btn-sort">Ordenar por...</button>
        </div>
      </div>

      {loading && <p>Cargando productos...</p>}
      {error && <p className="error">{error}</p>}

      {/* LISTA */}
      <ul className="inv-list">
        {productos.length === 0 && !loading ? (
          <li className="empty">No hay productos</li>
        ) : (
          productos.map((p) => {
            const state = stockState(p.cantidadTotal);

            return (
              <li className="inv-card" key={p.id}>
                <img className="inv-img" src={p.foto} alt={p.nombre} />

                <div className="inv-content">
                  <div className="inv-title">{p.nombre}</div>

                  <div className="inv-meta">
                    <span>Cantidad:</span> {p.cantidadTotal} uds.
                  </div>

                  <div className="inv-meta">
                    Estado stock:
                    <span className={`badge ${state.className}`}>
                      {state.label}
                    </span>
                  </div>

                  <a
                    href="#"
                    className="inv-edit"
                    onClick={(e) => {
                      e.preventDefault();
                      setProductoEditando(p);
                      setNuevaCantidad(p.cantidadTotal);
                    }}
                  >
                    Editar cantidad
                  </a>
                </div>
              </li>
            );
          })
        )}
      </ul>

      {/* MODAL */}
      {productoEditando && (
        <div className="modal-overlay">
          <div className="modal-card">

            <h3>Editar cantidad</h3>

            <input
              type="number"
              value={nuevaCantidad}
              onChange={(e) => setNuevaCantidad(e.target.value)}
            />

            <p><strong>Motivo del cambio:</strong></p>

            {["CADUCIDAD", "ROBO", "ROTURA", "OTRO"].map((m) => (
              <label key={m}>
                <input
                  type="radio"
                  name="motivo"
                  value={m}
                  onChange={(e) => setMotivo(e.target.value)}
                />
                {m.charAt(0) + m.slice(1).toLowerCase()}
              </label>
            ))}

            <div className="modal-actions">
              <button onClick={() => setProductoEditando(null)}>
                Cancelar
              </button>
              <button onClick={guardarCambios}>
                Guardar cambios
              </button>
            </div>

          </div>
        </div>
      )}

    </div>
  );
}
