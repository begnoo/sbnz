import { Routes, Route } from "react-router-dom";
import { HOME_PAGE, ADD_OBD_CODE } from "../routes";
import DiagnosePage from "../pages/DiagnosePage";
// import AddCodePage from "../pages/AddCodePage";

export default function Router() {
    return (
      <Routes>
        <Route
          exact
          path={HOME_PAGE}
          element={<DiagnosePage/>}
        />
      </Routes>
    );
  }