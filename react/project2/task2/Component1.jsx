import Header from "./Header";
import Nav from "./Nav";
const Component1 = () => {
    return (<>
        <Nav />
        <Header />
        <div style={{ width: "80%", height: "20vh", border: "2px solid black", borderRadius: "10px", textAlign: "center", backgroundColor: "green", marginLeft: "10%" }}>
            <h1 style={{ marginTop: "2%" }}> Components1</h1>
        </div>
    </>);
}

export default Component1;