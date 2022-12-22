import { useState } from "react";

const App = () => {
  const [planets] = useState([
    "Mars",
    "Venus",
    "Jupiter",
    "Earth",
    "Saturn",
    "Neptune",
  ]);
  return (
    <>
      <ul className="list-group">
        {planets.map((p) => {
          return <li className="list-group-item">{p}</li>;
        })}
      </ul>
    </>
  );
};

export default App;
