import { useEffect, useState } from "react";

function App() {
  const [mensaje, setMensaje] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/api/hola")
      .then(res => res.text())
      .then(data => setMensaje(data))
      .catch(err => console.error(err));
  }, []);

  return (
    <h1>{mensaje}</h1>
  );
}

export default App;
