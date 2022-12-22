import { useState } from "react";

const App = () => {
  const [img1, setimg1] = useState("");
  const [img2, setimg2] = useState("");
  const [img3, setimg3] = useState("");
  const [r, setr] = useState([]);
  const submit = () => {
    setr([img1, img2, img3]);
  };
  return (
    <>
      <div
        style={{
          width: "70%",
          marginLeft: "15%",
          border: "2px solid black",
          padding: "5%",
        }}>
        <div className="mb-3 mt-3">
          <label for="email">Image url1</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter the image url 1"
            value={img1}
            onChange={(e) => setimg1(e.target.value)}
          />
        </div>
        <div className="mb-3 mt-3">
          <label for="email">Image url1</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter the image url 2"
            value={img2}
            onChange={(e) => setimg2(e.target.value)}
          />
        </div>
        <div className="mb-3 mt-3">
          <label for="email">Image url1</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter the image url 3"
            value={img3}
            onChange={(e) => setimg3(e.target.value)}
          />
        </div>
        <button
          type="submit"
          style={{ width: "100%" }}
          className="btn btn-primary"
          onClick={submit}>
          Create
        </button>
      </div>
      <br />
      <div className="row" style={{ marginLeft: "17%" }}>
        <img src={r[0]} alt="" className="col-3" />
        <img src={r[1]} alt="" className="col-3" />
        <img src={r[2]} alt="" className="col-3" />
      </div>
    </>
  );
};

export default App;
