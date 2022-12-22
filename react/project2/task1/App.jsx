import { useState } from "react";

const App = () => {
  const [n, setn] = useState([]);
  const [name, setname] = useState();
  const [cno, setcno] = useState();
  const [email, setemail] = useState();
  const [img, setimg] = useState();
  const [i, seti] = useState(0);
  const submit = () => {
    setn([name, email, cno, img]);
    setname("");
    setemail("");
    setcno("");
    setimg("");
    seti(1);
  };
  const check = () => {
    if (i == 1) {
      return (
        <div
          class="card"
          style={{
            width: "400px",
            marginLeft: "30%",
            border: "2px solid black",
          }}>
          <img
            class="card-img-top"
            src={n[3]}
            alt="Card image"
            style={{ width: "100%" }}
          />
          <div class="card-body">
            <h4 class="card-title">Id:</h4>
            <h4 class="card-title">Name:{n[0]}</h4>
            <h4 class="card-title">Email:{n[1]}</h4>
            <h4 class="card-title">Contact No:{n[2]}</h4>
            <button className="btn btn-primary" onClick={() => seti(0)}>
              Delete
            </button>
          </div>
        </div>
      );
    }
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
          <label for="email">Name</label>
          <input
            type="text"
            className="form-control"
            placeholder="test"
            value={name}
            onChange={(e) => setname(e.target.value)}
          />
        </div>
        <div className="mb-3 mt-3">
          <label for="email">Email</label>
          <input
            type="text"
            className="form-control"
            placeholder="test@gmail.com"
            value={email}
            onChange={(e) => setemail(e.target.value)}
          />
        </div>
        <div className="mb-3 mt-3">
          <label for="email">Contact number</label>
          <input
            type="text"
            className="form-control"
            placeholder="123"
            value={cno}
            onChange={(e) => setcno(e.target.value)}
          />
        </div>

        <div className="mb-3 mt-3">
          <label for="email">Image url</label>
          <input
            type="text"
            className="form-control"
            placeholder="http://imageurl"
            value={img}
            onChange={(e) => setimg(e.target.value)}
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
      {check()}
    </>
  );
};

export default App;
