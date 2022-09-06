import { client } from "./apiClient";

export const loginUser = async ({email, password}) => {
    const { data } = await client.post('/auth/login', {username: email, password});
    return data;
}