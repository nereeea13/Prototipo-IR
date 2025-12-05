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
  // const BACKEND_URL = "http://localhost:8080"; // URL de tu Spring Boot
  const navigate = useNavigate();
  const [productos, setProductos] = useState([]);
  const [categoriaSeleccionada, setCategoriaSeleccionada] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  console.log('productos', productos);
  console.log('categoriaSeleccionada', categoriaSeleccionada);

  // fetch helper: si category = "" hace GET /api/productos, si no GET /api/productos/categoria/{categoria}
  const fetchProductos = async (categoria = "") => {
    setLoading(true);
    setError(null);
    try {
      const url = categoria
        ? `/api/productos/categoria/${encodeURIComponent(categoria)}`
        : `/api/productos`;
      const res = await fetch(url, {
        headers: { "Accept": "application/json" },
      });
      if (!res.ok) {
        throw new Error(`Error al recuperar productos: ${res.status}`);
      }
      const data = await res.json();
      // El backend devuelve la entidad Producto; necesitamos nombre, imagen (si existe) y cantidad.
      // Asumimos que tu Producto tiene al menos: id, nombre, fechaCaducidad, categoria, precio.
      // Si tu API no devuelve "cantidad" (stock), hay que integrar con endpoint de stock. 
      // Aquí suponemos que producto.cantidad existe para mostrar ejemplo; si no, mostramos 0.
  
      setProductos(Array.isArray(data.productos) ? data.productos : []);
    } catch (err) {
      console.error(err);
      setError(err.message || "Error desconocido");
      setProductos([]);
    } finally {
      setLoading(false);
    }
  };

  // carga inicial
  useEffect(() => {
    fetchProductos();
  }, []);

  // cuando cambia categoría
  useEffect(() => {
    fetchProductos(categoriaSeleccionada);
  }, [categoriaSeleccionada]);


  // SI NO CARGA LAS FOTOS: PONER src={`${BACKEND_URL}${p.foto}`}
  return (
    <div
      className="inv-page"
      style={{
        width: "100vw",
        maxWidth: "none",
        margin: 0,
        paddingLeft: "1rem",
        paddingRight: "1rem",
        boxSizing: "border-box",
        position: "relative",
        left: "calc(50% - 50vw)",
      }}
    >
      <header className="inv-header">
        <button className="inv-back" onClick={() => navigate(-1)}>
          &larr;
        </button>
        <h2>Inventario de la tienda</h2>
      </header>

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
          <button className="btn-filter" onClick={() => alert("Abrir filtros (pendiente)")}>
            Filtros
          </button>
          <button className="btn-sort" onClick={() => alert("Ordenar (pendiente)")}>
            Ordenar por...
          </button>
        </div>
      </div>

      {loading && <p>Cargando productos...</p>}
      {error && <p style={{ color: "red" }}>Error: {error}</p>}

      <ul className="inv-list" aria-live="polite">
        {productos.length === 0 && !loading ? (
          <li style={{ padding: "1rem", textAlign: "center" }}>No hay productos para mostrar</li>
        ) : (
          productos.map((p) => {
            const state = stockState(p.cantidad);
            return (
              <li className="inv-card" key={p.id}>
                <img className="inv-img" src={p.foto} alt={p.nombre} /> 
                <div className="inv-content">
                  <div className="inv-title">{p.nombre}</div>

                  <div className="inv-meta">
                    <span className="meta-label">Cantidad:</span>{" "}
                    <span className="meta-value">{p.cantidadTotal} uds.</span>
                  </div>

                  <div className="inv-meta">
                    <span className="meta-label">Estado stock:</span>{" "}
                    <span className={`badge ${state.className}`}>{p.estadoStock}</span>
                  </div>

                  {p.fechaCaducidad && (
                    <div className="inv-meta">
                      <span className="meta-label">Caduca:</span>{" "}
                      <span className="meta-value">{p.fechaCaducidad}</span>
                    </div>
                  )}

                  <a
                    href="#"
                    className="inv-edit"
                    onClick={(e) => {
                      e.preventDefault();
                      // aquí podrías abrir un modal con un formulario que llame PUT /stock o similar
                      alert(`Editar cantidad de: ${p.nombre}`);
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

    </div>
  );
}
