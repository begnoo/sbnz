import { Box, Text } from "@chakra-ui/react";

export default function InstructionsInfo({part, instructions}) {

    return (
        <>
            <Box
             fontSize={"24px"}   
            >{part}</Box>

            <Box
                // marginTop={'10px'}
                padding={'10px'}
            >
                <Text>
                    {instructions}
                </Text>
            </Box>
        </>
    );

}