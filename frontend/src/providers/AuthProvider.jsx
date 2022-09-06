import React, { useState } from "react";
import { addUserIntoLocalStorage, getUserFromLocalStorage, parseJwt } from "../utils/jwtUtils";

// Provider for user auth and data
export const AuthContext = React.createContext({});

export const AuthProvider = ({ children }) => {
    
    const [user, setUser] = useState(null);

    const login = () => {
        const jwtObject = parseJwt(getUserFromLocalStorage().jwt);
        const roles = jwtObject.roles;
        const email = jwtObject.sub;

        setUser({
            email,
            roles
        });
    };

    const logout = () => {
        setUser(null);
        addUserIntoLocalStorage({});
    };

    return (
        <AuthContext.Provider value={{
            user,
            login,
            logout 
        }}>
            {children}
        </AuthContext.Provider>
    );
};