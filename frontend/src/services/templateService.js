import { client } from "./apiClient";

export const addTemplateRule = async (templateData) => {
  const { data } = await client.post("/template/create", { ...templateData });
  return data;
};
