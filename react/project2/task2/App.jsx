import { Route, Routes } from "react-router-dom";
import Component1 from "./Component1";
import Component2 from "./Component2";

import Home from './Home'
const App = () => {
    return (
        <>

            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/component1" element={<Component1 />} />
                <Route path="/component2" element={<Component2 />} />
                <Route path="/*" element={<h1>error</h1>} />
            </Routes>
        </>
    );
}

export default App;