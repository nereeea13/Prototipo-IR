import { useState, useEffect } from 'react';
import { useNavigate } from "react-router-dom";
import "./generarHorarios.css";
import "./visualizarTurnos.css";

export default function SolicitudesCambiosJefe() {
    const [solicitudes, setSolicitudes] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    console.log("Solicitudes:", solicitudes);
    useEffect(() => {
        cargarSolicitudes();
    }, []);

    const cargarSolicitudes = async () => {
        try {
            setLoading(true);
            const response = await fetch('/api/solicitudes/pendientes');
            
            if (!response.ok) {
                throw new Error('Error al cargar solicitudes');
            }
            
            const data = await response.json();
            console.log("Solicitudes cargadas:", data);
            setSolicitudes(data);
            setError(null);
        } catch (err) {
            setError(err.message);
            setSolicitudes([]);
        } finally {
            setLoading(false);
        }
    };

    const anunciarSolicitud = async (solicitud) => {
        try {
            const response = await fetch(`/api/solicitudes/${solicitud.id}/anunciar`, {
                method: 'POST',
            });
            
            if (!response.ok) {
                throw new Error('Error al anunciar solicitud');
            }
            
            cargarSolicitudes();
        } catch (err) {
            setError(err.message);
        }
    };

    if (loading) return <div>Cargando solicitudes...</div>;
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
                        {solicitud.estado === 'PENDIENTE_DE_ANUNCIO' && (
                            <button onClick={() => anunciarSolicitud(solicitud)} style={{ backgroundColor: 'red', color: 'white', border: 'none', padding: '10px 15px', cursor: 'pointer' }}>
                                Anunciar
                            </button>
                        )}
                    </div>
                ))}
            </div>
        </div>
    );
}