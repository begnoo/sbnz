import { Routes, Route } from "react-router-dom";
import { HOME_PAGE} from "../routes";
import DiagnosePage from "../pages/DiagnosePage";

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