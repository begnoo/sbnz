import { Button, Flex} from "@chakra-ui/react";
import { useContext } from "react";
import { Link } from "react-router-dom";
import { AuthContext } from "../../providers/AuthProvider";
import { CRED_ROUTES, NAVBAR_ROUTES} from "../../routes";

export default function NavBar() {

    const { user, logout } = useContext(AuthContext);
    
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