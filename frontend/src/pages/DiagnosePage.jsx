import {
  Box,
  Button,
  Center,
  CircularProgress,
  useToast,
} from "@chakra-ui/react";
import QuestionForm from "../components/QuestionForm";
import { useMutation, useQuery } from "react-query";
import { useState, useEffect } from "react";
import { readQuestion } from "../services/questionService";
import { addFailure } from "../services/failureSevice";
import InstructionsInfo from "../components/InstructionsInfo";
import { useParams } from "react-router";
import AddAnswerForm from "../components/AddAnswerForm";
import AddQuestionForm from "../components/AddQuestionForm";
import AddFailureForm from "../components/AddFailureForm";

export default function DiagnosePage() {
  const { mode } = useParams();

  const [questionId, setQuestionId] = useState(mode == "user" ? 3 : 5);
  const [isEditMode, setIsEditMode] = useState(mode == "obd-add");
  const [lastAnswerId, setLastAnswerId] = useState(-1);

  const [failureRequest, setFailureRequest] = useState({
    vehicleManufacturer: "DEFAULT",
    vehicleModel: "DEFAULT",
    vehicleYear: "DEFAULT",
  });
    const [questionStack, updateQuestionStack] = useState([]);
    
  const {
    isLoading,
    data: questionData,
    refetch,
  } = useQuery("question", () => readQuestion(questionId));

  const toast = useToast();

  const { isLoading: isPostingFailure, mutate: postFailure } = useMutation(
    addFailure,
    {
      onSuccess: (res) => {
        toast({
          title: "Success.",
          description: `You've successfully detected a problem.`,
          status: "success",
          duration: 3000,
          position: "top",
          isClosable: true,
        });
        setInstructions(res);
        console.log(res);
      },
      onError: (err) => {
        toast({
          title: "Failure.",
          description: `Couldn't detect vehicle problem: ${err.response.message}`,
          status: "error",
          duration: 3000,
          position: "top",
          isClosable: true,
        });
      },
    }
  );
  const [instructions, setInstructions] = useState();

    useEffect(() => {
    if (mode == "user") {
        setQuestionId(3);
        setIsEditMode(false);
    } else if (mode == 'obd') {
        setQuestionId(5);
        setIsEditMode(false);
    } else if (mode == 'obd-add') {
      setIsEditMode(true);
    }
  }, [mode]);

  useEffect(() => {
    if (questionId !== -1) {
      console.log("wut " + questionId);
      refetch();
    } else {
      postFailure(failureRequest);
    }
  }, [questionId]);
    
    const addAnswer = (answer) => {
                console.log(questionData);
        questionData.answers.push(answer);
        console.log("AAAAAAAA",  questionData);
    };

  return (
    <Center>
      <Box
        width={"100%"}
        color="white"
        borderRadius="5"
        borderWidth={"2px"}
        padding={"20px"}
      >
        {!isLoading && !isPostingFailure && !instructions && questionData && (
          <QuestionForm
            question={questionData.question}
            answers={questionData.answers}
            callback={(id, answerText, answerId) => {
              setLastAnswerId(answerId)
              id !== -1 && questionStack.push(questionId);
              id === -1 &&
                setFailureRequest({
                  ...failureRequest,
                  questionId: questionId,
                  answerValue: answerText,
                });
              setQuestionId(id);
            }}
          />
        )}

        <Box>
          {isEditMode && instructions && instructions.part === "UNKNOWN" && (
            <AddQuestionForm answerId={lastAnswerId} callback={(questionId) => setQuestionId(questionId)} />
          )}
          {isEditMode && (
            <AddAnswerForm onAddAnswer={addAnswer} questionId={questionId} />
          )}
        </Box>

        {isEditMode && instructions && instructions.part === "UNKNOWN" && (
          <Box padding={"20px"}>
            <h1>Or write a new failure if possible</h1>{" "}
          </Box>
        )}

        {isEditMode && instructions && instructions.part === "UNKNOWN" && (
          <AddFailureForm questionId={lastAnswerId} />
        )}

        {!isLoading &&
          !isPostingFailure &&
          !instructions &&
          questionStack &&
          questionStack.length !== 0 && (
            <Button
              marginTop={"10px"}
              marginLeft={"10px"}
              onClick={() => {
                const lastQuestionId = questionStack.pop();
                updateQuestionStack([...questionStack]);
                setQuestionId(lastQuestionId);
              }}
            >
              Back
            </Button>
          )}

        {!isPostingFailure &&
          instructions &&
          !(isEditMode && instructions.part === "UNKNOWN") && (
            <>
              <InstructionsInfo
                part={instructions.part}
                instructions={instructions.instructions}
              />

              <Button
                marginTop={"10px"}
                marginLeft={"10px"}
                onClick={() => {
                  setFailureRequest({
                    vehicleManufacturer: "DEFAULT",
                    vehicleModel: "DEFAULT",
                    vehicleYear: "DEFAULT",
                  });
                  setInstructions(null);
                  updateQuestionStack([]);
                  setQuestionId(mode == "user" ? 3 : 5);
                }}
              >
                Reset
              </Button>
            </>
          )}

        <Center>
          {isLoading || (isPostingFailure && <CircularProgress />)}
        </Center>
      </Box>
    </Center>
  );
}
