import { useState } from "react";

const App = () => {
  const [option] = useState([
    { label: "Lime", value: "lime" },
    { label: "Lavender", value: "lavender" },
    { label: "Crimson", value: "crimson" },
    { label: "Darkblue", value: "darkblue" },
    { label: "Teal", value: "teal" },
    { label: "Ghost White", value: "ghostwhite" },
    { label: "Aqua Marine", value: "aquamarine" },
    { label: "Alice Blue", value: "aliceblue" },
  ]);
  const [color, setcolor] = useState(option[0].value);
  return (
    <>
      <select
        class="form-select"
        style={{ backgroundColor: color }}
        onChange={(e) => setcolor(e.target.value)}>
        {option.map((o) => {
          return (
            <option style={{ backgroundColor: o.value }}>{o.label}</option>
          );
        })}
      </select>
      <div
        style={{
          width: "25%",
          height: "20vh",
          border: "2px solid black",
          borderRadius: "10px",
          marginLeft: "35%",
          backgroundColor: color,
        }}></div>
    </>
  );
};

export default App;
