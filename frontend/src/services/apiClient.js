import axios from "axios";
// import { addUserIntoSessionStorage, getUserFromSessionStorage } from "../utils/jwtUtils";


const client = axios.create({
  baseURL: "http://localhost:8080",
  headers: {
    "Content-type": "application/json",
  }
});

// client.interceptors.request.use(function (config) {
//   const user = getUserFromSessionStorage();

//   let token = "";
 
//   if (user !== null) {
//     token = user.jwt;
//   }
  
//   config.headers.Authorization =  `Bearer ${token}`;

//   return config;
// });

export { client };