import { Box, Input } from "@chakra-ui/react";
import { useEffect, useState } from "react";
import { addAnswer } from "../services/questionService";
import { useMutation, useQuery } from "react-query";
import { useQueryClient } from "react-query";

export default function AddAnswerForm(props) {
  const [answerText, setAnswerText] = useState("");

  const queryClient = useQueryClient();
  const {
    isLoading,
    data: questionData,
    refetch,
  } = useMutation(addAnswer, {
    enabled: false,
  });

  const { isLoading: isPostingFailure, mutate: postFailure } = useMutation(
    addAnswer,
    {
      onSuccess: (res) => {
        queryClient.invalidateQueries("question");
      },
      onError: (err) => {
        console.log("nije");
      },
    }
  );

  const onKeyDownHandler = (event) => {
    if (event.key === "Enter") {
      // refetch();
      postFailure({
        questionId: props.questionId,
        answerText: event.target.value,
      });
    }
  };

  const changeHandler = (event) => {
    setAnswerText(event.target.value);
  };

  return (
    <>
      <Box
        //   key={answer.id}
        //color="white"
        //borderRadius="5"
        //borderWidth={"2px"}
        padding={"10px"}
        marginTop={"20px"}
        _hover={{
          background: "gray.400",
          color: "black",
          cursor: "pointer",
        }}
        //   onClick={() => changeQuestion(answer)}
      >
        <Input
          placeholder="Add an answer..."
          onKeyDown={onKeyDownHandler}
          onChange={changeHandler}
        />
      </Box>
    </>
  );
}
