import { Input, Box } from "@chakra-ui/react";
import { addTemplateRule } from "../services/templateService";
import { useState } from "react";
import { useMutation } from "react-query";

export default function AddFailureForm(props) {
  console.log(props.questionId);
  const [failureName, setFailureName] = useState("");

  const {
    isLoading,
    data: questionData,
    refetch,
  } = useMutation(addTemplateRule, {
    onSuccess: (res) => {
      console.log("jej");
    },
    onError: (err) => {
      console.log("nije");
    },
    //   enabled: false,
  });

  const keyDownHandler = (e) => {
    if (e.key === "Enter" && failureName.trim().length > 0) {
      addTemplateRule({
        questionId: props.questionId,
        answerText: e.target.value,
        part: failureName,
      });
      console.log("Enter");
    }
  };

  const onChangeHandler = (e) => {
    setFailureName(e.target.value);
  };
  return (
    <>
      <Box
        width={"100%"}
        color="white"
        borderRadius="5"
        borderWidth={"2px"}
        // padding={"20px"}
      >
        <Box padding={"10px"}>
          <Input value={onChangeHandler} placeholder="Name of the failure..." />
        </Box>
        <Box padding={"10px"}>
          <Input
            onKeyDown={keyDownHandler}
            placeholder="Advice to the user..."
          />
        </Box>
      </Box>
    </>
  );
}
