export const HOME_PAGE = "/:mode";
export const USER_PAGE = "/user";
export const OBD_PAGE = "/obd";
export const LOGIN_PAGE = "/login";
export const ADD_OBD_CODE = "/obd-add";

export const NAVBAR_ROUTES = [
    { 
        name: "USER",
        href: USER_PAGE,
    },
    { 
        name: "OBD",
        href: OBD_PAGE,
    },
    {
        name: "ADD OBD CODE",
        href: ADD_OBD_CODE,
    }
];

export const CRED_ROUTES = [
    { 
        name: "LOGIN",
        href: LOGIN_PAGE,
    },
];