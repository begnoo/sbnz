import { Routes, Route } from "react-router-dom";
import { HOME_PAGE, LOGIN_PAGE, OBD_PAGE, ADD_OBD_CODE} from "../routes";
import DiagnosePage from "../pages/DiagnosePage";
import LoginPage from "../pages/LoginPage";

export default function Router() {
    return (
      <Routes>
        <Route
          exact
          path={HOME_PAGE}
          element={<DiagnosePage/>}
        />
        <Route
          exact
          path={LOGIN_PAGE}
          element={<LoginPage/>}
        />
      </Routes>
    );
  }