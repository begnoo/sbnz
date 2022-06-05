import { client } from "./apiClient";

export const addFailure = async (failureData) => {
    const { data } = await client.post('/diagnose/', {...failureData});
    return data;
}