import { client } from "./apiClient";

export const readQuestion = async (id) => {
    const { data } = await client.get('/questions/' + id);
    return data;
};

export const addAnswer = async ({ questionId, answerText }) => {
    const answerDto = { questionId: questionId, answerText: answerText };
    const { data } = await client.post('/questions/addAnswer', answerDto);
    return data;
};
 
export const addQuestion = async ({ questionText, answerId }) => {
  const questionDto = { questionText: questionText, answerId: answerId };
  const { data } = await client.post("/questions/addQuestion", questionDto);
  return data;
};