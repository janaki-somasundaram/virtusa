import axios from "axios";
import { useState } from "react";
const App = () => {
  const [data, setdata] = useState("Programming");

  const submit = () => {
    axios
      .get(
        "https://en.wikipedia.org/w/api.php?action=query&prop=extracts&origin=*&format=json&generator=search&gsrnamespace=0&gsrlimit=1&gsrsearch=" +
          data
      )
      .then((response) => {
        for (var y in response.data.query.pages) {
          document.querySelector(".y").innerHTML =
            response.data.query.pages[y]["extract"];
        }
      });
  };
  return (
    <>
      <input
        type="text"
        placeholder="Enter the data to be searched"
        value={data}
        onChange={(e) => setdata(e.target.value)}
      />
      <input type="submit" onClick={submit} />
      <div className="y"></div>
    </>
  );
};

export default App;
