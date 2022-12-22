import Header from "./Header";
import Nav from "./Nav";
const Component2 = () => {
    return (<>
        <Nav />
        <Header />
        <div style={{ width: "80%", height: "20vh", border: "2px solid black", borderRadius: "10px", textAlign: "center", backgroundColor: "lightblue", marginLeft: "10%" }}>
            <h1 style={{ marginTop: "2%" }}> Components2</h1>
        </div>
    </>);
}

export default Component2;