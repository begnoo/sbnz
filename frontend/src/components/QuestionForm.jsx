import { Box } from "@chakra-ui/react";

export default function QuestionForm({question, answers, callback}) {

    const changeQuestion = (answer) => {
        const {followUpQuestion} = answer;

        if (followUpQuestion == null) {
            callback(-1, answer.answerText);
        }
        else {
            callback(followUpQuestion.id);
        }
    }

    return (
        <>
            <Box
             fontSize={"24px"}   
            >{question}</Box>

            <Box
                // marginTop={'10px'}
                padding={'10px'}
            >
                {answers && answers.map((answer) => (
                    <Box
                        key={answer.id}
                        color='white' 
                        borderRadius="5" 
                        borderWidth={"2px"}
                        padding={"10px"}
                        marginTop={"20px"}
                        _hover={{
                            background: "gray.400",
                            color: "black",
                            cursor: "pointer"
                        }}
                        onClick={() => changeQuestion(answer)}
                    >
                        {answer.answerText}
                    </Box>
                ))}
            </Box>
        </>
    );

}