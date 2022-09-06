import { useToast } from "@chakra-ui/react"

export const useRequestToast = (successMessage, failureMessage) => {
    const toast = useToast();

    const toastSuccess = () => {
        toast({
            title: 'Success.',
            description: successMessage,
            status: 'success',
            duration: 1000,
            position: "top",
            isClosable: true,
        });
    }

    const toastFailure = (err) => {
        const backendError = err.response?.data;
        toast({
            title: 'Failure.',
            description: `${failureMessage}: ${backendError.error}`,
            status: 'error',
            duration: 2000,
            position: "top",
            isClosable: true,
        });
    }

    return {
        toastSuccess, toastFailure
    }
}