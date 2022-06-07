import { Box, Button, Center, CircularProgress, useToast } from "@chakra-ui/react";
import QuestionForm from "../components/QuestionForm";
import { useMutation, useQuery } from "react-query";
import { useState, useEffect } from "react";
import { readQuestion } from "../services/questionService";
import { addFailure } from "../services/failureSevice";
import InstructionsInfo from "../components/InstructionsInfo";
import { useParams } from "react-router";

export default function DiagnosePage() {

    const { mode } = useParams();
    const [questionId, setQuestionId] = useState(mode == "user" ? 3 : 5);
    const [failureRequest, setFailureRequest] = useState(
        {
            vehicleManufacturer: "DEFAULT",
            vehicleModel: "DEFAULT",
            vehicleYear: "DEFAULT",
        }
    );
    const [questionStack, updateQuestionStack] = useState([]);

    const {isLoading, data: questionData, refetch} = useQuery("question", () => readQuestion(questionId), {
        enabled: false
    });

    const toast = useToast();

    const { isLoading: isPostingFailure, mutate: postFailure } = useMutation(
        addFailure,
        {
            onSuccess: (res) => {
                toast({
                    title: 'Success.',
                    description: `You've successfully detected a problem.`,
                    status: 'success',
                    duration: 3000,
                    position: "top",
                    isClosable: true,
                  });
                setInstructions(res);
                console.log(res);
            },
            onError: (err) => {
                toast({
                    title: 'Failure.',
                    description: `Couldn't detect vehicle problem: ${err.response.message}`,
                    status: 'error',
                    duration: 3000,
                    position: "top",
                    isClosable: true,
                  });
            }
        }
    );
    const [instructions, setInstructions] = useState();

    useEffect(() => {
        if (mode == "user") {
            setQuestionId(3);
        } else {
            setQuestionId(5);
        }
        
    }, [mode]);

    useEffect(() => {
        if (questionId !== -1) {
            console.log("wut " + questionId);
            refetch();
        }
        else {
            postFailure(failureRequest);
        }
        
    }, [questionId]);

    return (
        <Center>
            <Box
            width={'100%'}
            color='white' 
            borderRadius="5" 
            borderWidth={"2px"}
            padding={"20px"} 
            >
            {!isLoading
                && !isPostingFailure 
                && !instructions
                && questionData 
                && <QuestionForm 
                        question={questionData.question} 
                        answers={questionData.answers}
                        callback={(id, answerText) => {
                            id !== -1 && questionStack.push(questionId);
                            id === -1 && setFailureRequest({...failureRequest, questionId: questionId, answerValue: answerText});
                            setQuestionId(id);
            }}/>}
            
            
            {!isLoading 
                && !isPostingFailure 
                && !instructions
                && questionStack 
                && questionStack.length !== 0
                && <Button 
                    marginTop={'10px'}
                    marginLeft={'10px'}
                    onClick={() => {
                        const lastQuestionId = questionStack.pop();
                        updateQuestionStack([...questionStack]);
                        setQuestionId(lastQuestionId);
                    }}
                    >Back</Button>
            }

            {!isPostingFailure 
                && instructions 
                && <>
                    <InstructionsInfo 
                        part={instructions.part} 
                        instructions={instructions.instructions}
                    />
                    <Button 
                        marginTop={'10px'}
                        marginLeft={'10px'}
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
                    >Reset</Button>
                </>
            }

            <Center>
                {isLoading 
                || isPostingFailure
                && <CircularProgress/>}
            </Center>
           
                </Box>
        </Center>
    );

}