import { Button, Flex, useToast} from "@chakra-ui/react";
import { useContext, useEffect } from "react";
import { Link } from "react-router-dom";
import { AuthContext } from "../../providers/AuthProvider";
import { CRED_ROUTES, NAVBAR_ROUTES} from "../../routes";

// const host = "https://localhost:8082/";
let sockets = [];

export default function NavBar() {

    const { user, logout } = useContext(AuthContext);
    const toast = useToast();

    useEffect(() => {
        let newSocket = (window).io.connect(`http://localhost:9092/events`);

        newSocket.on('connect', () => {
            console.log("connected")
        })

        newSocket.on('disconnent', () => {
            console.log("molim")
        })
    
        newSocket.on('event', (event) => {
            console.log(event)
            toast({
                title: `Device ${event.type} alarm.`,
                status: 'warning',
                duration: 3000,
                position: "top",
                isClosable: true,
                });
        });
        sockets.push(newSocket);
    }, []);
    
    return (
        <Flex padding={"15px"} alignContent="space-between" justifyContent={"space-between"}>
            <Flex>
                {NAVBAR_ROUTES.map((route, rid) => (
                    <Link key={rid} to={route.href}>
                        <Button variant="ghost" aria-label="Home" my={5} w="100%">
                            {route.name}
                        </Button>
                    </Link>
                ))}
            </Flex>
            <Flex>
                {user === null && CRED_ROUTES.map((route, rid) => (
                    <Link key={rid} to={route.href}>
                        <Button variant="ghost" aria-label="Home" my={5} w="100%">
                            {route.name}
                        </Button>
                    </Link>
                ))}
                {user !== null && 
                    <Link to={"/user"}>
                        <Button variant="ghost" aria-label="Home" my={5} w="100%" onClick={logout}>
                            LOGOUT
                        </Button>
                    </Link>
                }
            </Flex>
        </Flex>
    );

}