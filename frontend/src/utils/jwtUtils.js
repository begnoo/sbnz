
import { isEmpty } from "./general";

export const addIntoLocalStorage = (key, data) => {
    const data_string = JSON.stringify(data)
    localStorage.setItem(key, data_string);
};

export const addUserIntoLocalStorage = (user) => {
    addIntoLocalStorage("user", user);
}

export const getObjectFromLocalStorage = (key) => {
    if (key === null) {
        return "";
    }
    const storageObject = localStorage.getItem(key);
    if (storageObject === null) {
        return "";
    }
    return JSON.parse(storageObject);
};

export const getUserFromLocalStorage = () => {
    return getObjectFromLocalStorage("user");
}

export const userPresent = () => {
    return getUserFromLocalStorage() !== null && !isEmpty(getUserFromLocalStorage());
}

export function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
};