import { useState } from "react";

const App = () => {
  const [data, setdata] = useState([
    [
      "Neo.ai",
      "lamneo.ai emphasized my coding knowledge by teaching me a different approach in solving all the coding problems.",
    ],
    [
      "Exam.ly",
      "Before starting this course, I couldn't compile a code properly. Now I can solve complex problems. I have good Knowledge of all the progamming languages I have learnt.",
    ],
  ]);
  const [name, setName] = useState("");
  const [com, setcom] = useState("");
  const submit = () => {
    setdata([...data, [name, com]]);
    setName("");
    setcom("");
  };
  return (
    <>
      <div
        style={{
          width: "100%",
          height: "auto",
          border: "2px solid black",
          boxSizing: "border-box",
          margin: "0",
        }}>
        <h1 style={{ backgroundColor: "blue", color: "white" }}>
          Comments about Course
        </h1>
        <div className="row">
          <div
            style={{ width: "50%", border: "2px solid black" }}
            className="col">
            {data.map((d) => {
              return (
                <div>
                  <h1>{d[0]}</h1>
                  <p style={{ wordBreak: "normal" }}>{d[1]}</p>
                </div>
              );
            })}
          </div>
          <div className="col">
            <div
              style={{
                border: "2px solid black",
                borderRadius: "10px",
                width: "60%",
                height: "65vh",
                marginLeft: "20%",
                marginTop: "5%",
                padding: "5%",
              }}>
              <h5>Share your Experience</h5>
              <div className="mb-3 mt-3">
                <label for="email">Name:</label>
                <input
                  type="text"
                  className="form-control"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                />
              </div>
              <div className="mb-3 mt-3">
                <label for="email">Comments:</label>
                <textarea
                  value={com}
                  onChange={(e) => setcom(e.target.value)}
                  cols="30"
                  rows="3"></textarea>
              </div>
              <button
                type="submit"
                style={{ width: "100%" }}
                className="btn btn-primary"
                onClick={submit}>
                submit
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default App;
