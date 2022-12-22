import { NavLink } from "react-router-dom";

const Nav = () => {
    return (
        <>
            <div className="row" style={{ marginLeft: "20%" }}>
                <NavLink to="/" className="col-2">
                    <button className="btn btn-warning  text-primary" style={{ marginRight: "25px" }}>
                        Home
                    </button>
                </NavLink>
                <NavLink to="/component1" className="col-4">
                    <button className="btn btn-warning   text-primary" style={{ marginRight: "25px" }}>Component1</button></NavLink>
                <NavLink to="/component2" className="col-2">
                    <button className="btn btn-warning  text-primary">Component2</button></NavLink>
            </div>
        </>
    );
}

export default Nav;