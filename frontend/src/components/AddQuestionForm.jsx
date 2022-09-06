import { Input, Box, useToast } from "@chakra-ui/react";
import { useMutation } from "react-query";
import { addQuestion } from "../services/questionService";

export default function AddQuestionForm(props) {
  const toast = useToast();

  const [
    createQuestion,
  ] = useMutation(addQuestion, {
    onSuccess: (res) => {
      toast({
        title: "Success.",
        description: `You've successfully created a question.`,
        status: "success",
        duration: 3000,
        position: "top",
        isClosable: true,
      });
      props.callback(res.data.id)
    },
    onError: (err) => {
      console.log("nije");
    }
  });

  const keyDownHandler = (e) => {
    if (e.key === "Enter" && e.target.value.trim().length > 0) {
      createQuestion({
        questionText: e.target.value,
        answerId: props.answerId
      });
      console.log("Enter");
    }
  };

  return (
    <>
      <Box padding={"10px"}>
        <Input
          onKeyDown={keyDownHandler}
          placeholder="Write question for the user..."
        />
      </Box>
    </>
  );
}
