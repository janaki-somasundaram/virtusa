import React, { useEffect, useState } from "react";

import DragNDrop from "./components/DragNDrop";

const defaultData = [
  { title: "group 1", items: ["Clean the rooms", "Complete your chores"] },
  { title: "group 2", items: ["Buy milk"] },
  { title: "group 3", items: ["Go Walking"] },
];

function App() {
  const [data, setData] = useState();
  const [val, setval] = useState();
  const [i, seti] = useState(0);
  useEffect(() => {
    localStorage.clear();
    if (localStorage.getItem("List")) {
      setData(JSON.parse(localStorage.getItem("List")));
    } else {
      setData(defaultData);
    }
  }, [setData]);
  const submit = () => {
    // console.log(val);
    const y = data;
    y[0]["items"].push(val);
    setData(y);
    setval("");
    seti(0);
  };
  const rend = () => {
    if (i === 0) {
      return (
        <div>
          <DragNDrop data={data} />
        </div>
      );
    } else {
      return (
        <div>
          <input
            type="text"
            value={val}
            onChange={(e) => setval(e.target.value)}
          />
          <input type="submit" onClick={submit} />
        </div>
      );
    }
  };
  const check = () => {
    if (i === 0) {
      return (
        <button className="btn btn-success" onClick={() => seti(1)}>
          New Task
        </button>
      );
    }
  };
  return (
    <div className="App">
      <h1>To Do List Application</h1>

      <header className="App-header">
        {check()}
        {rend()}
      </header>
    </div>
  );
}

export default App;
