import React, { useState, useEffect } from 'react';
import { useNavigate } from "react-router-dom";
import './solicitudesCambioEmpleados.css';



export default function SolicitudesCambioEmpleados() {
    const empleadoId = localStorage.getItem("empleadoId");
    const [solicitudes, setSolicitudes] = useState([]);
    const [loading, setLoading] = useState(true);
    const navigate = useNavigate();
    // eslint-disable-next-line no-unused-vars
    const [aplicada, setAplicada] = useState(false);
    // eslint-disable-next-line no-unused-vars
    const [error, setError] = useState(null);

    useEffect(() => {
        cargarSolicitudes();
    }, []);

    const cargarSolicitudes = async () => {
        try {
            const response = await fetch('/api/solicitudes/anunciadas');
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const data = await response.json();
            console.log("Datos recibidos:", data);
            setSolicitudes(Array.isArray(data) ? data : []);
        } catch (error) {
            console.error('Error cargando solicitudes:', error);
            setSolicitudes([]);
        } finally {
            setLoading(false);
        }
    };
    const aplicar = async (solicitud)=> {
       try {
            const response = await fetch('/api/solicitudes/aplicar', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(empleadoId ? { ...solicitud, empleadoAplicadoId: parseInt(empleadoId) } : solicitud)
            });
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            setAplicada(true);
            const data = await response.json();
            console.log("Datos recibidos:", data);
            setSolicitudes(Array.isArray(data) ? data : []);
        } catch (error) {
            console.error('Error cargando solicitudes:', error);
            setSolicitudes([]);
        } finally {
            setLoading(false);
        }
    };

    if (loading) return <div className="loading">Cargando...</div>;
    if (error) return <div>Error: {error}</div>;


    return (
        <div className="generar-horario-page">
            <header className="generar-header">
                <button className="back-btn" onClick={() => navigate(-1)}>
                ←
                </button>
                <h2>Solicitudes de cambio</h2>
            </header>
            <div>
                {solicitudes.map((solicitud, index) => (
                    <div key={index} style={{ border: '1px solid #ccc', padding: '10px', marginBottom: '10px', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                        <div>
                            <p><strong>Empleado Solicitante:</strong> {solicitud.empleadoSolicitanteId}</p>
                            <p><strong>Motivo:</strong> {solicitud.motivo}</p>
                            <p><strong>Fecha:</strong> {solicitud.fecha}</p>
                            <p><strong>Horario:</strong> {solicitud.horario}</p>
                            <p><strong>Estado:</strong> {solicitud.estado}</p>
                        </div>
                        <button onClick={() => aplicar(solicitud)} style={{ backgroundColor: 'blue', color: 'white', border: 'none', padding: '8px 16px', borderRadius: '4px', cursor: 'pointer' }}>{aplicada ? "Aplicada" : "Aplicar"}</button>
                    </div>
                ))}
            </div>
        </div>
    );
}