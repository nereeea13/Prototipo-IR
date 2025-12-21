import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import "./realizarPedido.css";

export default function EditarPedido() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [pedido, setPedido] = useState(null);
  const [productos, setProductos] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const [newProductId, setNewProductId] = useState("");
  const [newProductQty, setNewProductQty] = useState("");

  /* ================= CARGA PEDIDO ================= */
  useEffect(() => {
    Promise.all([
      fetch(`/api/pedidos/detalle?id=${id}`).then(r => r.json()),
      fetch(`/api/productos`).then(r => r.json())
    ])
      .then(([pedidoData, productosData]) => {
        setPedido(pedidoData);
        setProductos(productosData.productos || productosData);
      })
      .catch(() => setError("No se pudo cargar la información"))
      .finally(() => setLoading(false));
  }, [id]);

  /* ================= CAMBIAR CANTIDAD ================= */
  function handleCantidadChange(lineaId, value) {
    setPedido(p => ({
      ...p,
      lineas: p.lineas.map(l =>
        l.id === lineaId
          ? { ...l, cantidadSolicitada: Number(value) }
          : l
      )
    }));
  }

  /* ================= AÑADIR PRODUCTO ================= */
  function handleAddLinea() {
    const producto = productos.find(p => p.id === Number(newProductId));
    const qty = Number(newProductQty);

    if (!producto || qty <= 0) {
      setError("Selecciona un producto y una cantidad válida");
      return;
    }

    setPedido(p => ({
      ...p,
      lineas: [
        ...p.lineas,
        {
          id: `new-${producto.id}-${Date.now()}`,
          producto,
          cantidadSolicitada: qty,
          cantidadRecibida: 0
        }
      ]
    }));

    setNewProductId("");
    setNewProductQty("");
    setError(null);
  }

  /* ================= GUARDAR ================= */
  async function handleGuardar() {
    const body = {
      lineas: pedido.lineas.map(l => ({
        productoId: l.producto.id,
        cantidadSolicitada: l.cantidadSolicitada
      }))
    };

    try {
      const res = await fetch(`/api/pedidos/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body)
      });

      if (!res.ok) throw new Error();
      navigate(-1);
    } catch {
      setError("Error al guardar cambios");
    }
  }

  if (loading) return <p>Cargando pedido...</p>;
  if (!pedido) return <p>Pedido no encontrado</p>;

  return (
    <div className="realizar-container">

      {/* HEADER */}
      <div className="realizar-header">
        <button className="back-btn" onClick={() => navigate(-1)}>←</button>
        <h2>Editar pedido</h2>
      </div>

      {/* ===== AÑADIR PRODUCTO CENTRADO ===== */}
      <div className="add-product-wrapper">
        <div className="add-product-card">
          <h3>Añadir producto</h3>

          <select
            value={newProductId}
            onChange={e => setNewProductId(e.target.value)}
          >
            <option value="">Selecciona un producto</option>
            {productos.map(p => (
              <option key={p.id} value={p.id}>
                {p.nombre}
              </option>
            ))}
          </select>

          <input
            type="number"
            min="1"
            placeholder="Cantidad"
            value={newProductQty}
            onChange={e => setNewProductQty(e.target.value)}
          />

          <button onClick={handleAddLinea}>Añadir</button>
        </div>
      </div>

      {/* ===== LISTADO ===== */}
      <div className="productos-lista">
        {pedido.lineas.map(linea => (
          <div key={linea.id} className="producto-card">
            <img
              src={linea.producto?.foto || ""}
              alt={linea.producto?.nombre}
              className="producto-img"
            />
            <div className="producto-info">
              <p><strong>Nombre:</strong> {linea.producto?.nombre}</p>
              <p>
                <strong>Cantidad:</strong>{" "}
                <input
                  type="number"
                  min="0"
                  value={linea.cantidadSolicitada}
                  onChange={e =>
                    handleCantidadChange(linea.id, e.target.value)
                  }
                />
              </p>
            </div>
          </div>
        ))}
      </div>

      {/* ===== ACCIONES ===== */}
      <div className="acciones">
        <button className="btn-secundario" onClick={() => navigate(-1)}>
          Cancelar
        </button>
        <button className="btn-primario" onClick={handleGuardar}>
          Guardar cambios
        </button>
      </div>

      {error && <div className="error-msg">{error}</div>}
    </div>
  );
}
