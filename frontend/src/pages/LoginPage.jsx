import { Button, Flex, FormControl, FormLabel, Input } from "@chakra-ui/react";
import { useContext, useState } from "react";
import { useMutation } from "react-query";
import { useNavigate } from "react-router";
import { useRequestToast } from "../hooks/useRequestToast";
import { AuthContext } from "../providers/AuthProvider";
import { loginUser } from "../services/authService";
import { addUserIntoLocalStorage } from "../utils/jwtUtils";

export default function LoginPage() {

    const navigate = useNavigate();
    const { toastSuccess, toastFailure } = useRequestToast("You've successfully logged in.", "Couldn't login");
    const { login } = useContext(AuthContext);
    const [ email, setEmail ] = useState("");
    const [ password, setPassword ] = useState("");

    const { mutate: postLoginInfo } = useMutation(
        loginUser,
        {
            onSuccess: (res) => {
                toastSuccess();
                addUserIntoLocalStorage(res);
                login();
                setTimeout(() => navigate("/user"), 500);
            },
            onError: (err) => {
                toastFailure(err);
            }
        }
    );

    const onSubmit = (e) => {
        e.preventDefault();
        postLoginInfo({email, password});
    }

    return (
        <form onSubmit={onSubmit}>
            <FormControl mt="4px">
                <FormLabel fontSize={"14px"} htmlFor='email'>Email</FormLabel>
                <Input
                    id='email'
                    placeholder='Email'
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />
            </FormControl>

            <FormControl mt="4px">
                <FormLabel fontSize={"14px"} htmlFor='password'>Password</FormLabel>
                <Input
                    id='password'
                    placeholder='Password'
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
            </FormControl>

            <Flex justifyContent="space-between" alignItems={"center"}>
                <Button
                    mt={5}
                    colorScheme='teal'
                    variant="outline"
                    type='submit'>
                    Log in
                </Button>
            </Flex>

        </form>
    );
}