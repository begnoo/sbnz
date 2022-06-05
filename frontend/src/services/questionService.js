import { client } from "./apiClient";

export const readQuestion = async (id) => {
    const { data } = await client.get('/questions/' + id);
    return data;
}