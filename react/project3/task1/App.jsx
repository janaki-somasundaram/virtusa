import { useState } from "react";

const App = () => {
  const [id, setid] = useState(0);
  const [title, settitle] = useState("");
  const [note, setNote] = useState("");
  const [data, setdata] = useState([]);
  const add = () => {
    setid(data.length + 1);
    var k = { title: title, note: note, id: id };
    setdata([...data, k]);
    settitle("");
    setNote("");
  };
  const deletes = (e) => {
    const d = data.filter((dx) => {
      return dx.id !== e;
    });
    setdata(d);
  };

  return (
    <>
      <div
        style={{
          width: "100%",
          height: "100vh",
          boxSizing: "border-box",
          margin: 0,
          backgroundColor: "lightgray",
        }}>
        <h1 style={{ backgroundColor: "yellow", color: "white" }}>Keeper</h1>

        <div
          style={{
            backgroundColor: "white",
            width: "40%",
            height: "28vh",
            borderRadius: "5px",
            marginLeft: "30%",
          }}>
          <input
            type="text"
            className="form-control"
            placeholder="Title"
            value={title}
            onChange={(e) => settitle(e.target.value)}
          />
          <textarea
            className="form-control"
            cols="20"
            rows="2"
            placeholder="Take a note"
            value={note}
            onChange={(e) => setNote(e.target.value)}></textarea>

          <button
            className="btn btn-warning"
            style={{
              color: "white",
              fontSize: "2vh",
              borderRadius: "70%",
              float: "right",
            }}
            onClick={add}>
            add
          </button>
        </div>
        <br />
        <br />
        <div className="row">
          {data.map((d) => {
            return (
              <div
                style={{
                  backgroundColor: "white",
                  width: "20%",
                  height: "28vh",
                  borderRadius: "5px",
                }}
                className="col-2">
                <h1>{d.title}</h1>
                <p>{d.note}</p>

                <p
                  className="text-warning"
                  style={{
                    color: "white",
                    fontSize: "2vh",
                    borderRadius: "70%",
                    float: "right",
                  }}
                  onClick={() => deletes(d.id)}>
                  delete
                </p>
              </div>
            );
          })}
        </div>
      </div>
    </>
  );
};

export default App;
