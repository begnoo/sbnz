import { Button, Flex} from "@chakra-ui/react";
import { Link } from "react-router-dom";
import { NAVBAR_ROUTES} from "../../routes";

export default function NavBar() {
    
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
        </Flex>
    );

}